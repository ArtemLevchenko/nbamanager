package com.nbamanager.solution.dto;

import com.nbamanager.solution.entity.Coach;
import com.nbamanager.solution.entity.Player;
import java.util.List;

/**
 *
 * @author Artem
 */
public class ActiveTeamOnCortDTO {
    private List<Player> activePlayers;
    private Coach activeCoach;

    public ActiveTeamOnCortDTO() {
    }

    public List<Player> getActivePlayers() {
        return activePlayers;
    }

    public void setActivePlayers(List<Player> activePlayers) {
        this.activePlayers = activePlayers;
    }

    public Coach getActiveCoach() {
        return activeCoach;
    }

    public void setActiveCoach(Coach activeCoach) {
        this.activeCoach = activeCoach;
    }
    
    
}
