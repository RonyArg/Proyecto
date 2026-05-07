package es.proyecto.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraNutricionalTest {

    @Test
    void calcularCalorias() {
        double peso = 70;
        double altura = 170.0;
        int edad = 30;
        String genero = "Masculino";
        String estilo = "Activo";
        String objetivo = "Mantenimiento";

        double resultado = CalculadoraNutricional.calcularCalorias(peso, altura, edad, genero, estilo, objetivo);

        double resultadoEsperado = 2507.125;
        assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    void calcularCaloriasMujer() {
        double resultado = CalculadoraNutricional.calcularCalorias(70, 170.0, 30, "Femenino", "Activo", "Mantenimiento");
        double resultadoEsperado = 2249.825;
        assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    void calcularCaloriasPerdidaDeGrasa() {
        double resultado = CalculadoraNutricional.calcularCalorias(70, 170.0, 30, "Masculino", "Activo", "Perdida de grasa");
        double resultadoEsperado = 2007.125; // 2507.125 - 500
        assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    void obtenerMacros() {
        double calorias = 2500;
        double peso = 70;

        String resultado = CalculadoraNutricional.obtenerMacros(calorias, peso);

        // Calorías
        assertTrue(resultado.contains("Calorías: 2500"));

        // Proteínas: 70 * 2.0 = 140.00
        assertTrue(resultado.contains("Proteínas: 140,00 gramos"));

        // Grasas: 70 * 0.9 = 63.00
        assertTrue(resultado.contains("Grasas: 63,00 gramos"));

        // Carbohidratos: (2500 - (140*4 + 63*9)) / 4 = 343.25
        assertTrue(resultado.contains("Carbohidratos: 343,25 gramos"));


    }
}