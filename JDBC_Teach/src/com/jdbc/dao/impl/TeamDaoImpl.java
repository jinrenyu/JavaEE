package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jdbc.dao.TeamDao;
import com.jdbc.entity.BasketballTeam;
import com.jdbc.entity.Player;
import com.jdbc.enumeration.Position;
import com.jdbc.util.JdbcUtil;

public class TeamDaoImpl implements TeamDao {

    @Override
    public void addTeam(BasketballTeam basketballTeam) {
        Connection conn = null;
        PreparedStatement pstTeam = null;
        PreparedStatement pstPlayer = null;
        try {
            conn = JdbcUtil.getConnection();
            // ��Ϊ�漰������ɾ��,����SQL���֮����ڹ�����ϵ,ʹ���������
            conn.setAutoCommit(false);
            // ȷ����ӵ�˳��Ϊ�������Ӽ�¼�������Ա��¼
            if (basketballTeam != null) {
                String sql = "insert into tbl_team values(sen_tbl_team_id.nextval, ?, ?)";
                pstTeam = conn.prepareStatement(sql);
                pstTeam.setString(1, basketballTeam.getName());
                pstTeam.setString(2, basketballTeam.getCity());
                pstTeam.executeUpdate();
                List<Player> players = basketballTeam.getPlayers();
                // �ж���Ӷ����Ƿ���й�������Ա��Ա
                if (players != null && players.size() > 0) {
                    String subSql = "insert into tbl_player values(sen_tbl_palyer_id.nextval, "
                            + "?, ?, ?, ?, sen_tbl_team_id.currval)";
                    pstPlayer = conn.prepareStatement(subSql);
                    for (Player player : players) {
                        pstPlayer.setString(1, player.getName());
                        pstPlayer.setDouble(2, player.getSalary());
                        // ���java.util.Date -> java.sql.Date��ת��
                        pstPlayer.setDate(3, new java.sql.Date(player.getJoinDate().getTime()));
                        // ���ö���ൽ�ַ�����ת��
                        pstPlayer.setString(4, player.getPosition().getcValue());
                        pstPlayer.executeUpdate();
                    }
                }
            }
            // �ֶ��ύ����
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    // �����쳣�ع�����
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                // �ر���Ա��Ӧ�Ĳ���������
                if (pstPlayer != null) {
                    pstPlayer.close();
                }
                // �ر���Ӷ�Ӧ�Ĳ��������������
                JdbcUtil.close(pstTeam, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteTeam(BasketballTeam basketballTeam) {
        Connection conn = null;
        PreparedStatement pstTeam = null;
        PreparedStatement pstPlayer = null;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            if (basketballTeam != null) {
                List<Player> players = basketballTeam.getPlayers();
                if (players != null && players.size() > 0) {
                    String sql = "delete tbl_player where team_id = ?";
                    pstPlayer = conn.prepareStatement(sql);
                    pstPlayer.setInt(1, basketballTeam.getId());
                    pstPlayer.executeUpdate();
                }
                String subSql = "delete tbl_team where id = ?";
                pstTeam = conn.prepareStatement(subSql);
                pstTeam.setInt(1, basketballTeam.getId());
                pstTeam.executeUpdate();
            }
            conn.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (pstTeam != null) {
                    pstTeam.close();
                }
                JdbcUtil.close(pstPlayer, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }

    @Override
    public List<BasketballTeam> findAllTeam() {
        Connection conn = null;
        PreparedStatement pstTeam = null;
        PreparedStatement pstPlayer = null;
        ResultSet rsTeam = null;
        ResultSet rsPlayer = null;
        List<BasketballTeam> teams = null;
        try {
            // ��Ȼ�Ƕ������Ĳ�ѯ,�˴�Ϊ�˱�֤���ܲ�����������
            conn = JdbcUtil.getConnection();
            // Ϊ�˱����߼�����,�Ȳ�ѯ��ӱ���з�װ,�ٲ�ѯ��Ա��
            String sql = "select * from tbl_team";
            pstTeam = conn.prepareStatement(sql);
            // ִ�в�ѯ���ѽ�����뵽��Ӷ�Ӧ�Ľ������
            rsTeam = pstTeam.executeQuery();
            teams = new ArrayList<BasketballTeam>();
            while (rsTeam.next()) {
                // �����кŻ�ȡ��ӵ�id���Ե�ֵ
                Integer tId = rsTeam.getInt(1);
                // �������
                String name = rsTeam.getString(2);
                // ��������ĳ���
                String city = rsTeam.getString(3);
                //  ����һ����ӵ�ʵ���������ڴ������ѯ����ֵ
                BasketballTeam team = new BasketballTeam();
                team.setId(tId);
                team.setName(name);
                team.setCity(city);
                
                // ���ܹ�����Ա�ļ�¼
                String subSql = "select * from tbl_player where team_id = ?";
                pstPlayer = conn.prepareStatement(subSql);
                // ���ò�ѯ����ӵ�IDΪ֮���ѯ����ӵ�id
                pstPlayer.setInt(1, tId);
                rsPlayer = pstPlayer.executeQuery();
                // ���ڴ�Ž���������������װ����Ա����
                List<Player> players = new ArrayList<>();
                // ��װһ����Ա����
                while (rsPlayer.next()) {
                    Integer pId = rsPlayer.getInt(1);
                    String pName = rsPlayer.getString(2);
                    Double salary = rsPlayer.getDouble(3);
                    Date joinDate = rsPlayer.getDate(4);
                    // ����ַ�������Ӧö�����ת��
                    Position position = translatePosition(rsPlayer.getString(5));
                    // �����һ����Ա����ķ�װ
                    Player player = new Player();
                    player.setId(pId);
                    player.setName(pName);
                    player.setSalary(salary);
                    player.setJoinDate(joinDate);
                    player.setPosition(position);
                    // �ѷ�װ�õ���Ա������ӵ���Ա�б���
                    players.add(player);
                }
                // ��ɶ�һ����Ӷ���ķ�װ
                team.setPlayers(players);
                // ����ɵ�һ����ӵĶ�����ӵ�����б������
                teams.add(team);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(rsPlayer, pstPlayer, null);
                JdbcUtil.close(rsTeam, pstTeam, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teams;
    }

    private Position translatePosition(String position) {
        if (position.equals("��֯����")) {
            return Position.PG;
        } else if (position.equals("�÷ֺ���")) {
            return Position.SG;
        } else if (position.equals("Сǰ��")) {
            return Position.SF;
        } else if (position.equals("��ǰ��")) {
            return Position.PF;
        } else {
            return Position.C;
        }
    }
    
    @Override
    public List<BasketballTeam> findAllTeamByOneSql() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<BasketballTeam> teams = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from tbl_team t left join tbl_player p on "
                    + "t.id = p.team_id";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            // ����һ�������������������
            Map<Integer, BasketballTeam> map = new HashMap<>();
            // �Բ�ѯ���İ�����������Ϣ�Ľ�������з��鴦��
            while (rs.next()) {
                BasketballTeam team = null;
                // ��ȡ����ӵ�ID
                Integer tId = rs.getInt(1);
                // ����������Ѿ��ҵ��˶�Ӧ����Ӷ���, ֱ��ȡ��
                if (map.containsKey(tId)) {
                    team = map.get(tId);
                } else {
                    team = new BasketballTeam();
                    List<Player> players = new ArrayList<>();
                    // ��װ��ӵĻ�����Ϣ
                    team.setId(tId);
                    team.setName(rs.getString(2));
                    team.setCity(rs.getString(3));
                    // ����һ��û�г�Ա����Ա�б��������Ӷ�����
                    team.setPlayers(players);
                }
                // Ϊ�˷�ֹ����ֵΪnull���������getInt�����õ���ֵΪ0�����
                if (rs.getObject(4) != null) {
                    // ��װ�������Ա��Ϣ����Ա������
                    Player player = new Player();
                    player.setId(rs.getInt(4));
                    player.setName(rs.getString(5));
                    player.setSalary(rs.getDouble(6));
                    player.setJoinDate(rs.getDate(7));
                    player.setPosition(translatePosition(rs.getString(8)));
                    // �ѷ�װ�õ���Ա��Ϣ��ӵ���Ӧ����Ӷ����е���Ա�б���
                    team.getPlayers().add(player);
                }
                // �ѷ�װ�õ�һ����Ӷ�����ӵ�map�����н���tid����Ӷ���Ķ�Ӧ��ϵ
                map.put(tId, team);
            }
            // ���map��value�ļ��ϵ���Ӧ������б��ת��
            teams = new ArrayList<>(map.values());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(rs, pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return teams;
    }

    @Override
    public void addTeams(List<BasketballTeam> basketballTeam) {
        // TODO Auto-generated method stub
        
    }

}
