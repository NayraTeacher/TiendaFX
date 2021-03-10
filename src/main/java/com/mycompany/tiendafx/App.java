package com.mycompany.tiendafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private BorderPane rootLayout;

    private ObservableList<Articulo> catalogo = FXCollections.observableArrayList();
    
    @Override
    public void start(Stage stage) throws IOException {
        rootLayout = (BorderPane) loadFXML("root").load();
        scene = new Scene(rootLayout, 640, 480);
        stage.setScene(scene);
        stage.setTitle("Tienda");
        stage.show();
        
        inicializaCatalogo(catalogo);
        
        showArticuloInfo();
        
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml).load());
    }

    private static FXMLLoader loadFXML(String fxml) throws IOException {
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    }

    public static void main(String[] args) {
        launch();
    }
    
    private static void inicializaCatalogo(ObservableList<Articulo> c) {
        c.add(new Articulo("0001", "Monitor", 200.00F, 10));
        c.add(new Articulo("0002", "Teclado", 10.00F, 100));
        c.add(new Articulo("0003", "RJ45 2M", 4.50F, 50));
        c.add(new Articulo("0004", "Raton", 20.00F, 15));
//        c.add(new Ropa("rojo", TallaSML.L, "0005", "jersey", 
//                25.50F, 100));
//        c.add(new Electrodomestico("Hogar", ClaseE.A, "0006", 
//                "Lavadora", 526.89F, 10));
    }
    
    public ObservableList<Articulo> getArticuloData() {
		return catalogo;
	}
    
    public void showArticuloInfo() {
    try {
        // Load person overview.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource("primary.fxml"));
        VBox articuloInfo = (VBox) loader.load();

        // Set person overview into the center of root layout.
        rootLayout.setCenter(articuloInfo);

        // Give the controller access to the main app.
        PrimaryController controller = loader.getController();
        controller.setMainApp(this);

    } catch (IOException e) {
        e.printStackTrace();
    }
}

}