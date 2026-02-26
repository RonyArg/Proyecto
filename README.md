 # Calculadora Nutricional de Macronutrientes

 Este proyecto hace uso de Hibernate para la persistencia de datos y JavaFX para la interfaz gráfica.

 ## Objetivo
 Desarrollar un software que simplifique la elección de comidas saludables en el día a día, ofreciendo:
- Una lista de recetas con cálculos orientativos de macronutrientes.
- Una vista global de calorías y macronutrientes recomendados según las características del usuario.


 ## Descripción

La aplicación cuenta con dos ventanas principales:
1. **Ventana de entrada**: Solicita los datos del usuario para personalizar las recetas almacenadas en la base de datos.
2. **Ventana de resultados**: Realiza cálculos personalizados basados en:
   - La tasa metabólica basal (TMB).
   - Opciones seleccionadas en los ComboBox para ajustar las calorías y macronutrientes recomendados según el estilo de vida y características personales.

 > **Nota**: Este cálculo es una recomendación orientativa y **NO REMPLAZA EL TRABAJO DE UN NUTRICIONISTA**


## Tecnologías, lenguajes y herramientas
- **Lenguaje**: Java versión 21
- **Interfaz gráfica**: JavaFX 21 (FXML)
- **Persistencia**: Hibernate ORM (hibernate-core 7.2.4 Final)
- **Base de datos**: MySQL 9.6.0
- **Gestión de dependencias y build**: Maven
- **Herramientas adicionales**: Scene Builder (para FXML), JDBC (a través de Hibernate)

## Mejoras futuras
El estado es funcional, ahora el proceso se orienta en mejorar la información que se ofrece al usuario para que sea más intuitivo.

Posteriormente se realizará una migración de Hibernate a Spring Boot, todo este proceso se registrará en GitHub y posiblemente para la migración se cree un branch nuevo.