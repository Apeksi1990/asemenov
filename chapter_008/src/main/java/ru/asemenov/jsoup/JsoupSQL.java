package ru.asemenov.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JsoupSQL {

    private String firstURL = "http://www.sql.ru/forum/job-offers/";
    private ConnectSql connSQL;
    private int count = 1;

    JsoupSQL() {
        this.connSQL = new ConnectSql();
    }

    void start() {
        String URL = this.firstURL + this.count;
        this.count++;
        if (pars(URL)) {
            start();
        } else work();
    }

    void work() {
        try {
            Thread.sleep(86400000); // 86400000 = 1 день
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        pars(firstURL);
        work();
    }

    private Boolean pars(String URL) {
        boolean result = true;
        Document doc = null;
        try {
            doc  = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Element table = doc.select(".forumTable").get(0);
        Elements rows = table.select("tr");
        for (int i = 1; i< rows.size(); i++) {
            Element row = rows.get(i);
            Elements cols = row.select("td");
            String text = cols.get(1).text().toLowerCase();
            if (text.contains("java") & !text.contains("script")) {
                if (datePars(cols.get(5).text()).after(thisYear())) {
                    Element link = cols.get(1).select("a").first();
                    String head = link.html();
                    String linkHref = link.attr("href");
                    String author = cols.get(2).text();
                    Timestamp time = datePars(cols.get(5).text());
                    this.connSQL.addJob(head, linkHref, author, time);
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    private Timestamp datePars(String date) {
        SimpleDateFormat format = new SimpleDateFormat("d MMM yy, HH:mm", new Locale("ru", "RU"));
        Calendar calendar = Calendar.getInstance();
        if (date.contains("сегодня")) {
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(9, 11)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(12, 14)));
        } else if (date.contains("вчера")) {
            calendar.add(Calendar.DATE, -1);
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(date.substring(7, 9)));
            calendar.set(Calendar.MINUTE, Integer.parseInt(date.substring(10, 12)));
        } else {
            try {
                calendar.setTime(format.parse(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return new Timestamp(calendar.getTimeInMillis());
    }

    private Timestamp thisYear() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = dateFormat.parse("01/1/2017");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = date.getTime();
        return new Timestamp(time);
    }

    public static void main(String[] args) {
        new JsoupSQL().start();
    }
}
