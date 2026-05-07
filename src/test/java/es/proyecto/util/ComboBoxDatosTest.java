package es.proyecto.util;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComboBoxDatosTest {

    @Test
    void obtenerGenerosValidos() {
        ObservableList<String> generos = ComboBoxDatos.getGenero();
        assertEquals(2, generos.size());
        assertTrue(generos.contains("Masculino"));
        assertTrue(generos.contains("Femenino"));
    }

    @Test
    void obtenerEstilosVidaCompletos() {
        ObservableList<String> estilos = ComboBoxDatos.getEstiloVida();
        assertEquals(3, estilos.size());
        assertTrue(estilos.contains("Sedentario"));
        assertTrue(estilos.contains("Activo"));
        assertTrue(estilos.contains("Muy activo"));
    }

    @Test
    void obtenerObjetivosValidos() {
        ObservableList<String> objetivos = ComboBoxDatos.getObjetivo();
        assertEquals(3, objetivos.size());
        assertTrue(objetivos.contains("Perdida de grasa"));
        assertTrue(objetivos.contains("Mantenimiento"));
        assertTrue(objetivos.contains("Ganancia muscular"));
    }

}