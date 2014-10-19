package com.nbamanager.solution.client.game;

import com.nbamanager.solution.dto.CoachDTO;
import com.nbamanager.solution.dto.GameCortInfoDTO;
import com.nbamanager.solution.dto.GameHistoryDTO;
import com.nbamanager.solution.dto.PlayersOnCortDTO;

/**
 *
 * @author Artem
 */
public class GameContext {

    private PlayersOnCortDTO playersDTO;
    private CoachDTO coachDTO;
    private GameHistoryDTO gameHistoryDTO;
    private GameCortInfoDTO gameCortInfoDTO;

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

    public GameHistoryDTO getGameHistoryDTO() {
        return gameHistoryDTO;
    }

    public void setGameHistoryDTO(GameHistoryDTO gameHistoryDTO) {
        this.gameHistoryDTO = gameHistoryDTO;
    }

    public GameCortInfoDTO getGameCortInfoDTO() {
        return gameCortInfoDTO;
    }

    public void setGameCortInfoDTO(GameCortInfoDTO gameCortInfoDTO) {
        this.gameCortInfoDTO = gameCortInfoDTO;
    }
    
    
}
