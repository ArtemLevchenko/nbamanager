package com.nbamanager.solution.dto;

import com.nbamanager.solution.history.GameHistory;
import java.util.List;

/**
 *
 * @author Artem
 */
public class GameHistoryDTO {

    private List<GameHistory> homeGameHistory;
    private List<GameHistory> awayGameHistory;

    public GameHistoryDTO() {
    }

    public List<GameHistory> getHomeGameHistory() {
        return homeGameHistory;
    }

    public void setHomeGameHistory(List<GameHistory> homeGameHistory) {
        this.homeGameHistory = homeGameHistory;
    }

    public List<GameHistory> getAwayGameHistory() {
        return awayGameHistory;
    }

    public void setAwayGameHistory(List<GameHistory> awayGameHistory) {
        this.awayGameHistory = awayGameHistory;
    }
}
