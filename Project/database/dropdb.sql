-- **************************************************************
-- This script resets the contents of the database
-- **************************************************************

DROP TABLE IF EXISTS employee_location;
DROP TABLE IF EXISTS location;
DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS contact;
DROP TABLE IF EXISTS position;
DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS ticket;

DROP ROLE IF EXISTS repair_tickets_owner;
DROP ROLE IF EXISTS repair_tickets_appuser;