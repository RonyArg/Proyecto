package es.proyecto.context;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InformacionTemporalTest {

    @BeforeEach
    void limpiarAntes() {
        // Limpiar el usuario antes de cada test
        InformacionTemporal.setUsuarioActual(null);
    }

    @Test
    void guardarYRecuperarUsuario() {
        Usuario usuario = new Usuario("Juan", 30, 70, 170, "Masculino", "Activo", "Mantenimiento");
        InformacionTemporal.setUsuarioActual(usuario);

        Usuario usuarioRecuperado = InformacionTemporal.getUsuarioActual();

        assertNotNull(usuarioRecuperado);
        assertEquals("Juan", usuarioRecuperado.getNombre());
        assertEquals(30, usuarioRecuperado.getEdad());
        assertEquals(70, usuarioRecuperado.getPeso());
    }

    @Test
    void actualizarUsuarioGuardado() {
        Usuario usuario1 = new Usuario("Juan", 30, 70, 170, "Masculino", "Activo", "Mantenimiento");
        InformacionTemporal.setUsuarioActual(usuario1);

        Usuario usuario2 = new Usuario("Maria", 25, 65, 160, "Femenino", "Sedentario", "Ganancia muscular");
        InformacionTemporal.setUsuarioActual(usuario2);

        Usuario usuarioRecuperado = InformacionTemporal.getUsuarioActual();

        assertEquals("Maria", usuarioRecuperado.getNombre());
        assertEquals(25, usuarioRecuperado.getEdad());
        assertEquals(65, usuarioRecuperado.getPeso());
    }

    @Test
    void limpiarUsuarioGuardado() {
        Usuario usuario = new Usuario("Juan", 30, 70, 170, "Masculino", "Activo", "Mantenimiento");
        InformacionTemporal.setUsuarioActual(usuario);

        assertNotNull(InformacionTemporal.getUsuarioActual());

        InformacionTemporal.setUsuarioActual(null);

        assertNull(InformacionTemporal.getUsuarioActual());
    }

    @Test
    void mismaInstanciaAlRecuperar() {
        Usuario usuario = new Usuario("Juan", 30, 70, 170, "Masculino", "Activo", "Mantenimiento");
        InformacionTemporal.setUsuarioActual(usuario);

        Usuario usuarioRecuperado = InformacionTemporal.getUsuarioActual();

        assertSame(usuario, usuarioRecuperado);
    }

    @Test
    void cambiosEnUsuarioSePersistenEnMemoria() {
        Usuario usuario = new Usuario("Juan", 30, 70, 170, "Masculino", "Activo", "Mantenimiento");
        InformacionTemporal.setUsuarioActual(usuario);

        Usuario usuarioRecuperado = InformacionTemporal.getUsuarioActual();
        usuarioRecuperado.setPeso(75);

        Usuario usuarioRecuperadoDenuevo = InformacionTemporal.getUsuarioActual();

        assertEquals(75, usuarioRecuperadoDenuevo.getPeso());
    }
}
