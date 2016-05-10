/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.db.dao;

import com.xyls.arrowacdsee.db.db.DBUtil;
import com.xyls.arrowacdsee.db.model.Group;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 袁振
 */
public class GroupDao {
    
    public void addGroup(Group group) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql = "insert into image_group (cover,path,name)"+"values(?,?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, group.getCover());
        ptmt.setString(2, group.getPath());
        ptmt.setString(3, group.getName());
        ptmt.execute();
    }
    
    public void updateGroup(Group group) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql = " update image_group set cover=?,path=?,name=? "+" where id = ? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setString(1, group.getCover());
        ptmt.setString(2, group.getPath());
        ptmt.setString(3, group.getName());
        ptmt.setInt(4, group.getId());
        ptmt.execute();
    }
    
    public void delGroup(Integer id ) throws SQLException{
        Connection conn = DBUtil.getConnection();
        String sql = " delete from image_group "+"where id=?" ;
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }
    
    public List<Group> query() throws Exception{
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs =stmt.executeQuery("select * from image_group");
        
        List<Group> groupList = new ArrayList<Group>() ;
        Group g = null;
        while (rs.next()){
            g= new Group( );
            g.setId(rs.getInt("id"));
            g.setCover(rs.getString("cover"));
            g.setName(rs.getString("name"));
            g.setPath(rs.getString("path"));
            groupList.add(g);
        }
        
        return groupList;
    }
    
    public Group get(Integer id ) throws SQLException{
        Connection conn = DBUtil.getConnection();
        String sql = "select * from image_group where id=?" ;
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ResultSet rs = ptmt.executeQuery();
        Group g= null;
        while (rs.next()){
            g= new Group();
            g.setId(rs.getInt("id"));
            g.setCover(rs.getString("cover"));
            g.setName(rs.getString("name"));
            g.setPath(rs.getString("path"));
        }
        return g;
    }
}
