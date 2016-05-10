/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.db.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 袁振
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/arrowsee";
    private static final String USER="root";
    private static final String PASSWORD="Yz0902db";
    
    private static Connection conn =null;
    
    static {
        try {
            //1.加载驱动器
            Class.forName("com.mysql.jdbc.Driver");
            //2.获得数据库的连接
            conn = DriverManager.getConnection(URL, USER,PASSWORD);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Connection getConnection(){
        return conn;
    }
}
