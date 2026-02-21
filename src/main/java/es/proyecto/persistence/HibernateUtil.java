package es.proyecto.persistencie;

import es.proyecto.model.Receta;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// Clase que crea y gestiona la conexión con la base de datos mediante Hibernate.
// Usa el patrón Singleton para que solo exista una instancia de SessionFactory en toda la aplicación.
public class HibernateUtil {

    // Se crea una única vez al cargar la clase y se reutiliza durante toda la ejecución
    private static final SessionFactory sessionFactory = build();

    // Configura Hibernate leyendo hibernate.cfg.xml y registrando la clase Receta
    private static SessionFactory build() {
        try {
            return new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Receta.class)
                    .buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Devuelve la instancia de SessionFactory para que los DAOs puedan abrir sesiones
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
