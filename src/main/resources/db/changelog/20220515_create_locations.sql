CREATE TABLE locations
(
    location_id    SERIAL PRIMARY KEY,
    street_address VARCHAR(40),
    postal_code    VARCHAR(12),
    city           VARCHAR(30) NOT NULL,
    state_province VARCHAR(25),
    country_id     CHAR(2) REFERENCES countries (country_id)
);