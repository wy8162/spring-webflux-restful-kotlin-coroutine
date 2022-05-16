CREATE TABLE departments
(
    department_id   SERIAL PRIMARY KEY,
    department_name VARCHAR(30) NOT NULL,
    manager_id      INTEGER,
    location_id     INTEGER references locations (location_id)
);