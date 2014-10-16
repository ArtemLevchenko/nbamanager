package com.nbamanager.solution.client.game;

import com.nbamanager.solution.dto.CoachDTO;
import com.nbamanager.solution.dto.PlayersOnCortDTO;

/**
 *
 * @author Artem
 */
public class GameContext {

    private PlayersOnCortDTO playersDTO;
    private CoachDTO coachDTO;

    public GameContext() {
    }

    public PlayersOnCortDTO getPlayersDTO() {
        return playersDTO;
    }

    public void setPlayersDTO(PlayersOnCortDTO playersDTO) {
        this.playersDTO = playersDTO;
    }

    public CoachDTO getCoachDTO() {
        return coachDTO;
    }

    public void setCoachDTO(CoachDTO coachDTO) {
        this.coachDTO = coachDTO;
    }
    
    
}
