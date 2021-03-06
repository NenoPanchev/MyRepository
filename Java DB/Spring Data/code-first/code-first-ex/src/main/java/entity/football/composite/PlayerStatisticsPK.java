package entity.football.composite;

import entity.football.Game;
import entity.football.Player;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class PlayerStatisticsPK implements Serializable {
    private Game game;
    private Player player;

    public PlayerStatisticsPK() {
    }

    @ManyToOne
    public Game getGame() {
        return game;
    }

    public PlayerStatisticsPK setGame(Game game) {
        this.game = game;
        return this;
    }

    @ManyToOne
    public Player getPlayer() {
        return player;
    }

    public PlayerStatisticsPK setPlayer(Player player) {
        this.player = player;
        return this;
    }
}
