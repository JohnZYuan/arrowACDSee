/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.db.dao;

import com.xyls.arrowacdsee.db.db.DBUtil;
import com.xyls.arrowacdsee.db.model.MyImage;
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
public class MyImageDao {
    public void addImage(MyImage image) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql = "insert into my_image (image_group_id,image)"+"values(?,?)";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, image.getGroup_id());
        ptmt.setString(2, image.getImage());
        ptmt.execute();
    }
    
    public void updateGroup(MyImage image) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql = " update my_image set image_group_id=?,image=?"+" where id = ? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, image.getGroup_id());
        ptmt.setString(2, image.getImage());
        ptmt.setInt(4, image.getId());
        ptmt.execute();
    }
    
    public void delGroup(Integer id ) throws SQLException{
        Connection conn = DBUtil.getConnection();
        String sql = " delete from my_image "+"where id=?" ;
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ptmt.execute();
    }
    
    public List<MyImage> query() throws Exception{
        Connection conn = DBUtil.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs =stmt.executeQuery("select * from my_image");
        
        List<MyImage> imageList = new ArrayList<MyImage>() ;
        MyImage image = null;
        while (rs.next()){
            image= new MyImage( );
            image.setId(rs.getInt("id"));
            image.setGroup_id(rs.getInt("image_group_id"));
            image.setImage(rs.getString("image"));
            imageList.add(image);
        }
        
        return imageList;
    }
    
    public List<MyImage> queryByGroup(Integer group_id) throws Exception{
        Connection conn = DBUtil.getConnection();
        String sql = "select * from my_image where image_group_id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, group_id);
        ResultSet rs = ptmt.executeQuery();
        List<MyImage> imageList = new ArrayList<MyImage>() ;
        MyImage image = null;
        while (rs.next()){
            image= new MyImage( );
            image.setId(rs.getInt("id"));
            image.setGroup_id(rs.getInt("image_group_id"));
            image.setImage(rs.getString("image"));
            imageList.add(image);
        }
        
        return imageList;
    }
    
    public MyImage get(Integer id ) throws SQLException{
        Connection conn = DBUtil.getConnection();
        String sql = "select * from my_image where id=?" ;
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ptmt.setInt(1, id);
        ResultSet rs = ptmt.executeQuery();
        MyImage image= null;
        while (rs.next()){
            image= new MyImage();
            image.setId(rs.getInt("id"));
            image.setGroup_id(rs.getInt("image_group_id"));
            image.setImage(rs.getString("image"));
        }
        return image;
    }
}
