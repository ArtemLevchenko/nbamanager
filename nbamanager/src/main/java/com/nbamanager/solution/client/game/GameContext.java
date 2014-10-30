package com.nbamanager.solution.client.game;

import com.nbamanager.solution.dto.CoachDTO;
import com.nbamanager.solution.dto.CortInfoDTO;
import com.nbamanager.solution.dto.GameHistoryDTO;
import com.nbamanager.solution.dto.PlayersAllDTO;

/**
 *
 * @author Artem
 */
public class GameContext {

    private PlayersAllDTO playersDTO;
    private CoachDTO coachDTO;
    private GameHistoryDTO gameHistoryDTO;
    private CortInfoDTO gameCortInfoDTO;

    public GameContext() {
    }

    public PlayersAllDTO getPlayersDTO() {
        return playersDTO;
    }

    public void setPlayersDTO(PlayersAllDTO playersDTO) {
        this.playersDTO = playersDTO;
    }

    public CoachDTO getCoachDTO() {
        return coachDTO;
    }

    public void setCoachDTO(CoachDTO coachDTO) {
        this.coachDTO = coachDTO;
    }

    public GameHistoryDTO getGameHistoryDTO() {
        return gameHistoryDTO;
    }

    public void setGameHistoryDTO(GameHistoryDTO gameHistoryDTO) {
        this.gameHistoryDTO = gameHistoryDTO;
    }

    public CortInfoDTO getGameCortInfoDTO() {
        return gameCortInfoDTO;
    }

    public void setGameCortInfoDTO(CortInfoDTO gameCortInfoDTO) {
        this.gameCortInfoDTO = gameCortInfoDTO;
    }
    
    
}
