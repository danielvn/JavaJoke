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

/**
 *
 * @author daniel
 */
public class ZootopiaController implements Initializable {
   
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
    
    @FXML
    private void handleLabelBarraMouseDentro(MouseEvent event) {
        System.out.println("Hola");
        ((Label)event.getSource()).setTextFill(Paint.valueOf("1711c2"));
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
