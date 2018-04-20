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
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author daniel
 */
public class ZootopiaController implements Initializable {
    
    @FXML
    FlowPane flow = new FlowPane();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        Label l = new Label("hola");
        l.setTextAlignment(TextAlignment.CENTER);
        Label w = new Label("hola");
        ImageView i = new ImageView();
        VBox vbox = new VBox(10,l,w);
        
        vbox.setPrefWidth(265);// prefWidth
        vbox.setPrefHeight(215);// prefHeight
        
        flow.getChildren().add(vbox);
    }
    
    @FXML
    private void handleLabelBarraMouseDentro(MouseEvent event) {
        System.out.println("Hola");
        ((Label)event.getSource()).setTextFill(Paint.valueOf("1711c1"));
    }
    
    @FXML
    private void handleLabelBarraMouseFuera(MouseEvent event) {
        System.out.println("Hola");
        ((Label)event.getSource()).setTextFill(Paint.valueOf("000000"));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
