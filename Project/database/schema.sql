BEGIN TRANSACTION;

/* TABLES */

CREATE TABLE address (
	address_id SERIAL PRIMARY KEY,
        street_no integer NOT NULL,
        street_name varchar(25) NOT NULL,
        city varchar(25) NOT NULL,
        state varchar(25) NOT NULL,
        zip_code integer NOT NULL
);

CREATE TABLE contact (
        contact_id SERIAL PRIMARY KEY,
        first_name varchar(25) NOT NULL,
        last_name varchar(25) NOT NULL,
        email varchar(50),
        phone varchar(20),
        address_id integer REFERENCES address
);

CREATE TABLE location (
        location_id SERIAL PRIMARY KEY,
        name varchar(50) UNIQUE NOT NULL,
        address_id integer REFERENCES address
);

CREATE TABLE position (
        position_id SERIAL PRIMARY KEY,
        name varchar(50) UNIQUE NOT NULL
);

CREATE TABLE employee (
        employee_id SERIAL PRIMARY KEY,
        contact_id integer REFERENCES contact,
        position_id integer REFERENCES position,
        hire_date date NOT NULL
);

CREATE TABLE employee_location (
        employee_id integer REFERENCES employee,
        location_id integer REFERENCES location,
        PRIMARY KEY (employee_id, location_id)
);

CREATE TABLE contractor (
        contractor_id SERIAL PRIMARY KEY,
        contact_id integer REFERENCES contact
);

CREATE TABLE service_category (
        service_category_id SERIAL PRIMARY KEY,
        name varchar(50) UNIQUE NOT NULL
);

CREATE TABLE contractor_service_category (
        contractor_id integer REFERENCES contractor,
        service_category_id integer REFERENCES service_category,
        PRIMARY KEY (contractor_id, service_category_id)
);

CREATE TABLE equipment_category (
        equipment_category_id SERIAL PRIMARY KEY,
        name varchar(25) UNIQUE NOT NULL
);

CREATE TABLE equipment (
        equipment_id SERIAL PRIMARY KEY,
        brand varchar(50) NOT NULL,
        model varchar(50) NOT NULL,
        serial_no varchar(50),
        equipment_category_id integer REFERENCES equipment_category,
        location_id integer REFERENCES location
);

CREATE TABLE ticket (
	ticket_id SERIAL PRIMARY KEY,
	location_id integer REFERENCES location,
	equipment_id integer REFERENCES equipment,
	service_category_id integer REFERENCES service_category,
	description varchar(500) NOT NULL,
	employee_id integer REFERENCES employee,
	contractor_id integer REFERENCES contractor,
	estimate bigint,
	submitted_on date NOT NULL,
	completed_on timestamp,
        active boolean DEFAULT true
);

CREATE TABLE invoice (
        invoice_id SERIAL PRIMARY KEY,
        ticket_id integer REFERENCES ticket,
        invoice_no integer,
        invoice_total bigint NOT NULL,
        due_date date NOT NULL,
        paid_date date,
        active boolean DEFAULT true
);

/* DB USERS */

CREATE USER repair_tickets_owner
WITH PASSWORD 'repairtickets';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO repair_tickets_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO repair_tickets_owner;

CREATE USER repair_tickets_appuser
WITH PASSWORD 'repairtickets';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO repair_tickets_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO repair_tickets_appuser;

COMMIT TRANSACTION;