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
public class Group {
    private int id ;
    private String cover;
    private String path ;
    private String name ;

    public Group(String cover, String path, String name) {
        this.cover = cover;
        this.path = path;
        this.name = name;
    }

    public Group() {

    }
   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
}
