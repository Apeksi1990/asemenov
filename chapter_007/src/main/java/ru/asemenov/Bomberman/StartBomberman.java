package ru.asemenov.Bomberman;

import ru.asemenov.Bomberman.Elements.Monster;
import ru.asemenov.Bomberman.Elements.Player;
import ru.asemenov.Bomberman.Elements.Route;

public class StartBomberman {
    public static void main(String[] args) {
        Board game = new Board(8);
        Player player = new Player(0, 0, game.getBoard(), "Alex");
        Monster monsterOne = new Monster(1, 1, game.getBoard(), "MonsterOne");
        Monster monsterTwo = new Monster(3, 1, game.getBoard(), "MonsterTwo");

        game.addPlayer(player, 0, 0);
        game.addMonster(monsterOne,7, 2);
        game.addMonster(monsterTwo,5, 5);
        game.addBlock(2, 5);
        game.addBlock(1, 0);

        Thread playerThread = new Thread(player);
        Thread monsterOneThread = new Thread(monsterOne);
        Thread monsterTwoThread = new Thread(monsterTwo);
        playerThread.start();
        monsterOneThread.start();
        monsterTwoThread.start();
    }
}
