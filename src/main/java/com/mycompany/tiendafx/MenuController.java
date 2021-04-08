/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tiendafx;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

/**
 *
 * @author Nayra
 */
public class MenuController {
    
    // Reference to the main application.
    private App mainApp;
    
    @FXML
    private void loadFile() {
    	FileChooser dialogoFichero = new FileChooser();
        dialogoFichero.setTitle("Selecciona un fichero");
        File fAbrir = dialogoFichero.showOpenDialog(null);
        //labelFichero.setText(f.getAbsolutePath());
        //File fGuardar = dialogoFichero.showSaveDialog(null);

        if (fAbrir != null) {
            try {
                FileReader lector = new FileReader(fAbrir);
                BufferedReader buffer = new BufferedReader(lector);
                ObservableList<Articulo> cat = mainApp.getArticuloData();
                String linea = null;
                while((linea = buffer.readLine()) != null){
                    cat.add(new Articulo(linea.split(",")));
                }
                //TODO leerlo y cargar los articulos
                lector.close();
                mainApp.setArticuloData(cat);
            } catch (IOException ex) {
                System.out.println("Excepción capturada");
            }
        }
    }
    
     public void setMainApp(App mainApp) {
        this.mainApp = mainApp;
     }
    
}
