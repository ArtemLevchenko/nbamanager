package com.nbamanager.solution.entity;

/**
 *
 * @author Artem Levchenko
 * 
 */
public class Player {
    private int id;
    
    private String fname;
    private String sname;
    
    private GameSkills gameSkills;
    private MentalSkills mentalSkil;
    private Team team;
    private PlayerInfo playerInfo;

    public Player() {
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

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public GameSkills getGameSkills() {
        return gameSkills;
    }

    public void setGameSkills(GameSkills gameSkills) {
        this.gameSkills = gameSkills;
    }

    public MentalSkills getMentalSkil() {
        return mentalSkil;
    }

    public void setMentalSkil(MentalSkills mentalSkil) {
        this.mentalSkil = mentalSkil;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public PlayerInfo getPlayerInfo() {
        return playerInfo;
    }

    public void setPlayerInfo(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }
    
    
}
