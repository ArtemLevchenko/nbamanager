package com.nbamanager.solution.entity;

import com.nbamanager.solution.enums.GamePosition;
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
 * @author Artem
 */
@Entity
@Table(name = "playerinfo")
public class PlayerInfo implements Serializable{
    @Column(name = "inGammePosition")
    private GamePosition inGammePosition;
    @OneToMany(mappedBy = "playerInfo")
    private List<Player> playerList;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    public PlayerInfo() {
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

    public GamePosition getInGammePosition() {
        return inGammePosition;
    }

    public void setInGammePosition(GamePosition inGammePosition) {
        this.inGammePosition = inGammePosition;
    }
    
    
}
