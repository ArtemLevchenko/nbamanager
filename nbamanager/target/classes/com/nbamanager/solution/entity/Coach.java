package com.nbamanager.solution.entity;

import java.util.List;

/**
 *
 * @author arle0814
 */
public class Coach {
    private int id;
    private String fname;
    private String lname;
    private Team team;
    private CoachMental coachMental;

    public Coach() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public CoachMental getCoachMental() {
        return coachMental;
    }

    public void setCoachMental(CoachMental coachMental) {
        this.coachMental = coachMental;
    }
    
    
}
