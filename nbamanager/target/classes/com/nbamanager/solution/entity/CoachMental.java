/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.nbamanager.solution.entity;

import com.nbamanager.solution.enums.Level;

/**
 *
 * @author Artem
 */
public class CoachMental {
    private int id;
    // под кольцом / из под кольца
    private Level insideoutside;
    // атака защита
    private Level offensedeffense;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    
    
}
