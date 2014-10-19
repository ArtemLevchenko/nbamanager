package com.nbamanager.solution.client.beans;

import com.nbamanager.solution.dao.FactoryDB;
import com.nbamanager.solution.entity.Player;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Artem
 */
@ManagedBean(name = "gameBean")
@SessionScoped
public class GameBean implements Serializable {

    private String matchMessage;

    public String getMatchMessage() {
        return matchMessage;
    }

    public void setMatchMessage(String matchMessage) {
        this.matchMessage = matchMessage;
    }

    
    
    @PostConstruct
    public void test() {
        List<Player> players;
        try {
            players = FactoryDB.getInstance().getPlayerDAO().getAllData();
            for (Player pl : players) {
                System.out.println("!! " + pl.getFname() + " " + pl.getTeam().getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(GameBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
