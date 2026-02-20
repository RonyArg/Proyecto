
package es.proyecto.context;


// Guarda el usuario actual en memoria mientras la app está en uso (solo un usuario a la vez).
public class InformacionTemporal {
    private static Usuario usuarioActual;


    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario usuario) {
        usuarioActual = usuario;
    }
}
