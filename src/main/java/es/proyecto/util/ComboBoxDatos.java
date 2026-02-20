package es.proyecto.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

// Esta clase es para establecer las opciones que deben tener los ComboBox en la interfaz gráfica que también servirá para la lógica de la calculadora de macros
public class ComboBoxDatos {
    
    public static ObservableList<String> getGenero() {
        return FXCollections.observableArrayList("Masculino", "Femenino");
    }
    
    public static ObservableList<String> getEstiloVida() {
        return FXCollections.observableArrayList("Sedentario", "Activo", "Muy activo");
    }
    
    public static ObservableList<String> getObjetivo() {
        return FXCollections.observableArrayList("Perdida de grasa", "Mantenimiento", "Ganancia muscular");
    }
}
