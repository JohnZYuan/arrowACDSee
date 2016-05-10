/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.db.action;

import com.xyls.arrowacdsee.db.dao.GroupDao;
import com.xyls.arrowacdsee.db.model.Group;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author 袁振
 */
public class GroupAction {
    
    /*控制层，向视图层提供业务接口*/
    public List<Group> getAllGroup () throws Exception {
        GroupDao dao = new GroupDao();
        List<Group> gl = dao.query();
        return gl ;
    }
    
    public Group getGroup (Integer id) throws SQLException{
        GroupDao dao = new GroupDao();
        Group g = dao.get(id);
        return g;
    }
    
    
}
