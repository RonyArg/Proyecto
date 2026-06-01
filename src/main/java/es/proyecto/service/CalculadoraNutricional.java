package es.proyecto.service;

import es.proyecto.model.Macros;

public class CalculadoraNutricional {


    public static double calcularCalorias(double peso, double altura, int edad, String genero, String estilo, String objetivo) {
        // Fórmula para calcular la tasa metabólica basal (TMB) - Mifflin-St Jeor
        double tmb = (10 * peso) + (6.25 * altura) - (5 * edad);

        if (genero.equalsIgnoreCase("Masculino")) {
            tmb += 5;
        } else {
            tmb -= 161;
        }

        // Factor de actividad según el estilo de vida
        double factorActividad;
        if (estilo.equals("Activo")) {
            factorActividad = 1.55; // Ejercicio 3-5 días/semana
        } else if (estilo.equals("Muy activo")) {
            factorActividad = 1.725; // Ejercicio 6-7 días/semana
        } else {
            factorActividad = 1.2; // Sedentario
        }

        double mantenimiento = tmb * factorActividad;

        // Ajuste de calorías según objetivo
        if (objetivo.equals("Perdida de grasa")) {
            return mantenimiento * 0.8; // Reducción del 20%
        } else if (objetivo.equals("Ganancia muscular")) {
            return mantenimiento * 1.15; // Aumento del 15%
        } else {
            return mantenimiento; // Mantenimiento
        }
    }

    public static Macros obtenerMacros(double calorias, double peso) {
        // Distribucion de macronutrientes:
        // Proteinas: 1.8-2.2g por kg de peso corporal
        // Grasas: 0.8-1.2g por kg de peso corporal
        // Carbohidratos: el resto de calorias disponibles
        
        double proteinasGramos = peso * 2.0;
        double grasasGramos = peso * 1.0;
        double proteinasKcal = proteinasGramos * 4;
        double grasasKcal = grasasGramos * 9;
        double carbohidratosKcal = calorias - (proteinasKcal + grasasKcal);
        
        // Validacion: asegurar que los carbohidratos no sean negativos
        if (carbohidratosKcal < 0) {
            carbohidratosKcal = calorias * 0.2; // Minimo 20% de calorias en carbohidratos
            grasasKcal = calorias * 0.2; // 20% en grasas
            proteinasKcal = calorias * 0.6; // 60% en proteinas
            proteinasGramos = proteinasKcal / 4;
            grasasGramos = grasasKcal / 9;
        }
        
        double carbohidratosGramos = carbohidratosKcal / 4;

        return new Macros(calorias, proteinasGramos, carbohidratosGramos, grasasGramos);
    }
}
