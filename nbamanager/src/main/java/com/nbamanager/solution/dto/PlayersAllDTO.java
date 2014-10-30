package com.nbamanager.solution.dto;

import com.nbamanager.solution.entity.Player;
import java.util.List;

/**
 *
 * @author Artem
 */
public class PlayersAllDTO {
    private List<Player> homePlayers;
    private List<Player> awayPlayers;

    public PlayersAllDTO() {
    }

    public List<Player> getHomePlayers() {
        return homePlayers;
    }

    public void setHomePlayers(List<Player> homePlayers) {
        this.homePlayers = homePlayers;
    }

    public List<Player> getAwayPlayers() {
        return awayPlayers;
    }

    public void setAwayPlayers(List<Player> awayPlayers) {
        this.awayPlayers = awayPlayers;
    }
    
    
}
