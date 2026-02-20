module es.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;
    requires java.sql;
    requires java.base;

    opens es.proyecto to javafx.fxml;
    opens es.proyecto.model to javafx.fxml, org.hibernate.orm.core;
    opens es.proyecto.controller to javafx.fxml;
    opens es.proyecto.persistencie to org.hibernate.orm.core;
    
    exports es.proyecto;
    exports es.proyecto.controller;
    exports es.proyecto.model;
    exports es.proyecto.context;
    opens es.proyecto.context to javafx.fxml, org.hibernate.orm.core;
}
