package es.proyecto.service;

import org.junit.jupiter.api.Test;
import es.proyecto.model.Macros;

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
        double resultadoEsperado = 2005.7; // 2507.125 * 0.8 (reducción del 20%)
        assertEquals(resultadoEsperado, resultado, 0.01);
    }

    @Test
    void obtenerMacros() {
        double calorias = 2500;
        double peso = 70;

        Macros resultado = CalculadoraNutricional.obtenerMacros(calorias, peso);

        // Calorías
        assertEquals(2500.0, resultado.getCalorias(), 0.01);

        // Proteínas: 70 * 2.0 = 140.00
        assertEquals(140.0, resultado.getProteinasGramos(), 0.01);

        // Grasas: 70 * 1.0 = 70.00
        assertEquals(70.0, resultado.getGrasasGramos(), 0.01);

        // Carbohidratos: (2500 - (140*4 + 70*9)) / 4 = 327.5
        assertEquals(327.5, resultado.getCarbohidratosGramos(), 0.01);
    }
}