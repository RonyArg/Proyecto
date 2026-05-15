 # Calculadora Nutricional de Macronutrientes

 Este branch es una variante de la aplicación con base de datos embebida, al inciar la app se crea la base de datos de las recetas y al finalizar se borra.

 Se usa Hibernate para la persistencia de datos, SQLite y JavaFX para la interfaz gráfica.


 ## Objetivo

 Desarrollar un software que calcule macronutrientes y calorías recomendadas para el perfil del usuario personalizado por un formulario de datos personales y ofrezca uns lista de recetas saludables el número de calorias aproximado (ración para 1 persona). 


 ## Descripción

La aplicación cuenta con dos ventanas principales:
1. **Ventana de entrada**: Solicita los datos del usuario para personalizar las recetas almacenadas en la base de datos.
2. **Ventana de resultados**: Realiza cálculos personalizados basados en:
   - La tasa metabólica basal (TMB).
   - Opciones seleccionadas en los ComboBox para ajustar las calorías y macronutrientes recomendados según el estilo de vida y características personales.

 > **Nota**: Este cálculo es una recomendación orientativa y **NO REMPLAZA EL TRABAJO DE UN NUTRICIONISTA**


## Tecnologías, lenguajes y herramientas

- **Lenguaje**: Java versión 25
- **Interfaz gráfica**: JavaFX 25 (FXML)
- **Persistencia**: Hibernate ORM (hibernate-core 7.2.4 Final)
- **Base de datos**: SQLite 3.53.1.0
- **Gestión de dependencias y build**: Maven
- **Herramientas adicionales**: Scene Builder (para FXML), JDBC (a través de Hibernate), hibernate-community-dialects (7.2.4.Final)


## Mejoras futuras

- **Rediseño visual con CSS**: Mediante hojas de estilo externas para modernizar la interfaz de usuario.
- **Migración a Spring Boot**.