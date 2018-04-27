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
import javafx.scene.Parent;
import java.util.Vector;
import java.util.HashMap;
import java.util.Iterator;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;



/**
 *
 * @author daniel
 */


public class ZootopiaController implements Initializable {
    
    String path(String tipo, int i){
        String str = new String();
        str = "/img/";
        str += tipo;
        str += "/";
        str += Integer.toString(i+1);
        str += ".jpg";
        return str;
    }
    @FXML
    FlowPane flow = new FlowPane();
    @FXML
    ImageView main_image = new ImageView();
    @FXML
    AnchorPane anchorpane = new AnchorPane();
    @FXML
    ScrollPane scroll = new ScrollPane();
    
    
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    ImageView tempImage;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
    }
    
    @FXML
    private void handleLabelBarraMouseDentro(MouseEvent event) {
        Label object=(Label)event.getSource();
        object.setTextFill(Paint.valueOf("1711c1"));
        //main_image.setImage(null);
    }
    
    @FXML
    private void handleLabelBarraMouseFuera(MouseEvent event) {
        Label object=(Label)event.getSource();
        object.setTextFill(Paint.valueOf("000000"));
    }
    
    @FXML
    private void handleClickLabelInicio(MouseEvent event) {
        Text object=(Text)event.getSource();
        
        flow.setVisible(false);
        scroll.setVisible(false);
        main_image.setVisible(true);
        main_image.toFront();
    }
    
    EventHandler<MouseEvent> itemOnMousePressedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            
            ImageView obj = ((ImageView)t.getSource());
                     
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            //orgTranslateX = ((ImageView)(t.getSource())).getTranslateX();
            //orgTranslateY = ((ImageView)(t.getSource())).getTranslateY();
            
            //orgSceneX = obj.getLayoutX() + obj.getX();
            //System.out.println(orgSceneX);

            //orgSceneY = obj.getLayoutY() + obj.getY();
            //System.out.println(orgSceneY);

            tempImage = new ImageView(obj.getImage());
            
            anchorpane.getChildren().add(tempImage);
            
            tempImage.setFitWidth(150);
            tempImage.setFitHeight(150);
            
            tempImage.setX(orgSceneX-t.getX());
            System.out.println(orgSceneX);
            tempImage.setTranslateY(orgSceneY-t.getY());
            System.out.println(orgSceneY);
            
            orgTranslateX = tempImage.getTranslateX();
            orgTranslateY = tempImage.getTranslateY();

            //anchorpane.getChildren().add(img);

            //orgTranslateX = obj.getTranslateX();
            //System.out.println(orgTranslateX);
            //orgTranslateY = obj.getTranslateY();
            //System.out.println(orgTranslateY);
            //img.setOnMouseDragged(circleOnMouseDraggedEventHandler);
            //img.setOnMouseReleased(circleOnMouseReleasedEventHandler);
        }
    };
     
    EventHandler<MouseEvent> circleOnMouseReleasedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            //ImageView obj = ((ImageView)t.getSource());
            //ImageView img = ((ImageView)(t.getSource()));
            anchorpane.getChildren().remove(tempImage);
            tempImage = null;
            
            
            System.out.println("mouse released");
        }
    };
    
    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
             
            tempImage.setTranslateX(newTranslateX);
            tempImage.setTranslateY(newTranslateY);
            
            //double offsetX = ((ImageView)(t.getSource())).getLayoutX() - orgSceneX;
            //double offsetY = ((ImageView)(t.getSource())).getLayoutY() - orgSceneY;
            //double newTranslateX = orgTranslateX + offsetX;
            //double newTranslateY = orgTranslateY + offsetY;
             
            //((ImageView)(t.getSource())).setTranslateX(newTranslateX);
            //((ImageView)(t.getSource())).setTranslateY(newTranslateY);
        }
    };
    
    @FXML
    private void showClickMouse(MouseEvent event) {
        Label object=(Label)event.getSource();
        
        //main_image.setVisible(false);
        //scrollpane.setVisible(true);
        
        main_image.setVisible(false);
        flow.setVisible(true);
        scroll.setVisible(true);
        scroll.toFront();
        //System.out.println(object.idProperty().get());
        switch(object.idProperty().get()){
            case "caja":
                int cajas = 4;
                flow.getChildren().clear();
                for(int i = 0; i<cajas; i++){
                    Label l = new Label("Cajas Zootiopia");
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path("cajas",i)));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
        
                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                    //img.setCursor(Cursor.HAND);
                    img.setOnMousePressed(itemOnMousePressedEventHandler);
                    img.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                    img.setOnMouseReleased(circleOnMouseReleasedEventHandler);
                }
                break;
            case "paseador":
                int paseador = 4;
                flow.getChildren().clear();
                for(int i = 0; i<paseador; i++){
                    Label l = new Label("Paseadores");
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path("paseadores",i)));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
        
                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                }
                break;
            case "accesorios":
                int accesorios = 4;
                flow.getChildren().clear();
                for(int i = 0; i<accesorios; i++){
                    Label l = new Label("Accesorios");
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path("accesorios",i)));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
        
                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                }
                
                break;
            case "alimento":
                int alimento = 6;
                flow.getChildren().clear();
                for(int i = 0; i<alimento; i++){
                    Label l = new Label("Alimentos");
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path("alimento",i)));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
        
                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                }
                break;
            case "juguetes":
                int juguetes = 5;
                flow.getChildren().clear();
                for(int i = 0; i<juguetes; i++){
                    Label l = new Label("Juguetes");
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path("juguetes",i)));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
        
                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                }
                break;
            case "premios":
                int premios = 6;
                flow.getChildren().clear();
                for(int i = 0; i<premios; i++){
                    Label l = new Label("Premios");
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path("premios",i)));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
        
                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                }
                break;
            case "camas":
                int camas = 6;
                flow.getChildren().clear();
                for(int i = 0; i<camas; i++){
                    Label l = new Label("Camas");
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path("camas",i)));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
        
                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                }
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