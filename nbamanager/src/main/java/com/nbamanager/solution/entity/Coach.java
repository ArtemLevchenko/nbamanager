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
 * @author arle0814
 */
@Entity
@Table(name = "coach")
public class Coach implements Serializable {
    @JoinColumn(name = "coachmental", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.EAGER)
    private CoachMental coachmental;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @JoinColumn(name = "team", referencedColumnName = "id")
    @ManyToOne
    private Team team;


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

    public CoachMental getCoachmental() {
        return coachmental;
    }

    public void setCoachmental(CoachMental coachmental) {
        this.coachmental = coachmental;
    }



}
