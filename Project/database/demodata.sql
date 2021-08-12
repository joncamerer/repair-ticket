BEGIN TRANSACTION;

INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (7531, 'N. Damen Ave', 'Chicago', 'Illinois', 60645);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (352, 'N. Clark St', 'Chicago', 'Illinois', 60654);
INSERT INTO address (street_no, street_name, city, state, zip_code) VALUES (4710, 'N. Dover St', 'Chicago', 'Illinois', 60640);

INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Laura', 'Demoton', 'laura.d@example.com', '312-555-1234', 1);
INSERT INTO contact (first_name, last_name, email, phone, address_id) VALUES ('Roger', 'Contracton', 'roger.handyman@example.com', '312-555-4321', 3);

INSERT INTO location (name, address_id) VALUES ('River North', 2);

INSERT INTO position (name) VALUES ('Administrator');
INSERT INTO position (name) VALUES ('District Manager');
INSERT INTO position (name) VALUES ('General Manager');
INSERT INTO position (name) VALUES ('Supervisor');
INSERT INTO position (name) VALUES ('Shift');

INSERT INTO employee (contact_id, position_id, hire_date) VALUES (1, 1, 'jan-01-2012');

INSERT INTO employee_location (employee_id, location_id) VALUES (1, 1);

INSERT INTO contractor (contact_id) VALUES (2);

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

INSERT INTO equipment_category (name) VALUES ('Refrigeration');
INSERT INTO equipment_category (name) VALUES ('Plumbing');
INSERT INTO equipment_category (name) VALUES ('Food Preperation');
INSERT INTO equipment_category (name) VALUES ('Heating/ Cooking');
INSERT INTO equipment_category (name) VALUES ('Structural');
INSERT INTO equipment_category (name) VALUES ('HVAC/ Ventilation');

INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Avantco', 'A-49F-HC', '1000029374TH', 1, 1);
INSERT INTO equipment (brand, model, serial_no, equipment_category_id, location_id) VALUES ('Vulcan', 'VC5ED-11D1', 'S009374564-00034', 4, 1);

INSERT INTO ticket (location_id, equipment_id, service_category_id, description, employee_id, contractor_id, estimate, active)
        VALUES (1, 1, 1, 'An example description of equipment problem', 1, 1, 150000, true);

COMMIT TRANSACTION;