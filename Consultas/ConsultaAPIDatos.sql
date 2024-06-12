CREATE DATABASE products_db;

INSERT INTO categories (name, description) VALUES
('Motor', 'Componentes y repuestos relacionados con el motor de los vehículos.'),
('Transmisión', 'Repuestos para el sistema de transmisión de los vehículos.'),
('Suspensión', 'Componentes y repuestos para el sistema de suspensión.'),
('Frenos', 'Repuestos y componentes para el sistema de frenos.'),
('Eléctrico', 'Componentes eléctricos y electrónicos para vehículos.');

INSERT INTO brands (name) VALUES
('Bosch'),
('ACDelco'),
('Delphi'),
('Denso'),
('Valeo');

INSERT INTO models (name, description, product_id) VALUES
('Modelo A', 'Descripción del Modelo A', 1),
('Modelo B', 'Descripción del Modelo B', 2),
('Modelo C', 'Descripción del Modelo C', 3),
('Modelo D', 'Descripción del Modelo D', 4),
('Modelo E', 'Descripción del Modelo E', 5),
('Modelo F', 'Descripción del Modelo F', 6);

INSERT INTO products (code, name, description, price, status) VALUES
('MOT001', 'Filtro de Aceite', 'Filtro de aceite para motor de alta calidad.', 15.99, 1),
('MOT002', 'Bujía de Encendido', 'Bujía de encendido para motor de combustión interna.', 4.50, 1),
('TRA001', 'Kit de Embrague', 'Kit completo de embrague para transmisión manual.', 120.00, 1),
('TRA002', 'Caja de Cambios', 'Caja de cambios para transmisión automática.', 850.00, 1),
('SUS001', 'Amortiguador Delantero', 'Amortiguador delantero para suspensión.', 75.00, 1),
('SUS002', 'Resorte de Suspensión', 'Resorte para suspensión de alta resistencia.', 30.00, 1),
('FRE001', 'Disco de Freno', 'Disco de freno para sistema de frenos.', 45.00, 1),
('FRE002', 'Pastillas de Freno', 'Juego de pastillas de freno para autos.', 25.00, 1),
('ELE001', 'Alternador', 'Alternador de alta eficiencia para sistema eléctrico.', 200.00, 1),
('ELE002', 'Batería', 'Batería de larga duración para vehículos.', 150.00, 1);
SELECT * FROM products;

INSERT INTO product_categories (product_id, category_id) VALUES
(1, 1), 
(2, 1), 
(3, 2), 
(4, 2), 
(5, 3), 
(6, 3), 
(7, 4), 
(8, 4), 
(9, 5), 
(10, 5);


INSERT INTO product_brands (product_id, brand_id) VALUES
(1, 1), 
(2, 2), 
(3, 3), 
(4, 4), 
(5, 5), 
(6, 1), 
(7, 2), 
(8, 3), 
(9, 4), 
(10, 5);

