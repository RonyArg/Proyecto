package es.proyecto.model;

import jakarta.persistence.*;


//Clase para crear objetos de recetas, mapeada mediante anotaciones Hibernate
@Entity
@Table(name = "recetas")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;
    @Column(name = "calorias_base")
    private double calorias;
    @Column(name = "proteinas_base")
    private double proteinas;
    @Column(name = "carbohidratos_base")
    private double carbohidratos;
    @Column(name = "grasas_base")
    private double grasas;

    // Constructor sin parámetros
    public Receta() {
    }

    // Constructor con parámetros
    public Receta(String nombre, double calorias, double proteinas, double carbohidratos, double grasas) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
    }


    //Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }
}

