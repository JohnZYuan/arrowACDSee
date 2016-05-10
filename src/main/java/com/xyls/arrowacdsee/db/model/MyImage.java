/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.db.model;

/**
 *
 * @author 袁振
 */
public class MyImage {
    private int id ;
    private int group_id ;
    private String image;

    public MyImage() {
    }

    public MyImage(int group_id, String image) {
        this.group_id = group_id;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
}
