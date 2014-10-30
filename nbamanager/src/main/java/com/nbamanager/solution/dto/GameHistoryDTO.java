package com.nbamanager.solution.dto;

import com.nbamanager.solution.history.GameHistory;
import java.util.List;

/**
 *
 * @author Artem
 */
public class GameHistoryDTO {

    private List<GameHistory> matchHistory;

    public GameHistoryDTO() {
    }

    public List<GameHistory> getMatchHistory() {
        return matchHistory;
    }

    public void setMatchHistory(List<GameHistory> matchHistory) {
        this.matchHistory = matchHistory;
    }
    
}
