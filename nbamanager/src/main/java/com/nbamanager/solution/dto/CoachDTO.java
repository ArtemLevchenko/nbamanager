package com.nbamanager.solution.dto;

import com.nbamanager.solution.entity.Coach;

/**
 *
 * @author Artem
 */
public class CoachDTO {
    private Coach homeCoach;
    private Coach awayCoach;

    public CoachDTO() {
    }

    public Coach getHomeCoach() {
        return homeCoach;
    }

    public void setHomeCoach(Coach homeCoach) {
        this.homeCoach = homeCoach;
    }

    public Coach getAwayCoach() {
        return awayCoach;
    }

    public void setAwayCoach(Coach awayCoach) {
        this.awayCoach = awayCoach;
    }
    
    
}
