package ru.netology.javaqa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    HashMap<String, Player> players = new HashMap<>();

    public Player register(Player player) {
        players.put(player.getName(), player);
        return player;
    }

    public boolean findByName(String name) {
        return players.containsKey(name);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (!findByName(playerName1)) {
            throw new NotRegisteredException(
                    "Игрок" + playerName1 + "not registered"
            );
        }
        if (!findByName(playerName2)) {
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
