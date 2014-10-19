package com.nbamanager.solution.entity;

import com.nbamanager.solution.enums.Level;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Artem
 */
@Entity
@Table(name = "coachmental")
public class CoachMental implements Serializable{
    @Column(name = "insideoutside")
    private Level insideoutside;
    @Column(name = "offensedeffense")
    private Level offensedeffense;
    @OneToMany(mappedBy = "coachmental", fetch = FetchType.EAGER)
    private List<Coach> coachList;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public CoachMental() {
    }

    public Level getInsideoutside() {
        return insideoutside;
    }

    public void setInsideoutside(Level insideoutside) {
        this.insideoutside = insideoutside;
    }

    public Level getOffensedeffense() {
        return offensedeffense;
    }

    public void setOffensedeffense(Level offensedeffense) {
        this.offensedeffense = offensedeffense;
    }

    public List<Coach> getCoachList() {
        return coachList;
    }

    public void setCoachList(List<Coach> coachList) {
        this.coachList = coachList;
    }
    
    
}
