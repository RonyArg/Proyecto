package es.proyecto.controller;

import es.proyecto.App;
import es.proyecto.context.Usuario;
import es.proyecto.model.Receta;
import es.proyecto.service.CalculadoraNutricional;
import es.proyecto.persistencie.RecetaDAO;
import es.proyecto.context.InformacionTemporal;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SecondaryController implements Initializable {

    public Button btnSalir;
    @FXML private ListView<String> listaRecetas;
    @FXML private Label lblMacrosTotales;
    @FXML private Button btnVolver;

    private Usuario usuarioActual;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaRecetas.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        
        // Recuperar el usuario de la memoria
        Usuario usuario = InformacionTemporal.getUsuarioActual();
        if (usuario != null) {
            inicializarConUsuario(usuario);
        } else {
            System.err.println("Error no se encuentra el usuario.");
        }
    }

    public void inicializarConUsuario(Usuario usuario) {
        this.usuarioActual = usuario;
        actualizarVista();
    }

    // Calcula calorías y macros según los datos del usuario actual
    private void actualizarVista() {
        double calorias = CalculadoraNutricional.calcularCalorias(
                usuarioActual.getPeso(), usuarioActual.getAltura(),
                usuarioActual.getEdad(), usuarioActual.getGenero(),
                usuarioActual.getEstilo(), usuarioActual.getObjetivo()
        );

        lblMacrosTotales.setText("Macros diarios: " +
                CalculadoraNutricional.obtenerMacros(calorias, usuarioActual.getPeso()));

        //  Carga las recetas desde Base de Datos creando un objeto recetaDAO y usa el método obtenerRecetas()
        RecetaDAO recetaDAO = new RecetaDAO();
        List<Receta> recetas = recetaDAO.obtenerRecetas();
        System.out.println("Recetas encontradas en la base de datos: " + recetas.size());


        //Convierte las recetas en una lista de cadenas para mostrarlas en la interfáz gráfica
        ObservableList<String> items = FXCollections.observableArrayList();

        // Regla de 3 para adaptar las recetas al usuario basándose en que cada receta es una persona, plato estandar, de 2400 calorias
        for (Receta r : recetas) {
            double calAjustada = r.getCalorias() * (calorias / 2400);
            String itemText = r.getNombre() + " (" + (int)calAjustada + " cal)";
            items.add(itemText);
            System.out.println("   - " + itemText);
        }

        System.out.println("Conectando " + items.size() + " recetas con ListView");
        listaRecetas.setItems(items);
        System.out.println("ListView cargado correctamente");
    }

    // Regresa a la primera vista
    @FXML
    private void btnVolverCalculadora() {

        App.volverInicio();
    };

    // Cierra la ventana
    @FXML
    private void btnSalir() {
        btnSalir.getScene().getWindow().hide();
    };

}
