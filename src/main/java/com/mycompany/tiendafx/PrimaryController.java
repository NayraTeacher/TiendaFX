package com.mycompany.tiendafx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PrimaryController {

//    @FXML
//    private void switchToSecondary() throws IOException {
//        App.setRoot("secondary");
//    }
    
    @FXML
    private TableView<Articulo> articuloTable;
    @FXML
    private TableColumn<Articulo, String> codigoColumn;
    @FXML
    private TableColumn<Articulo, String> nombreColumn;

    @FXML
    private Label codigoLabel;
    @FXML
    private Label nombreLabel;
    @FXML
    private Label precioLabel;
    // Reference to the main application.
    private App mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PrimaryController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	// Initialize the person table with the two columns.
        codigoColumn.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(App mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        articuloTable.setItems(mainApp.getArticuloData());
    }
}
