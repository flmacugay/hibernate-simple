package com.mac.entity.onetomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BASKETBALL_TEAM")
public class BasketballTeam {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String state;

    @OneToMany(mappedBy = "team")
    private List<BPlayer> players;

    public BasketballTeam() {
    }

    public BasketballTeam(String name, String state) {
        this.name = name;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<BPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<BPlayer> players) {
        this.players = players;
    }

}
