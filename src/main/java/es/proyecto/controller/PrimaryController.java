package es.proyecto.controller;

import java.net.URL;
import java.util.ResourceBundle;
import es.proyecto.util.ComboBoxDatos;
import es.proyecto.App;
import es.proyecto.context.Usuario;
import es.proyecto.context.InformacionTemporal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

// Controlador de la pantalla principal donde el usuario introduce sus datos personales.
// Gestiona la validación de campos, la creación del objeto Usuario y la navegación a la segunda vista.
public class PrimaryController implements Initializable {

    public Label nombreTitulo;
    public Button btnIniciar;
    public Button btnSalir;
    public TextField txtNombre;
    public TextField txtEdad;
    public TextField txtPeso;
    public TextField txtAltura;
    public ComboBox<String> cmbGenero;
    public ComboBox<String> cmbEstilo;
    public ComboBox<String> cmbObjetivo;
    public Button btnLimpiar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbGenero.setItems(ComboBoxDatos.getGenero());
        cmbEstilo.setItems(ComboBoxDatos.getEstiloVida());
        cmbObjetivo.setItems(ComboBoxDatos.getObjetivo());
    }
    
    @FXML
    private void btnIniciarCalculadora(){
        String nombre;
        String genero;
        String estilo;
        String objetivo;
        int edad, altura;
        double peso;

        try {
            nombre = txtNombre.getText().trim();
            if (nombre.isEmpty()) throw new IllegalArgumentException("Nombre vacío");

            edad = Integer.parseInt(txtEdad.getText().trim());
            peso = Double.parseDouble(txtPeso.getText().trim().replace(",", "."));
            altura = Integer.parseInt(txtAltura.getText().trim());

            genero = cmbGenero.getValue();
            estilo = cmbEstilo.getValue();
            objetivo = cmbObjetivo.getValue();

            if (genero == null || estilo == null || objetivo == null) {
                throw new IllegalArgumentException("Rellena todos los campos");
            }

            Usuario usuario = new Usuario(nombre, edad, peso, altura, genero, estilo, objetivo);
            
            // Guardar el usuario en memoria para que secundary pueda acceder a él
            InformacionTemporal.setUsuarioActual(usuario);
            
            System.out.println("Usuario creado... Calculando recetas...");
            limpiarFormulario();
            App.mostrarListaRecetas();

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "Números inválidos");
        } catch (IllegalArgumentException e) {
            mostrarAlerta("Error", e.getMessage());
        }
    }
    
    @FXML
    private void btnLimpiarCalculadora() {

        limpiarFormulario();
    }

    // Muestra una ventana de alerta con un mensaje de error al usuario
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
    // Limpia todos los campos del formulario
    private void limpiarFormulario() {
        txtNombre.clear();
        txtEdad.clear();
        txtPeso.clear();
        txtAltura.clear();
        cmbGenero.getSelectionModel().clearSelection();
        cmbEstilo.getSelectionModel().clearSelection();
        cmbObjetivo.getSelectionModel().clearSelection();
    }
    
    @FXML
    private void btnSalir() {

        btnSalir.getScene().getWindow().hide();
    }
}

