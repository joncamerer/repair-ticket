BEGIN TRANSACTION;

CREATE SEQUENCE seq_tickets_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE tickets (
	tickets_id int DEFAULT nextval('seq_tickets_id'::regclass) NOT NULL,
        repair_type varchar(25) NOT NULL,
	CONSTRAINT PK_tickets PRIMARY KEY (tickets_id)
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

INSERT INTO tickets (repair_type) VALUES ('maintenance');

COMMIT TRANSACTION;