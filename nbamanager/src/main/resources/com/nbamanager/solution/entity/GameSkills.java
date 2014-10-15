package com.nbamanager.solution.entity;

/**
 *
 * @author Artem Levchenko
 */
public class GameSkills {
    private int id;
    // общий ранк
    private int totalrank;
    // из трехсекундной
    private int inscore;
    // cредн€€ дистанци€
    private int mediumshoot;
    // 3
    private int threeshoot;
    // штрафы
    private int freethrow;
    // данк
    private int dunk;
    //п а с
    private int pass;
    // контроль м€ча
    private int ballsecuirity;
    // блок
    private int block;
    // перехват
    private int steal;
    // атакующий подбор
    private int ofrebound;
    // защитный подбор
    private int defrebound;
    // стамина/восстановление
    private int stamina;
    // 1 на 1 защита
    private int defenseonball;

    public GameSkills() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalrank() {
        return totalrank;
    }

    public void setTotalrank(int totalrank) {
        this.totalrank = totalrank;
    }

    public int getInscore() {
        return inscore;
    }

    public void setInscore(int inscore) {
        this.inscore = inscore;
    }

    public int getMediumshoot() {
        return mediumshoot;
    }

    public void setMediumshoot(int mediumshoot) {
        this.mediumshoot = mediumshoot;
    }

    public int getThreeshoot() {
        return threeshoot;
    }

    public void setThreeshoot(int threeshoot) {
        this.threeshoot = threeshoot;
    }

    public int getFreethrow() {
        return freethrow;
    }

    public void setFreethrow(int freethrow) {
        this.freethrow = freethrow;
    }

    public int getDunk() {
        return dunk;
    }

    public void setDunk(int dunk) {
        this.dunk = dunk;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public int getBallsecuirity() {
        return ballsecuirity;
    }

    public void setBallsecuirity(int ballsecuirity) {
        this.ballsecuirity = ballsecuirity;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getSteal() {
        return steal;
    }

    public void setSteal(int steal) {
        this.steal = steal;
    }

    public int getOfrebound() {
        return ofrebound;
    }

    public void setOfrebound(int ofrebound) {
        this.ofrebound = ofrebound;
    }

    public int getDefrebound() {
        return defrebound;
    }

    public void setDefrebound(int defrebound) {
        this.defrebound = defrebound;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getDefenseonball() {
        return defenseonball;
    }

    public void setDefenseonball(int defenseonball) {
        this.defenseonball = defenseonball;
    }
    
    
}
