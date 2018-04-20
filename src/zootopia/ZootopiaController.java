/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zootopia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;


/**
 *
 * @author daniel
 */

class item {
    
    public String imgPath;
    public String name;
    public Float value;
    
    public item(String i, String n, Float v){
        imgPath = i;
        name = n;
        value = v;
    }
}

class inventario{
    private Vector<String> labelId = new Vector<String>(10);
    private Vector<Vector<item>> items = new Vector<Vector<item>>(6);
    public inventario(){
        labelId.add("caja");
        labelId.add("paseador");
        labelId.add("accesorios");
        labelId.add("alimento");
        labelId.add("juguetes");
        labelId.add("premios");
        labelId.add("camas");
        Iterator<String> itr = labelId.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}

public class ZootopiaController implements Initializable {
    inventario inv = new inventario();
    
    @FXML
    FlowPane flow = new FlowPane();
    ImageView main_image = new ImageView();
    //Image asd = new Image("../../img/7197XZH3FPL._SY355_.jpg");
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        //main_image.setImage(asd);
        System.out.println("You clicked me!");
        //main_image.toFront();
        main_image.setImage(null);
        
        Label l = new Label("hola");
        ImageView img = new ImageView(new Image("file:7197XZH3FPL._SY355_.jpg"));
        img.setFitWidth(200);
        img.setFitHeight(200);
        VBox vbox = new VBox(10, l, img);
        
        vbox.setPrefWidth(275);
        vbox.setPrefHeight(215);
        vbox.toFront();
        
        
        flow.getChildren().add(vbox);
    }
    
    @FXML
    private void handleLabelBarraMouseDentro(MouseEvent event) {
        Label object=(Label)event.getSource();
        object.setTextFill(Paint.valueOf("1711c1"));
    }
    
    @FXML
    private void handleLabelBarraMouseFuera(MouseEvent event) {
        Label object=(Label)event.getSource();
        object.setTextFill(Paint.valueOf("000000"));
    }
    
    @FXML
    private void setImageClickMouse(MouseEvent event) {
        Label object=(Label)event.getSource();
        //System.out.println(object.idProperty().get());
        switch(object.idProperty().get()){
            case "caja":
                
                break;
            case "paseador":
          
                break;
            case "accesorios":
                
                break;
            case "alimento":
                
                break;
            case "juguetes":
                
                break;
            case "premios":
                
                break;
            case "camas":
                
                break;
            default:
                
                break;
                
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
