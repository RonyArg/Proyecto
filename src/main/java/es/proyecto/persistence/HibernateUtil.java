package es.proyecto.persistence;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import es.proyecto.model.Receta;

// Clase que crea y gestiona la conexión con la base de datos mediante Hibernate.
// Usa el patrón Singleton para que solo exista una instancia de SessionFactory en toda la aplicación.
public class HibernateUtil {

    // Se crea una única vez al cargar la clase y se reutiliza durante toda la ejecución
    private static final SessionFactory sessionFactory = build();

    // Configura Hibernate leyendo hibernate.cfg.xml y registrando la clase Receta
    private static SessionFactory build() {
        try {
            // Crear la ruta de la base de datos en la carpeta del usuario
            String userHome = System.getProperty("user.home");
            String appDataDir = userHome + File.separator + ".proyecto";
            File dir = new File(appDataDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String dbPath = appDataDir + File.separator + "recetas.db";
            
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .setProperty("hibernate.connection.url", "jdbc:sqlite:" + dbPath)
                    .addAnnotatedClass(Receta.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Devuelve la instancia de SessionFactory para que RecetaDAO pueda abrir la sesión y acceder a la base de datos
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}