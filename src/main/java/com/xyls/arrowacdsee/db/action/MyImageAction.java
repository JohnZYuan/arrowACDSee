/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.db.action;

import com.xyls.arrowacdsee.db.dao.MyImageDao;
import com.xyls.arrowacdsee.db.model.MyImage;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 袁振
 */
public class MyImageAction {
    public List<MyImage> getAllImage () throws Exception{
        MyImageDao imagedao = new  MyImageDao() ;
        List<MyImage> li = imagedao.query();
        return li;
    }
    
    public List<MyImage> getGroupImage (Integer group_id) throws Exception{
        MyImageDao imagedao = new  MyImageDao() ;
        List<MyImage> li = imagedao.queryByGroup(group_id);
        return li;
    }
    
    public MyImage getSingeImage (Integer id ) throws SQLException{
        MyImageDao imagedao = new MyImageDao();
        MyImage image = imagedao.get(id);
        return image ;
    }
}
