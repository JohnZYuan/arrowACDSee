/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Reflection;

/**
 *
 * @author 袁振
 */
public class MyAnimations {
    public void btnMouseEE (final Button btn ) {
        btn.setOnMouseEntered(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                btn.setScaleX(1.1);
                btn.setScaleY(1.1);
            }        
        });
        
        btn.setOnMouseExited(new EventHandler<javafx.scene.input.MouseEvent>(){
            @Override
            public void handle(javafx.scene.input.MouseEvent t) {
                btn.setScaleX(1.0);
                btn.setScaleY(1.0);
            }
        });
    }
    
    public void btnAddReflection (Button btn){
        Reflection r = new Reflection();
        r.setFraction(0.3f);
        btn.setEffect(r);
}

    void btnAddReflection(Label txt) {
        Reflection r = new Reflection();
        r.setFraction(0.8f);
        txt.setEffect(r);
    }
}
