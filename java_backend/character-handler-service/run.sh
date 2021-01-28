#!/bin/sh

java -Dspring.datasource.url=jdbc:postgresql://${CHARACTER_POSTGRESQL_DB_HOST}:${CHARACTER_POSTGRESQL_DB_PORT}/${CHARACTER_POSTGRESQL_DB_NAME} \
  -Dspring.datasource.username=${CHARACTER_POSTGRESQL_DB_USERNAME} \
  -Dspring.datasource.password=${CHARACTER_POSTGRESQL_DB_PASSWORD}
