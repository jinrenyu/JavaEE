package com.jdbc.dao.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jdbc.dao.TeamDao;
import com.jdbc.entity.BasketballTeam;
import com.jdbc.entity.Player;
import com.jdbc.enumeration.Position;

public class TeamDaoTemplateImplTest {

    private TeamDao teamDao;
    
    @Before
    public void setUp() throws Exception {
        teamDao = new TeamDaoTemplateImpl();
    }

    @After
    public void tearDown() throws Exception {
        teamDao = null;
    }

    @Test
    public void testAddTeam() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Player player = new Player("play" + i, 100.00, new Date(), Position.PF);
            players.add(player);
        }
        BasketballTeam team = new BasketballTeam("test01", "city01", players);
        teamDao.addTeam(team);
    }

    @Test
    public void testDeleteTeam() {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Player player = new Player("play" + i, 100.00, new Date(), Position.PF);
            players.add(player);
        }
        BasketballTeam team = new BasketballTeam();
        team.setId(28);
        team.setPlayers(players);
        teamDao.deleteTeam(team);
    }

    @Test
    public void testFindAllTeam() {
        List<BasketballTeam> teams = teamDao.findAllTeam();
        for (BasketballTeam basketballTeam : teams) {
            System.out.println(basketballTeam);
        }
    }

    @Test
    public void testFindAllTeamByOneSql() {
        List<BasketballTeam> teams = teamDao.findAllTeamByOneSql();
        for (BasketballTeam basketballTeam : teams) {
            System.out.println(basketballTeam);
        }
    }

    @Test
    public void testAddTeams() {
        fail("Not yet implemented");
    }

}
