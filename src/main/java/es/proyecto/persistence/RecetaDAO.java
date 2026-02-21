package es.proyecto.persistencie;

import es.proyecto.model.Receta;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import java.util.List;

/**
 * Data Access Object (DAO) para operaciones con Receta
 */
public class RecetaDAO {

    private SessionFactory sessionFactory;

    public RecetaDAO() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }


    // Carga las recetas de la base de datos
    public List<Receta> obtenerRecetas() {
        Session session = sessionFactory.openSession();
        try {
            return session.createQuery("FROM Receta", Receta.class).list();
        } catch (Exception e) {
            System.err.println("✗ Error al obtener recetas: " + e.getMessage());
            return new java.util.ArrayList<>();
        } finally {
            session.close();
        }
    }
}