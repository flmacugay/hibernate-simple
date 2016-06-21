package com.mac.entity.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BPlayer {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String position;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private BasketballTeam team;

    public BPlayer() {
    }

    public BPlayer(String name, String position) {
        this.name = name;
        this.position = position;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BasketballTeam getTeam() {
        return team;
    }

    public void setTeam(BasketballTeam team) {
        this.team = team;
    }

}
