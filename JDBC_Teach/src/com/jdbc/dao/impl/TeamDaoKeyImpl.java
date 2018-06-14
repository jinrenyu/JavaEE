package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.jdbc.dao.TeamDao;
import com.jdbc.entity.BasketballTeam;
import com.jdbc.entity.Player;
import com.jdbc.template.JdbcTemplate;
import com.jdbc.template.interf.SqlUpdater;

public class TeamDaoKeyImpl implements TeamDao {

    @Override
    public void addTeam(BasketballTeam basketballTeam) {
        JdbcTemplate<BasketballTeam> template = new JdbcTemplate<>();
        template.update(new SqlUpdater() {
            
            @Override
            public void execute(Connection conn) throws SQLException {
                PreparedStatement pstTeam = null;
                PreparedStatement pstPlayer = null;
                ResultSet rs = null;
                try {
                    // ȷ����ӵ�˳��Ϊ�������Ӽ�¼�������Ա��¼
                    if (basketballTeam != null) {
                        String sql = "insert into tbl_team values(sen_tbl_team_id.nextval, ?, ?)";
                        pstTeam = conn.prepareStatement(sql, new String[]{"id"});
                        pstTeam.setString(1, basketballTeam.getName());
                        pstTeam.setString(2, basketballTeam.getCity());
                        pstTeam.executeUpdate();
                        List<Player> players = basketballTeam.getPlayers();
                        // �ж���Ӷ����Ƿ���й�������Ա��Ա
                        if (players != null && players.size() > 0) {
                            String subSql = "insert into tbl_player values(sen_tbl_palyer_id.nextval, "
                                    + "?, ?, ?, ?, ?)";
                            pstPlayer = conn.prepareStatement(subSql);
                            rs = pstTeam.getGeneratedKeys();
                            if (rs.next()) {
                                Integer tid = rs.getInt(1);
                                for (Player player : players) {
                                    pstPlayer.setString(1, player.getName());
                                    pstPlayer.setDouble(2, player.getSalary());
                                    // ���java.util.Date -> java.sql.Date��ת��
                                    pstPlayer.setDate(3, new java.sql.Date(player.getJoinDate().getTime()));
                                    // ���ö���ൽ�ַ�����ת��
                                    pstPlayer.setString(4, player.getPosition().getcValue());
                                    if (tid != null) {
                                        pstPlayer.setInt(5, tid);
                                    } else {
                                        pstPlayer.setNull(5, java.sql.Types.INTEGER);
                                    }
                                    pstPlayer.executeUpdate();
                                }
                            }
                        }
                    }
                } finally {
                    try {
                        // �ر���Ա��Ӧ�Ĳ���������
                        if (pstPlayer != null) {
                            pstPlayer.close();
                        }
                        // �ر���Ӷ�Ӧ��Ԥ����������
                        if (pstTeam != null) {
                            pstTeam.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }

    @Override
    public void deleteTeam(BasketballTeam basketballTeam) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<BasketballTeam> findAllTeam() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<BasketballTeam> findAllTeamByOneSql() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void addTeams(List<BasketballTeam> basketballTeam) {
        // TODO Auto-generated method stub

    }

}
