BEGIN TRANSACTION;

INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (7531, 'N. Damen Ave', 'Chicago', 'Illinois', 60645);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (3110, 'N. Tripp Ave', 'Chicago', 'Illinois', 60641);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (4333, 'N. Bernard St', 'Chicago', 'Illinois', 60618);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (5401, 'N. Central Ave', 'Chicago', 'Illinois', 60630);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (223, 'N. Kostner Ave', 'Chicago', 'Illinois', 60624);

INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (352, 'N. Clark St', 'Chicago', 'Illinois', 60654);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (8, 'W. Lake St', 'Chicago', 'Illinois', 60601);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (37, 'S. La Salle St', 'Chicago', 'Illinois', 60603);

INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (4710, 'N. Dover St', 'Chicago', 'Illinois', 60640);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (658, 'W. 35th St', 'Chicago', 'Illinois', 60616);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (4746, 'S. Ashland Ave', 'Chicago', 'Illinois', 60609);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (2524, 'W. North Ave', 'Chicago', 'Illinois', 60647);

INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Demi', 'Demoton', 'demi@example.com', '312-555-1234', 1);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Dee', 'Distri', 'dee@example.com', '312-555-1884', 2);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Statesy', 'Manayay', 'statesy@example.com', '312-555-6734', 3);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('North', 'Mang', 'north@example.com', '312-555-9934', 4);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Sally', 'Mang', 'sally@example.com', '312-555-9349', 5);

INSERT INTO location (name, address_id) VALUES ('River North', 6);
INSERT INTO location (name, address_id) VALUES ('State', 7);
INSERT INTO location (name, address_id) VALUES ('La Salle', 8);

INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Henry', 'Handyman', 'henry.handyman@example.com', '312-555-4321', 9);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Reggie', 'Cooling', 'coolreggie99@example.com', '312-555-1551', 10);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Perry', 'Plumb', 'pipes.per.perry@example.com', '312-555-1999', 11);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Rocky', 'Redson', 'rockysrepairschi@example.com', '312-555-9871', 12);

INSERT INTO position (name) VALUES ('Administrator');
INSERT INTO position (name) VALUES ('District Manager');
INSERT INTO position (name) VALUES ('General Manager');
INSERT INTO position (name) VALUES ('Supervisor');
INSERT INTO position (name) VALUES ('Shift');

INSERT INTO employee (contact_id, position_id, hire_date) VALUES (1, 1, 'jan-01-2012');
INSERT INTO employee (contact_id, position_id, hire_date) VALUES (2, 2, 'jun-10-2017');
INSERT INTO employee (contact_id, position_id, hire_date) VALUES (3, 3, 'jun-17-2020');
INSERT INTO employee (contact_id, position_id, hire_date) VALUES (4, 3, 'oct-09-2019');
INSERT INTO employee (contact_id, position_id, hire_date) VALUES (5, 3, 'jul-01-2020');

INSERT INTO employee_location (employee_id, location_id) VALUES (1, 1);
INSERT INTO employee_location (employee_id, location_id) VALUES (1, 2);
INSERT INTO employee_location (employee_id, location_id) VALUES (1, 3);
INSERT INTO employee_location (employee_id, location_id) VALUES (2, 1);
INSERT INTO employee_location (employee_id, location_id) VALUES (2, 2);
INSERT INTO employee_location (employee_id, location_id) VALUES (2, 3);
INSERT INTO employee_location (employee_id, location_id) VALUES (3, 2);
INSERT INTO employee_location (employee_id, location_id) VALUES (4, 1);
INSERT INTO employee_location (employee_id, location_id) VALUES (5, 3);

INSERT INTO contractor (contact_id) VALUES (6);
INSERT INTO contractor (contact_id) VALUES (7);
INSERT INTO contractor (contact_id) VALUES (8);
INSERT INTO contractor (contact_id) VALUES (9);

INSERT INTO service_category (name) VALUES ('Refrigeration');
INSERT INTO service_category (name) VALUES ('HVAC');
INSERT INTO service_category (name) VALUES ('Plumbing');
INSERT INTO service_category (name) VALUES ('Construction');
INSERT INTO service_category (name) VALUES ('Maintainence');
INSERT INTO service_category (name) VALUES ('Heating');
INSERT INTO service_category (name) VALUES ('General');

INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (1, 3);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (1, 4);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (1, 7);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (2, 1);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (2, 2);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (2, 6);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (3, 3);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (4, 3);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (4, 4);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (4, 5);
INSERT INTO contractor_service_category (contractor_id, service_category_id) VALUES (4, 7);

INSERT INTO equipment_category (name) VALUES ('Refrigeration');
INSERT INTO equipment_category (name) VALUES ('Plumbing');
INSERT INTO equipment_category (name) VALUES ('Food Preperation');
INSERT INTO equipment_category (name) VALUES ('Heating/ Cooking');
INSERT INTO equipment_category (name) VALUES ('Structural');
INSERT INTO equipment_category (name) VALUES ('HVAC/ Ventilation');

INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Avantco', 'A-49F-HC', '1000029374TH', 1, 1);
INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Vulcan', 'VC5ED-11D1', 'S009374564-00034', 4, 1);
INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Avantco', 'A-49F-HC', '1000025678TH', 1, 2);
INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Vulcan', 'VC5ED-11D1', 'S009371268-00034', 4, 2);
INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Avantco', 'A-49F-HC', '1000029436TH', 1, 3);
INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Vulcan', 'VC5ED-11D1', 'S009374575-00034', 4, 3);

INSERT INTO ticket (location_id, equipment_id, service_category_id, description, employee_id, contractor_id, estimate, active)
        VALUES (1, 1, 1, 'An example description of equipment problem', 1, 1, 150000, true);

COMMIT TRANSACTION;