package ru.asemenov.WaitNotify;

public class ProducerCustomerr {
    private final Object lock = new Object();
    private boolean blockCustomer = true;

    public void doSomething() throws InterruptedException {
        synchronized (this.lock) {
            while (this.blockCustomer) {
                System.out.println("wait");
                lock.wait();
            }
            System.out.println("work");
        }
    }

    public void changeBlock(boolean enable) {
        synchronized (this.lock) {
            System.out.println("enable");
            this.blockCustomer = enable;
            this.lock.notify();
        }
    }

    public static void main(String[] args) {
        final ProducerCustomerr blockingWork = new ProducerCustomerr();
        new Thread() {
            @Override
            public void run() {
                try {
                    blockingWork.doSomething();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                blockingWork.changeBlock(false);
            }
        }.start();
    }
}
