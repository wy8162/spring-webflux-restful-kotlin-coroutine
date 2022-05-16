CREATE TABLE countries
(
    country_id   CHAR(2) not null PRIMARY KEY,
    country_name VARCHAR(40),
    region_id    INTEGER REFERENCES regions (region_id)
);