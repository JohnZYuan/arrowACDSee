/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xyls.arrowacdsee.controller;

import static com.xyls.arrowacdsee.controller.PerspectiveImage.HEIGHT;
import static com.xyls.arrowacdsee.controller.PerspectiveImage.WIDTH;
import com.xyls.arrowacdsee.db.action.GroupAction;
import com.xyls.arrowacdsee.db.action.MyImageAction;
import com.xyls.arrowacdsee.db.model.Group;
import com.xyls.arrowacdsee.db.model.MyImage;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author 袁振
 */
public class GroupController implements Initializable {

    /**
     * Initializes the controller class.
     */    
    @FXML
    private FlowPane flow_pane;
    
    @FXML
    private Label top_lab;
    
    @FXML
    private BorderPane border;
    
    Button singe_btn = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            loadGroup();
        } catch (Exception ex) {
            Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*各种图片加载方法*/
    
    public void  loadGroup () throws Exception{
        GroupAction gAction = new GroupAction();
        List <Group> gl= gAction.getAllGroup();
        Group g= new Group();
        MyAnimations animations = new MyAnimations();
        for ( int i = 0; i<gl.size();i++){
            g = gl.get(i);
            Image image = new Image (getClass().getResourceAsStream(g.getCover()));
            final Button btn = new Button (g.getName(),new ImageView (image));
            btn.setContentDisplay(ContentDisplay.TOP);
            btn.setMaxSize(280, 178);
            animations.btnMouseEE(btn);
            animations.btnAddReflection(btn);
            flow_pane.getChildren().add(btn);
            final int id = g.getId();
            final String name = g.getName();
            
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    flow_pane.getChildren().clear();
                    top_lab.setText(name);
                    try {
                        loadImageByGroup(id);
                    } catch (Exception ex) {
                        Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
    }
    
    public void loadImage () throws Exception {
        MyImageAction iAction = new MyImageAction();
        GroupAction gAction = new GroupAction();
        List <MyImage> il = iAction.getAllImage();
        MyAnimations animations = new MyAnimations();
        MyImage image = new MyImage();
        for ( int i = 0 ; i <il.size() ; i++){
            image = il.get(i);
            String path = gAction.getGroup(image.getGroup_id()).getPath()+"/"+image.getImage();
            Image showImage =new Image (getClass().getResourceAsStream(path));
            final Button btn = new Button ("",new ImageView (showImage));
            btn.setMaxSize(280, 178);
            animations.btnMouseEE(btn);
            animations.btnAddReflection(btn);
            flow_pane.getChildren().add(btn);
            
            final Integer id = image.getId();
            
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    top_lab.setText("浏览");
                    flow_pane.getChildren().clear();
                    try {
                        loadSingeImage(id);
                    } catch (Exception ex) {
                        Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    HBox bottom = new HBox ();
                    bottom.setAlignment(Pos.CENTER);
                    bottom.setSpacing(30.0);
                    bottom.setStyle("-fx-background-color: #000000;");
                    border.setBottom(bottom);
                    bottom.setPadding(new Insets(0, 0, 20, 80));
                }
            });
        }
    }
    
    public void loadSingeImage (Integer id ) throws Exception {
        MyImageAction iAction = new MyImageAction();
        GroupAction gAction = new GroupAction();
        MyImage image = iAction.getSingeImage(id);
        MyAnimations animations = new MyAnimations();
        List <MyImage> il = iAction.getGroupImage(image.getGroup_id());
        Image[] images = new Image[30];
        for (int i = 0;i<il.size();i++){
            String item = il.get(i).getImage();
            String path = gAction.getGroup(image.getGroup_id()).getPath()+"/"+item;
            images[i] =new Image (getClass().getResourceAsStream(path));
        }
        DisplayShelf displayShelf = new DisplayShelf(images);
        displayShelf.setPrefSize(1000, 600);
        flow_pane.getChildren().add(displayShelf);
        flow_pane.setAlignment(Pos.CENTER);
    }
    
    public void loadImageByGroup (Integer group_id) throws Exception {
        MyImageAction iAction = new MyImageAction();
        GroupAction gAction = new GroupAction();
        List <MyImage> il = iAction.getGroupImage(group_id);
        MyAnimations animations = new MyAnimations();
        MyImage image = new MyImage();
        for ( int i = 0 ; i <il.size() ; i++){
            image = il.get(i);
            String path = gAction.getGroup(image.getGroup_id()).getPath()+"/"+image.getImage();
            Image showImage =new Image (getClass().getResourceAsStream(path));
            final Button btn = new Button ("",new ImageView (showImage));
            btn.setMaxSize(280, 178);
            animations.btnMouseEE(btn);
            animations.btnAddReflection(btn);
            flow_pane.getChildren().add(btn);
            
            final Integer id = image.getId();
            
            btn.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {
                    top_lab.setText("浏览");
                    flow_pane.getChildren().clear();
                    try {
                        loadSingeImage(id);
                    } catch (Exception ex) {
                        Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    HBox bottom = new HBox ();
                    bottom.setAlignment(Pos.CENTER);
                    bottom.setSpacing(30.0);
                    bottom.setStyle("-fx-background-color: #000000;");
                    border.setBottom(bottom);
                    bottom.setPadding(new Insets(0, 0, 20, 80));
                }
            });
        }
    }
    
    /*静态页面按钮事件*/
    
    @FXML
    public void btn_imagesAction () throws Exception{
        top_lab.setText("图片");
        flow_pane.getChildren().clear();
        flow_pane.setAlignment(Pos.TOP_LEFT);
        border.setBottom(new HBox());
        loadImage();
    }
    
    @FXML
    public void btn_groupAction () throws Exception{
        top_lab.setText("相册");
        flow_pane.getChildren().clear();
        flow_pane.setAlignment(Pos.TOP_LEFT);
        border.setBottom(new HBox());
        loadGroup();
    }
    
    @FXML
    public void btn_manageAction () {
        top_lab.setText("管理");
        flow_pane.getChildren().clear();
        flow_pane.setAlignment(Pos.TOP_LEFT);
        border.setBottom(new HBox());
    }
    
    @FXML
    public void btn_aboutAction (){
        MyAnimations animations = new MyAnimations();
        top_lab.setText("关于我们");
        flow_pane.getChildren().clear();
        flow_pane.setAlignment(Pos.TOP_LEFT);
        border.setBottom(new HBox());
        
        VBox image_box = new VBox();
        Image image = new Image (getClass().getResourceAsStream("/images/yz.jpg"));
        Image image1 = new Image (getClass().getResourceAsStream("/images/lzy.jpg"));
        Image image2 = new Image (getClass().getResourceAsStream("/images/zx.jpg"));
        Button yz = new Button ("",new ImageView (image));
        Button lzy = new Button ("",new ImageView (image1));
        Button zx  = new Button ("",new ImageView (image2));
        animations.btnMouseEE(yz);
        animations.btnMouseEE(lzy);
        animations.btnMouseEE(zx);
                
        FlowPane txt_area = new FlowPane();
        txt_area.setAlignment(Pos.CENTER);
        final Label txt = new Label("");
        txt.setStyle("-fx-text-fill: #ffffff;-fx-text-alignment: center;-fx-font: 30 arial;");
        animations.btnAddReflection(txt);
        txt_area.setPadding(new Insets(50, 0, 0, 30));
        txt_area.getChildren().add(txt);
        
        yz.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                txt.setText("十万少女梦中的小袁老师\n在他心里他就是\n无所不能的");
            }
        });
        
        lzy.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                txt.setText("大胖二胖三胖\n耷拉胖\n红太阳永不落！");
            }
        });
        
        zx.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                txt.setText("他们揍我\n我走心！");
            }
        });
        
        image_box.getChildren().add(yz);
        image_box.getChildren().add(lzy);
        image_box.getChildren().add(zx);
        
        flow_pane.getChildren().add(image_box);
        flow_pane.getChildren().add(txt_area);
    }
    
    public double getSampleWidth() {
        return 800;//      495*2 
    }
 
    public double getSampleHeight() {
        return 500; //      300 
    }
}
