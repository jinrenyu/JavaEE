package com.jdbc.entity;

import java.util.List;

public class BasketballTeam {
    private Integer id;
    private String name;
    private String city;
    
    private List<Player> players;

    public BasketballTeam() {
        super();
    }

    public BasketballTeam(Integer id, String name, String city, List<Player> players) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.players = players;
    }

    public BasketballTeam(String name, String city, List<Player> players) {
        super();
        this.name = name;
        this.city = city;
        this.players = players;
    }

    public BasketballTeam(String name, String city) {
        super();
        this.name = name;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("BasketballTeam [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", city=");
        builder.append(city);
        builder.append("]");
        builder.append("\n");
        if (players != null && players.size() != 0) {
            for (Player player : players) {
                builder.append(player).append("\n");
            }
        } else {
            builder.append("该球队正在招募队员中......").append("\n");
        }
        return builder.toString();
    }
}
