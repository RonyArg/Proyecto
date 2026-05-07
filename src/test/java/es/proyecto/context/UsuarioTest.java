package es.proyecto.context;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    @Test
    void crearUsuarioConConstructor() {
        Usuario usuario = new Usuario("Juan", 30, 70, 170, "Masculino", "Activo", "Mantenimiento");
        assertEquals("Juan", usuario.getNombre());
        assertEquals(30, usuario.getEdad());
    }

    @Test
    void actualizarDatosUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Maria");
        usuario.setPeso(65);
        assertEquals("Maria", usuario.getNombre());
        assertEquals(65, usuario.getPeso());
    }

}