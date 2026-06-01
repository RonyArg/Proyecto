 # Calculadora Nutricional de Macronutrientes

 Este branch es una variante de la aplicación con base de datos embebida, al inciar la app se crea la base de datos de las recetas y al finalizar se borra.

 Se usa Hibernate para la persistencia de datos, SQLite y JavaFX para la interfaz gráfica.

![Ventana principal](https://private-user-images.githubusercontent.com/193278705/600665385-c98daab9-225c-4556-b696-658937c884d5.png?jwt=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3ODAyNzA5MjYsIm5iZiI6MTc4MDI3MDYyNiwicGF0aCI6Ii8xOTMyNzg3MDUvNjAwNjY1Mzg1LWM5OGRhYWI5LTIyNWMtNDU1Ni1iNjk2LTY1ODkzN2M4ODRkNS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjYwNTMxJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI2MDUzMVQyMzM3MDZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT1iYzJkMDhmMDNlNTkwOTE0OWFhYjQxMjUwM2EwYWM0N2ViZmVlMGE3MjVhYTVjODA5ZmRkZGM4Mzc0MzFiZDZkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZyZXNwb25zZS1jb250ZW50LXR5cGU9aW1hZ2UlMkZwbmcifQ.Gd4fqn4dpSfuS61mBm2DxfeH35mfVWjyELqKIIKtatE)

 ## Objetivo

 Desarrollar un software que calcule macronutrientes y> calorías recomendadas para el perfil del usuario personalizado por un formulario de datos personales y ofrezca uns lista de recetas saludables el número de calorias aproximado (ración para 1 persona). 


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