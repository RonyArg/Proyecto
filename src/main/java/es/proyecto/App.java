package es.proyecto;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 900, 700);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm()); // Agrega la hoja de estilos CSS
        
        stage.setScene(scene);
        stage.setTitle("Tu Calculadora Nutricional");
        stage.setResizable(false); // Evita que el usuario cambie el tamaño de la ventana
        stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("/apple.png"))); //Imagen de la app
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Abre una nueva ventana con la lista de recetas
    public static void mostrarListaRecetas() {
        try {
            Stage ventanaSecundaria = new Stage();
            Scene sceneSecundaria = new Scene(loadFXML("secondary"), 900, 700);
            sceneSecundaria.getStylesheets().add(App.class.getResource("/styles.css").toExternalForm());
            
            ventanaSecundaria.setScene(sceneSecundaria);
            ventanaSecundaria.setTitle("Tus Datos Nutricionales");
            ventanaSecundaria.setResizable(false);
            ventanaSecundaria.getIcons().add(new javafx.scene.image.Image(App.class.getResourceAsStream("/apple.png")));
            ventanaSecundaria.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // Vuelve a la pantalla de inicio
    public static void volverInicio() {
        try {
            setRoot("primary");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/es/proyecto/" + fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
