package es.proyecto.service;

import es.proyecto.model.Macros;

public class CalculadoraNutricional {


    public static double calcularCalorias(double peso, double altura, int edad, String genero, String estilo, String objetivo) {
        // Fórmula para calcular la tasa metabólica basal (TMB) - Miffflin-St Jeor
        double tmb = (10 * peso) + (6.25 * altura) - (5 * edad);

        if (genero.equalsIgnoreCase("Masculino")) {
            tmb += 5;
        } else {
            tmb -= 161;
        }

        // Factor de actividad según el estilo de vida
        double factorActividad;
        if (estilo.equals("Activo")) {
            factorActividad = 1.55;
        } else if (estilo.equals("Muy activo")) {
            factorActividad = 1.9;
        } else {
            factorActividad = 1.2; // Sedentario
        }

        double mantenimiento = tmb * factorActividad;

        // Ajuste de calorías según objetivo
        if (objetivo.equals("Perdida de grasa")) {
            return mantenimiento - 500;
        } else if (objetivo.equals("Ganancia muscular")) {
            return mantenimiento + 400;
        } else {
            return mantenimiento; // Mantenimiento
        }}
    

     

    public static Macros obtenerMacros(double calorias, double peso) {
        double proteinasGramos = peso * 2.0;
        double grasasGramos = peso * 0.9;
        double proteinasKcal = proteinasGramos * 4;
        double grasasKcal = grasasGramos * 9;
        double carbohidratosKcal = calorias - (proteinasKcal + grasasKcal);
        double carbohidratosGramos = carbohidratosKcal / 4;

        return new Macros(calorias, proteinasGramos, carbohidratosGramos, grasasGramos);
    }
}
