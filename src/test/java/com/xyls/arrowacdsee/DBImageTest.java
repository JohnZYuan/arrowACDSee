/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee;

import com.xyls.arrowacdsee.db.dao.MyImageDao;
import com.xyls.arrowacdsee.db.model.MyImage;
import java.sql.SQLException;
import org.junit.Test;

/**
 *
 * @author 袁振
 */
public class DBImageTest {
        
//    @Test
//    public void insertTest () throws Exception{
//        MyImage testImage = new MyImage(3,"1.jpg");
//        MyImageDao testDao = new MyImageDao ();
//        testDao.addImage(testImage);
//    }
//    
//    @Test
//    public void queryTest () throws Exception{
//        MyImageDao testDao = new MyImageDao();
//        testDao.query();
//    }
    @Test
    public void getTest () throws SQLException {
        MyImageDao testDao = new MyImageDao();
        MyImage image = testDao.get(1);
        assert(image.getImage().equals("1.jpg"));
    }
    @Test
    public void queryByGroupTest () throws Exception{
        MyImageDao testDao = new MyImageDao();
        testDao.queryByGroup(3);
    }
//    @Test 
//    public void deleteTest () throws SQLException {
//        MyImageDao testDao = new MyImageDao ();
//        testDao.delGroup(1);
//    }
}
