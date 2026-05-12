# Estructura de la Base de Datos

## Tabla Recetas

Para crear la tabla, ejecuta el siguiente comando SQL:

```sql
-- Crear tabla de Recetas
CREATE TABLE IF NOT EXISTS recetas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    calorias DECIMAL(10, 2) NOT NULL,
    proteinas DECIMAL(10, 2),
    grasas DECIMAL(10, 2),
    carbohidratos DECIMAL(10, 2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Insertar recetas de ejemplo
INSERT INTO recetas (nombre, calorias, proteinas, grasas, carbohidratos) VALUES
('Pechuga a la plancha con ensalada ligera', 229, 40, 5, 10),
('Albóndigas de pollo con arroz cocido', 355, 35, 12, 30),
('Estofado de carne con patata cocida', 436, 38, 18, 35);