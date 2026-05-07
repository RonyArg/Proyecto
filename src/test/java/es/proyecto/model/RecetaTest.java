package es.proyecto.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecetaTest {

    @Test
    void crearReceta() {
        Receta receta = new Receta("Ensalada", 150, 20, 10, 5);
        assertEquals("Ensalada", receta.getNombre());
        assertEquals(150, receta.getCalorias());
    }

    @Test
    void actualizarMacrosReceta() {
        Receta receta = new Receta();
        receta.setProteinas(30);
        receta.setGrasas(10);
        assertEquals(30, receta.getProteinas());
    }

}