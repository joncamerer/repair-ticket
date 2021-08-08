-- **************************************************************
-- This script resets the contents of the database
-- **************************************************************

DROP TABLE IF EXISTS address;
DROP TABLE IF EXISTS ticket;

DROP ROLE IF EXISTS repair_tickets_owner;
DROP ROLE IF EXISTS repair_tickets_appuser;