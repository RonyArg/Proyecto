package es.proyecto.context;

public class Usuario {


    private String nombre;
    private int edad;
    private double peso;
    private double altura;
    private String genero;
    private String estilo;
    private String objetivo;

    public Usuario() { //Constructor sin parámetros
    }

    // Constructor con parámetros
    public Usuario(String nombre, int edad, double peso, double altura, String genero, String estilo, String objetivo) { //Constructor con parámetros
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.estilo = estilo;
        this.objetivo = objetivo;
    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    @Override
    public String toString() {
        return "Usuario: " + nombre + " , " + edad + " ," + peso + " ," + altura + " ," + genero + " ," + estilo + " ," + objetivo + ".";
    }
}

