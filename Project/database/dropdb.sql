-- **************************************************************
-- This script resets the contents of the database
-- **************************************************************

DROP TABLE IF EXISTS tickets;

DROP SEQUENCE IF EXISTS seq_tickets_id;

DROP ROLE IF EXISTS repair_tickets_owner;
DROP ROLE IF EXISTS repair_tickets_appuser;