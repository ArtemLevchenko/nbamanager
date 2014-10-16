package com.nbamanager.solution.entity;

import com.nbamanager.solution.enums.Level;
import com.nbamanager.solution.enums.PlayerForm;

/**
 *
 * @author Artem Levchenko
 */
public class MentalSkills {
    private int id;
    // форма игрока 
    private PlayerForm playerForm;
    // под кольцом / из под кольца
    private Level insideoutside;
    // атака защита
    private Level offensedeffense;
    // подборы / пасы
    private Level reboundpass;
    // заслоны / открывание
    private Level screenopening;

    public MentalSkills() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
}
