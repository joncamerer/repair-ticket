BEGIN TRANSACTION;

CREATE TABLE address (
	address_id SERIAL PRIMARY KEY,
        street_no INT NOT NULL,
        street_name VARCHAR(25) NOT NULL,
        city VARCHAR(25) NOT NULL,
        state VARCHAR(25) NOT NULL,
        zip_code INT NOT NULL
);

CREATE TABLE ticket (
	ticket_id SERIAL PRIMARY KEY,
        repair_type varchar(25) NOT NULL,
        active boolean DEFAULT true NOT NULL
);

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