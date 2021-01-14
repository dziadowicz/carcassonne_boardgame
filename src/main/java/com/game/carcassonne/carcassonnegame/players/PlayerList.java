package com.game.carcassonne.carcassonnegame.players;

import java.util.ArrayList;
import java.util.List;

public class PlayerList {

    private List<Player> players = new ArrayList<>();

    public PlayerList(int playersNumber) throws WrongPlayersNumberException {

        if (playersNumber < 2 || playersNumber > 6) throw new WrongPlayersNumberException();

        List<Player> allPlayers = new ArrayList<>();
        Player redPlayer = new Player("red");
        allPlayers.add(redPlayer);
        Player greenPlayer = new Player("green");
        allPlayers.add(greenPlayer);
        Player bluePlayer = new Player("blue");
        allPlayers.add(bluePlayer);
        Player yellowPlayer = new Player("yellow");
        allPlayers.add(yellowPlayer);
        Player blackPlayer = new Player("black");
        allPlayers.add(blackPlayer);
        Player greyPlayer = new Player("grey");
        allPlayers.add(greyPlayer);

        for (int i = 0; i < playersNumber; i++) {
            players.add(allPlayers.get(i));
        }
    }

    public List<Player> getPlayers() {
        return players;
    }
}
