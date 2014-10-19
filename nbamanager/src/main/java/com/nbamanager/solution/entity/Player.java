package com.nbamanager.solution.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Artem Levchenko
 *
 */
@Entity
@Table(name = "player")
public class Player implements Serializable {
    @JoinColumn(name = "mentalSkills", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private MentalSkills mentalSkills;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "sname")
    private String sname;
    
    @JoinColumn(name = "gameSkills", referencedColumnName = "id")
    @ManyToOne
    private GameSkills gameSkills;

    @JoinColumn(name = "playerInfo", referencedColumnName = "id")
    @ManyToOne
    private PlayerInfo playerInfo;
    @JoinColumn(name = "team", referencedColumnName = "id")
    @ManyToOne
    private Team team;

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

    public MentalSkills getMentalSkills() {
        return mentalSkills;
    }

    public void setMentalSkills(MentalSkills mentalSkills) {
        this.mentalSkills = mentalSkills;
    }

   

}
