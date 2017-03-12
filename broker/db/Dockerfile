FROM postgres:9.5.3
MAINTAINER Oliver Nautsch
ADD db-dump.sql /
ADD docker-entrypoint-initdb.d/*.sh /docker-entrypoint-initdb.d/
