/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
//import org.openstreetmap.gui.jmapviewer.*;

public class MapApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear un mapa
        //JMapViewer map = new JMapViewer();
        //map.setDisplayPositionByLatLon(27.5162, -109.9558, 13); // Ciudad Obregón

        // Agregar el mapa a una escena
        BorderPane root = new BorderPane();
        //root.setCenter(map);
        Scene scene = new Scene(root, 800, 600);

        // Mostrar la ventana
        primaryStage.setTitle("Mapa de Baches Ciudad Obregón");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
