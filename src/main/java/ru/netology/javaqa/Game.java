package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public Player register(Player player) {
        players.add(player);
        return player;
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок" + playerName1 + "not registered"
            );
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок" + playerName2 + "not registered"
            );
        }
        if (player1.getStrenght() > player2.getStrenght()) {
            return 1;
        }
        if (player1.getStrenght() < player2.getStrenght()) {
            return 2;
        }
        else return 0;
            }
}
