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
import com.jdbc.template.JdbcTemplate;
import com.jdbc.template.interf.SqlQuerier;
import com.jdbc.template.interf.SqlUpdater;
import com.jdbc.util.JdbcUtil;

public class TeamDaoTemplateImpl implements TeamDao {

    @Override
    public void addTeam(BasketballTeam basketballTeam) {
        JdbcTemplate<BasketballTeam> template = new JdbcTemplate<>();
        template.update(new SqlUpdater() {
            
            @Override
            public void execute(Connection conn) throws SQLException {
                PreparedStatement pstTeam = null;
                PreparedStatement pstPlayer = null;
                try {
                    // 确定添加的顺序为先添加球队记录再添加球员记录
                    if (basketballTeam != null) {
                        String sql = "insert into tbl_team values(sen_tbl_team_id.nextval, ?, ?)";
                        pstTeam = conn.prepareStatement(sql);
                        pstTeam.setString(1, basketballTeam.getName());
                        pstTeam.setString(2, basketballTeam.getCity());
                        pstTeam.executeUpdate();
                        List<Player> players = basketballTeam.getPlayers();
                        // 判断球队对象是否具有关联的球员成员
                        if (players != null && players.size() > 0) {
                            String subSql = "insert into tbl_player values(sen_tbl_palyer_id.nextval, "
                                    + "?, ?, ?, ?, sen_tbl_team_id.currval)";
                            pstPlayer = conn.prepareStatement(subSql);
                            for (Player player : players) {
                                pstPlayer.setString(1, player.getName());
                                pstPlayer.setDouble(2, player.getSalary());
                                // 完成java.util.Date -> java.sql.Date的转换
                                pstPlayer.setDate(3, new java.sql.Date(player.getJoinDate().getTime()));
                                // 完成枚举类到字符串的转换
                                pstPlayer.setString(4, player.getPosition().getcValue());
                                pstPlayer.executeUpdate();
                            }
                        }
                    }
                } finally {
                    try {
                        // 关闭球员对应的操作语句对象
                        if (pstPlayer != null) {
                            pstPlayer.close();
                        }
                        // 关闭球队对应的预编译语句对象
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
        JdbcTemplate<BasketballTeam> template = new JdbcTemplate<>();
        template.update(new SqlUpdater() {
            
            @Override
            public void execute(Connection conn) throws SQLException {
                PreparedStatement pstTeam = null;
                PreparedStatement pstPlayer = null;
                try {
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
                } finally {
                    try {
                        if (pstTeam != null) {
                            pstTeam.close();
                        }
                        if (pstPlayer != null) {
                            pstPlayer.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public List<BasketballTeam> findAllTeam() {
        JdbcTemplate<List<BasketballTeam>> template = new JdbcTemplate<>();
        return template.query(new SqlQuerier<List<BasketballTeam>>() {
            
            @Override
            public List<BasketballTeam> execute(Connection conn) throws SQLException {
                PreparedStatement pstTeam = null;
                PreparedStatement pstPlayer = null;
                ResultSet rsTeam = null;
                ResultSet rsPlayer = null;
                List<BasketballTeam> teams = null;
                try {
                    // 为了编码逻辑方便,先查询球队表进行封装,再查询球员表
                    String sql = "select * from tbl_team";
                    pstTeam = conn.prepareStatement(sql);
                    // 执行查询语句把结果放入到球队对应的结果集中
                    rsTeam = pstTeam.executeQuery();
                    teams = new ArrayList<BasketballTeam>();
                    while (rsTeam.next()) {
                        // 根据列号获取球队的id属性的值
                        Integer tId = rsTeam.getInt(1);
                        // 球队名称
                        String name = rsTeam.getString(2);
                        // 球队所属的城市
                        String city = rsTeam.getString(3);
                        //  创建一个球队的实例对象用于存放所查询出的值
                        BasketballTeam team = new BasketballTeam();
                        team.setId(tId);
                        team.setName(name);
                        team.setCity(city);
                        
                        // 可能关联球员的记录
                        String subSql = "select * from tbl_player where team_id = ?";
                        pstPlayer = conn.prepareStatement(subSql);
                        // 设置查询的球队的ID为之间查询出球队的id
                        pstPlayer.setInt(1, tId);
                        rsPlayer = pstPlayer.executeQuery();
                        // 用于存放接下来结果集处理封装的球员对象
                        List<Player> players = new ArrayList<>();
                        // 封装一个队员对象
                        while (rsPlayer.next()) {
                            Integer pId = rsPlayer.getInt(1);
                            String pName = rsPlayer.getString(2);
                            Double salary = rsPlayer.getDouble(3);
                            Date joinDate = rsPlayer.getDate(4);
                            // 完成字符串到对应枚举类的转换
                            Position position = translate(rsPlayer.getString(5));
                            // 完成了一个球员对象的封装
                            Player player = new Player();
                            player.setId(pId);
                            player.setName(pName);
                            player.setSalary(salary);
                            player.setJoinDate(joinDate);
                            player.setPosition(position);
                            // 把封装好的球员对象添加到球员列表中
                            players.add(player);
                        }
                        // 完成对一个球队对象的封装
                        team.setPlayers(players);
                        // 把完成的一个球队的对象添加到球队列表对象中
                        teams.add(team);
                    }
                } finally {
                    try {
                        JdbcUtil.close(rsPlayer, pstPlayer, null);
                        JdbcUtil.close(rsTeam, pstTeam, null);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                return teams;
            }
        });
    }
    
    // jdk1.7支持的switch结构写法
    private Position translate(String position) {
        switch (position) {
        case "组织后卫":
            return Position.PG;
        case "得分后卫":
            return Position.SG;
        case "小前锋":
            return Position.SF;
        case "大前锋":
            return Position.PF;
        default:
            return Position.C;
        }
    }

    @Override
    public List<BasketballTeam> findAllTeamByOneSql() {
        JdbcTemplate<List<BasketballTeam>> template = new JdbcTemplate<>();
        return template.query(new SqlQuerier<List<BasketballTeam>>() {
            
            @Override
            public List<BasketballTeam> execute(Connection conn) throws SQLException {
                PreparedStatement pst = null;
                ResultSet rs = null;
                List<BasketballTeam> teams = null;
                try {
                    String sql = "select * from tbl_team t left join tbl_player p on "
                            + "t.id = p.team_id";
                    pst = conn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    // 定义一个可以用作分组的容器
                    Map<Integer, BasketballTeam> map = new HashMap<>();
                    // 对查询到的包含了所有信息的结果集进行分组处理
                    while (rs.next()) {
                        BasketballTeam team = null;
                        // 获取到球队的ID
                        Integer tId = rs.getInt(1);
                        // 如果容易中已经找到了对应的球队对象, 直接取出
                        if (map.containsKey(tId)) {
                            team = map.get(tId);
                        } else {
                            team = new BasketballTeam();
                            List<Player> players = new ArrayList<>();
                            // 封装球队的基本信息
                            team.setId(tId);
                            team.setName(rs.getString(2));
                            team.setCity(rs.getString(3));
                            // 设置一个没有成员的球员列表对象至球队对象中
                            team.setPlayers(players);
                        }
                        // 为了防止空行值为null的情况适用getInt方法得到的值为0的情况
                        if (rs.getObject(4) != null) {
                            // 封装后面的球员信息至球员对象中
                            Player player = new Player();
                            player.setId(rs.getInt(4));
                            player.setName(rs.getString(5));
                            player.setSalary(rs.getDouble(6));
                            player.setJoinDate(rs.getDate(7));
                            player.setPosition(translate(rs.getString(8)));
                            // 把封装好的球员信息添加到对应的球队对象中的球员列表中
                            team.getPlayers().add(player);
                        }
                        // 把封装好的一个球队对象添加到map容器中建立tid和球队对象的对应关系
                        map.put(tId, team);
                    }
                    // 完成map中value的集合到对应的球队列表的转换
                    teams = new ArrayList<>(map.values());
                } finally {
                    try {
                        JdbcUtil.close(rs, pst, null);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                return teams;
            }
        });
    }

    @Override
    public void addTeams(List<BasketballTeam> basketballTeam) {
        // TODO Auto-generated method stub
        
    }

}
