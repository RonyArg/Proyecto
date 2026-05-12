package es.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 900, 700);
        stage.setScene(scene);
        stage.setTitle("Tu Calculadora Nutricional");
        stage.setResizable(false); // Evita que el usuario cambie el tamaño de la ventana
        stage.getIcons().add(new javafx.scene.image.Image(getClass().getResourceAsStream("/apple.png"))); //Imagen de la app
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Navega a la lista de recetas
    public static void mostrarListaRecetas() {
        try {
            setRoot("secondary");
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
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
    }
}
