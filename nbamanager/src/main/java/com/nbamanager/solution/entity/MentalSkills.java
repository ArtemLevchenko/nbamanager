package com.nbamanager.solution.entity;

import com.nbamanager.solution.enums.Level;
import com.nbamanager.solution.enums.PlayerForm;
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
 * @author Artem Levchenko
 */
@Entity
@Table(name = "mentalskills")
public class MentalSkills implements Serializable{
    @Column(name = "playerForm")
    private PlayerForm playerForm;
    // форма игрока
    @Column(name = "insideoutside")
    private Level insideoutside;
    // под кольцом / из под кольца
    @Column(name = "offensedeffense")
    private Level offensedeffense;
    // атака защита
    @Column(name = "reboundpass")
    private Level reboundpass;
    // подборы / пасы
    @Column(name = "screenopening")
    private Level screenopening;
    // заслоны / открывание
    @Column(name = "deffenseInsideOutside")
    private Level deffenseInsideOutside;
    @OneToMany(mappedBy = "mentalSkills", fetch = FetchType.EAGER)
    private List<Player> playerList;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public MentalSkills() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public List<Player> getPlayerList() {
        return playerList;
    }
    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public PlayerForm getPlayerForm() {
        return playerForm;
    }

    public void setPlayerForm(PlayerForm playerForm) {
        this.playerForm = playerForm;
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

    public Level getReboundpass() {
        return reboundpass;
    }

    public void setReboundpass(Level reboundpass) {
        this.reboundpass = reboundpass;
    }

    public Level getScreenopening() {
        return screenopening;
    }

    public void setScreenopening(Level screenopening) {
        this.screenopening = screenopening;
    }

    public Level getDeffenseInsideOutside() {
        return deffenseInsideOutside;
    }

    public void setDeffenseInsideOutside(Level deffenseInsideOutside) {
        this.deffenseInsideOutside = deffenseInsideOutside;
    }
    
    
}
