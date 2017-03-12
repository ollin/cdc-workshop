#!/bin/bash
set -e

psql --username "$POSTGRES_USER" -f /db-dump.sql

