-- **************************************************************
-- This script resets the contents of the database
-- **************************************************************
BEGIN TRANSACTION;

DROP TABLE IF EXISTS invoice;
DROP TABLE IF EXISTS ticket;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS equipment_type;
DROP TABLE IF EXISTS contractor_service_category;
DROP TABLE IF EXISTS service_category;
DROP TABLE IF EXISTS contractor;
DROP TABLE IF EXISTS employee_location;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS address;

DROP ROLE IF EXISTS repair_tickets_owner;
DROP ROLE IF EXISTS repair_tickets_appuser;

COMMIT TRANSACTION;