package es.proyecto.model;


// Esta clase representa los macronutrientes calculados para un usuario, incluyendo calorías, proteínas, carbohidratos y grasas.

public class Macros {
    private double calorias;
    private double proteinasGramos;
    private double carbohidratosGramos;
    private double grasasGramos;

    public Macros(double calorias, double proteinasGramos, double carbohidratosGramos, double grasasGramos) {
        this.calorias = calorias;
        this.proteinasGramos = proteinasGramos;
        this.carbohidratosGramos = carbohidratosGramos;
        this.grasasGramos = grasasGramos;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getProteinasGramos() {
        return proteinasGramos;
    }

    public void setProteinasGramos(double proteinasGramos) {
        this.proteinasGramos = proteinasGramos;
    }

    public double getCarbohidratosGramos() {
        return carbohidratosGramos;
    }

    public void setCarbohidratosGramos(double carbohidratosGramos) {
        this.carbohidratosGramos = carbohidratosGramos;
    }

    public double getGrasasGramos() {
        return grasasGramos;
    }

    public void setGrasasGramos(double grasasGramos) {
        this.grasasGramos = grasasGramos;
    }

    

}
