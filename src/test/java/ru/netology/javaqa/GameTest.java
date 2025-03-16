package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GameTest {

    List<Player> players = new ArrayList<>();
    Player player1 = new Player(1, "Mark", 200);
    Player player2 = new Player(5, "Sonya", 100);
    Player player3 = new Player(10, "Max", 200);

    @Test
    public void ShouldFirstPlayerNotRegistered() {
        Game game = new Game();
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Mark", "Sonya"));
    }

    @Test
    public void ShouldSecondPlayerNotRegistered() {
        Game game = new Game();
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Mark", "Sonya"));
    }

    @Test
    public void ShouldAllPlayersNotRegistered() {
        Game game = new Game();


        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Mark", "Sonya"));
    }

    @Test
    public void ShouldFirstPlayerWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player2);

        int excepted = 1;
        int actual = game.round("Mark", "Sonya");

        Assertions.assertEquals(excepted, actual);

    }

    @Test
    public void ShouldSecondPlayerWin() {
        Game game = new Game();
        game.register(player2);
        game.register(player3);

        int excepted = 2;
        int actual = game.round("Sonya", "Max");

        Assertions.assertEquals(excepted, actual);

    }

    @Test
    public void ShouldNobodyWin() {
        Game game = new Game();
        game.register(player1);
        game.register(player3);

        int excepted = 0;
        int actual = game.round("Mark", "Max    ");

        Assertions.assertEquals(excepted, actual);

    }
}
