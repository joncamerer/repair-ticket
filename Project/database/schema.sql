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
        name varchar(50) NOT NULL,
        address_id integer REFERENCES address
);

CREATE TABLE position (
        position_id SERIAL PRIMARY KEY,
        name varchar(50) NOT NULL
);

CREATE TABLE employee (
        employee_id SERIAL PRIMARY KEY,
        contact_id integer REFERENCES contact,
        position_id integer REFERENCES position,
        hire_date DATE NOT NULL
);

CREATE TABLE employee_location (
        employee_id integer REFERENCES employee,
        location_id integer REFERENCES location,
        UNIQUE (employee_id, location_id)
);

CREATE TABLE ticket (
	ticket_id SERIAL PRIMARY KEY,
        repair_type varchar(25) NOT NULL,
        active boolean DEFAULT true NOT NULL
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