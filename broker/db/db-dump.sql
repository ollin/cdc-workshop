SET default_transaction_read_only = off;

SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;

--
-- Drop databases
--
DROP DATABASE IF EXISTS broker;

--
-- Drop roles
--
DROP ROLE IF EXISTS broker;

--
-- Roles
--
CREATE ROLE broker;
ALTER ROLE broker WITH NOSUPERUSER INHERIT NOCREATEROLE NOCREATEDB LOGIN NOREPLICATION NOBYPASSRLS PASSWORD 'md50890f0db0b9da90a6dab40d41dff1f59'; -- pw: broker123

--
-- Database creation
--
CREATE DATABASE broker WITH TEMPLATE = template0 OWNER = broker;
GRANT ALL ON DATABASE broker TO broker;


