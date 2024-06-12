CREATE DATABASE products_db;

INSERT INTO categories (name, description) VALUES
('Engine', 'Components and spare parts related to the vehicle engine.'),
('Transmission', 'Spare parts for the vehicle transmission system.'),
('Suspension', 'Components and spare parts for the suspension system.'),
('Brakes', 'Spare parts and components for the brake system.'),
('Electrical', 'Electrical and electronic components for vehicles.');

INSERT INTO brands (name) VALUES
('Bosch'),
('ACDelco'),
('Delphi'),
('Denso'),
('Valeo');

INSERT INTO models (name, description, product_id) VALUES
('Model A', 'Description of Model A', 1),
('Model B', 'Description of Model B', 2),
('Model C', 'Description of Model C', 3),
('Model D', 'Description of Model D', 4),
('Model E', 'Description of Model E', 5),
('Model F', 'Description of Model F', 6);

INSERT INTO products (code, name, description, price, status) VALUES
('MOT001', 'Oil Filter', 'High quality engine oil filter.', 15.99, 1),
('MOT002', 'Spark Plug', 'Spark plug for internal combustion engine.', 4.50, 1),
('TRA001', 'Clutch Kit', 'Complete clutch kit for manual transmission.', 120.00, 1),
('TRA002', 'Gearbox', 'Automatic transmission gearbox.', 850.00, 1),
('SUS001', 'Front Shock Absorber', 'Front shock absorber for suspension.', 75.00, 1),
('SUS002', 'Suspension Spring', 'High resistance suspension spring.', 30.00, 1),
('FRE001', 'Brake Disc', 'Brake disc for brake system.', 45.00, 1),
('FRE002', 'Brake Pads', 'Set of brake pads for cars.', 25.00, 1),
('ELE001', 'Alternator', 'High efficiency alternator for electrical system.', 200.00, 1),
('ELE002', 'Battery', 'Long-lasting battery for vehicles.', 150.00, 1);

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
