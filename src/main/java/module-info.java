module com.mycompany.tiendafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tiendafx to javafx.fxml;
    exports com.mycompany.tiendafx;
}
