package com.nbamanager.solution.stats;

/**
 *
 * @author Artem
 */
public class IndividualGameStats {
    private int points;
    // offense reboind
    private int offrebound;
    // deff reboind
    private int defrebound;
    // assist
    private int assist;
    // pers foul
    private int personalFouls;
    // steal
    private int steals;
    // turnovers
    private int turnovers;
    // blockshots
    private int blocks;
    // all shot made
    private int fgm;
    // all shot attempt
    private int fga;
     // 3 shot made
    private int _3pm;
    // 3 shot attempt
    private int _3pa;
    // ft shot made
    private int ftm;
    // ft shot attempt
    private int fta;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getOffrebound() {
        return offrebound;
    }

    public void setOffrebound(int offrebound) {
        this.offrebound = offrebound;
    }

    public int getDefrebound() {
        return defrebound;
    }

    public void setDefrebound(int defrebound) {
        this.defrebound = defrebound;
    }

    public int getAssist() {
        return assist;
    }

    public void setAssist(int assist) {
        this.assist = assist;
    }

    public int getPersonalFouls() {
        return personalFouls;
    }

    public void setPersonalFouls(int personalFouls) {
        this.personalFouls = personalFouls;
    }

    public int getSteals() {
        return steals;
    }

    public void setSteals(int steals) {
        this.steals = steals;
    }

    public int getTurnovers() {
        return turnovers;
    }

    public void setTurnovers(int turnovers) {
        this.turnovers = turnovers;
    }

    public int getBlocks() {
        return blocks;
    }

    public void setBlocks(int blocks) {
        this.blocks = blocks;
    }

    public int getFgm() {
        return fgm;
    }

    public void setFgm(int fgm) {
        this.fgm = fgm;
    }

    public int getFga() {
        return fga;
    }

    public void setFga(int fga) {
        this.fga = fga;
    }

    public int get3pm() {
        return _3pm;
    }

    public void set3pm(int _3pm) {
        this._3pm = _3pm;
    }

    public int get3pa() {
        return _3pa;
    }

    public void set3pa(int _3pa) {
        this._3pa = _3pa;
    }

    public int getFtm() {
        return ftm;
    }

    public void setFtm(int ftm) {
        this.ftm = ftm;
    }

    public int getFta() {
        return fta;
    }

    public void setFta(int fta) {
        this.fta = fta;
    }
   
}
