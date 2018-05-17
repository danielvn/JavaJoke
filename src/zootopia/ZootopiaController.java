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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ScrollPane;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

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
    Image imag = new Image("img/promociones.jpg");
    @FXML
    Image imag2 = new Image("img/background.jpg");
    @FXML
    AnchorPane anchorpane = new AnchorPane();
    @FXML
    ScrollPane scroll = new ScrollPane();
    @FXML
    ImageView carrito = new ImageView();
    @FXML
    Label carritoTotal = new Label();
    @FXML
    TextField buscarField = new TextField();

    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    ImageView tempImage;
    String currentType, id;
    int dragged = 0;
    int totalPedido = 0;
    
    HashMap<String,String[][]> inventario = new HashMap<String,String[][]>();
    
    
    String[][] enCarrito = new String[200][4];
    int numEnCarrito = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        numEnCarrito = 0;
        
        String[][] cajasDB = {
        {"1", "Pequeña", "5000", "cajas"},
        {"2", "Mediana", "10000", "cajas"},
        {"3", "Grande", "15000", "cajas"},
        {"4", "Especial", "20000", "cajas"}
        };
        inventario.put("cajas", cajasDB);

        
        String[][] accesoriosDB = {
        {"1", "Camisa Puppy", "10000", "accesorios"},
        {"2", "Smoking Puppy", "50000", "accesorios"},
        {"3", "Buso Doggo Adidas", "40000", "accesorios"},
        {"4", "Casa Portable", "75000", "accesorios"}
        };
        inventario.put("accesorios", accesoriosDB);

        String[][] alimentosDB = {
        {"1", "Pedigree", "10000", "alimentos"},
        {"2", "Zootopia Especial", "50000", "alimentos"},
        {"3", "Zootopia Puppy", "50000", "alimentos"},
        {"4", "Heroi", "8000", "alimentos"},
        {"5", "Generico", "5000", "alimentos"},
        {"6", "Beneful", "7500", "alimentos"}
        };
        inventario.put("alimentos", alimentosDB);
        
        String[][] camasDB = {
        {"1", "Classic Puppy", "50000", "camas"},
        {"2", "Acolchado", "25000", "camas"},
        {"3", "Madera", "50000", "camas"},
        {"4", "Elevado", "80000", "camas"},
        {"5", "Acolchado Puppy", "50000", "camas"},
        {"6", "Cuna Puppy", "75000", "camas"}
        };
        inventario.put("camas", camasDB);
        
        String[][] juguetesDB = {
        {"1", "Ratones Simples", "5000", "juguetes"},
        {"2", "Ratones Dirigibles", "20000", "juguetes"},
        {"3", "Huesos Funny", "5000", "juguetes"},
        {"4", "Plumas Chase", "8000", "juguetes"},
        {"5", "Laser Circular", "50000", "juguetes"}
        };
        inventario.put("juguetes", juguetesDB);
        
        String[][] paseadoresDB = {
        {"1", "Ruffwear", "20000", "paseadores"},
        {"2", "Generico Cuerda", "7000", "paseadores"},
        {"3", "Generico Enganche", "15000", "paseadores"},
        {"4", "Zootopia Extensible", "30000", "paseadores"}
        };
        inventario.put("paseadores", paseadoresDB);
        
        String[][] premiosDB = {
        {"1", "Carnaza", "10000", "premios"},
        {"2", "Twists", "10000", "premios"},
        {"3", "Barras de Alegria", "15000", "premios"},
        {"4", "Huesos High", "8000", "premios"},
        {"5", "Huesos Packet", "50000", "premios"},
        {"6", "Dentastix", "20000", "premios"}
        };
        inventario.put("premios", premiosDB);
    }
    

    @FXML
    private void handleBuscar(ActionEvent event) {
        String b = buscarField.getText();
        System.out.println(b);
        main_image.setVisible(false);
        flow.setVisible(true);
        scroll.setVisible(true);
        scroll.toFront();                
        
        flow.getChildren().clear();
        
        //String[][][] listaInventario = (String[][][])(.toArray());
        
        Iterator itr = inventario.values().iterator();
      
        while(itr.hasNext()) {
            String[][] element = (String[][])itr.next();
            //System.out.println(element[1][2]);
            for(int i=0; i < element.length; i++) {
                //System.out.println(b);
                if(element[i][1].toLowerCase().contains((String)b.toLowerCase())){
                    Label l = new Label(element[i][1]+" - $"+element[i][2]);
                    //System.out.println(str);
                    ImageView img = new ImageView(new Image(path((String)element[i][3],Integer.parseInt(element[i][0])-1)));
                    img.setId((String)element[i][3]+"-"+Integer.toString(Integer.parseInt(element[i][0])));
                    img.setFitWidth(150);
                    img.setFitHeight(150);
                    VBox vbox = new VBox(10, l, img);
                    vbox.setAlignment(Pos.CENTER);

                    vbox.setPrefWidth(255);
                    vbox.setPrefHeight(205);
                    flow.getChildren().add(vbox);
                    img.setOnMousePressed(itemOnMousePressedEventHandler);
                    img.setOnMouseDragged(circleOnMouseDraggedEventHandler);
                    img.setOnMouseReleased(circleOnMouseReleasedEventHandler);
                }
            }
        }      
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
    private void handleClickLabelInicio(MouseEvent event) {
        //Text object=(Text)event.getSource();
        flow.setVisible(false);
        scroll.setVisible(false);
        main_image.setImage(imag2);
        main_image.setVisible(true);
        main_image.toFront();
    }
    
    @FXML
    private void handleClickLabelInicio2(MouseEvent event) {
        //Text object=(Text)event.getSource();
        flow.setVisible(false);
        scroll.setVisible(false);
        main_image.setImage(imag);
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

            tempImage = new ImageView(obj.getImage());
            tempImage.setMouseTransparent(true);
            id = obj.getId();
            tempImage.setId(obj.getId());
            
            anchorpane.getChildren().add(tempImage);
            
            tempImage.setFitWidth(150);
            tempImage.setFitHeight(150);
            
            tempImage.setX(orgSceneX-t.getX());
            tempImage.setY(orgSceneY-t.getY());
            
            orgTranslateX = tempImage.getTranslateX();
            orgTranslateY = tempImage.getTranslateY();
        }
    };
     
    //@FXML
    //EventHandler<MouseEvent> carritoOnMouseReleasedEventHandler = 
    //    new EventHandler<MouseEvent>() {
 
    //    @Override
    @FXML
    private void carritoOnMouseClickedEventHandler(MouseEvent event) {
        //Label object=(Label)event.getSource();
        
        main_image.setVisible(false);
        flow.setVisible(true);
        scroll.setVisible(true);
        scroll.toFront();                
        
        flow.getChildren().clear();
        //int length = enCarrito.length;
        for(int i = 0; i < numEnCarrito; i++){
            Label l = new Label(enCarrito[i][1]+" - $"+enCarrito[i][2]);
            //System.out.println(str);
            ImageView img = new ImageView(new Image(path((String)enCarrito[i][3],Integer.parseInt(enCarrito[i][0])-1)));
            img.setId((String)enCarrito[i][3]+"-"+Integer.toString(Integer.parseInt(enCarrito[i][0])));
            img.setFitWidth(150);
            img.setFitHeight(150);
            VBox vbox = new VBox(10, l, img);
            vbox.setAlignment(Pos.CENTER);

            vbox.setPrefWidth(255);
            vbox.setPrefHeight(205);
            flow.getChildren().add(vbox);
            //img.setCursor(Cursor.HAND);
            //img.setOnMousePressed(itemOnMousePressedEventHandler);
            //img.setOnMouseDragged(circleOnMouseDraggedEventHandler);
            //img.setOnMouseReleased(circleOnMouseReleasedEventHandler);
        }
    }
    //};
    
    @FXML
    EventHandler<MouseEvent> circleOnMouseReleasedEventHandler = 
        new EventHandler<MouseEvent>() {
 
        @Override
        public void handle(MouseEvent t) {
            ImageView object=(ImageView)t.getSource();
        

            //System.out.println((String)object.idProperty().get());
            String[] data = ((String)object.idProperty().get()).split("-");
            
            anchorpane.getChildren().remove(tempImage);
            tempImage = null;
            
            double carritoX = carrito.getLayoutX();
            double carritoY = carrito.getLayoutY();
            double carritoWidth = carrito.getFitWidth();
            double carritoHeight = carrito.getFitHeight();
            double mouseX = t.getSceneX();
            double mouseY = t.getSceneY();
            
            boolean inX = (mouseX >= carritoX) && (mouseX <= (carritoX+carritoWidth));
            boolean inY = (mouseY >= carritoY) && (mouseY <= (carritoY+carritoHeight));
                        
            if(inX && inY){                
                String[][] section = inventario.get(data[0]);
                totalPedido += Integer.parseInt(section[Integer.parseInt(data[1])-1][2]);
                carritoTotal.setText("$"+totalPedido);
                System.out.println(section[Integer.parseInt(data[1])-1][2]);
                String[] temp = section[Integer.parseInt(data[1])-1];
                enCarrito[numEnCarrito] = temp;
                numEnCarrito += 1;
            }
        }
    };
        
        
    @FXML
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
            
        }
    };
    
    @FXML
    private void showClickMouse(MouseEvent event) {
        Label object=(Label)event.getSource();
        
        main_image.setVisible(false);
        flow.setVisible(true);
        scroll.setVisible(true);
        scroll.toFront();                
        
        currentType = object.idProperty().get();
        
        //System.out.println(currentType);

        String[][] section = inventario.get(currentType);
        int length = section.length;
        
        flow.getChildren().clear();
        for(int i = 0; i < length; i++){
            Label l = new Label(section[i][1]+" - $"+section[i][2]);
            //System.out.println(str);
            ImageView img = new ImageView(new Image(path((String)currentType,i)));
            img.setId(section[i][3]+"-"+Integer.toString(i+1));
            img.setFitWidth(150);
            img.setFitHeight(150);
            VBox vbox = new VBox(10, l, img);
            vbox.setAlignment(Pos.CENTER);

            vbox.setPrefWidth(255);
            vbox.setPrefHeight(205);
            flow.getChildren().add(vbox);
            //img.setCursor(Cursor.HAND);
            img.setOnMousePressed(itemOnMousePressedEventHandler);
            img.setOnMouseDragged(circleOnMouseDraggedEventHandler);
            img.setOnMouseReleased(circleOnMouseReleasedEventHandler);
        }
    }  
}