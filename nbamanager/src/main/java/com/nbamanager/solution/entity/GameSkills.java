package com.nbamanager.solution.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "gameskills")
public class GameSkills implements Serializable {
    @OneToMany(mappedBy = "gameSkills")
    private List<Player> playerList;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    // общий ранк
    @Column(name = "totalrank")
    private int totalrank;
    // из трехсекундной
    @Column(name = "inscore")
    private int inscore;
    // cредн€€ дистанци€
    @Column(name = "mediumshoot")
    private int mediumshoot;
    // 3
    @Column(name = "threeshoot")
    private int threeshoot;
    // штрафы
    @Column(name = "freethrow")
    private int freethrow;
    // данк
    @Column(name = "dunk")
    private int dunk;
    //п а с
    @Column(name = "pass")
    private int pass;
    // контроль м€ча
    @Column(name = "ballsecuirity")
    private int ballsecuirity;
    // блок
    @Column(name = "block")
    private int block;
    // перехват
    @Column(name = "steal")
    private int steal;
    // атакующий подбор
    @Column(name = "ofrebound")
    private int ofrebound;
    // защитный подбор
    @Column(name = "defrebound")
    private int defrebound;
    // стамина/восстановление
    @Column(name = "stamina")
    private int stamina;
    // 1 на 1 защита
    @Column(name = "defenseonball")
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

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

}
