CREATE TABLE employees
(
    employee_id    SERIAL PRIMARY KEY,
    first_name     VARCHAR(20),
    last_name      VARCHAR(25) NOT NULL,
    email          VARCHAR(25) NOT NULL,
    phone_number   VARCHAR(20),
    hire_date      TIMESTAMP   NOT NULL,
    job_id         VARCHAR(10) NOT NULL REFERENCES jobs (job_id),
    salary         NUMERIC(8, 2),
    commission_pct NUMERIC(2, 2),
    manager_id     INTEGER REFERENCES employees (employee_id),
    department_id  INTEGER REFERENCES departments (department_id),
    CONSTRAINT emp_salary_min
        CHECK (salary > 0),
    CONSTRAINT emp_email_uk
        UNIQUE (email)
);