BEGIN TRANSACTION;

CREATE SEQUENCE seq_ticket_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE TABLE ticket (
	ticket_id int DEFAULT nextval('seq_ticket_id'::regclass) NOT NULL,
        repair_type varchar(25) NOT NULL,
	CONSTRAINT PK_ticket PRIMARY KEY (ticket_id)
);

COMMIT TRANSACTION;