CREATE SCHEMA IF NOT EXISTS order_schema AUTHORIZATION root;

SET search_path TO order_schema;

CREATE TABLE IF NOT EXISTS categories (
        id           BIGINT NOT NULL PRIMARY KEY,
        category_name VARCHAR(255) NOT NULL
);

ALTER TABLE categories OWNER TO root;

CREATE SEQUENCE category_id_seq;

ALTER SEQUENCE category_id_seq OWNER TO root;

ALTER TABLE categories ALTER COLUMN id SET DEFAULT nextval('category_id_seq');