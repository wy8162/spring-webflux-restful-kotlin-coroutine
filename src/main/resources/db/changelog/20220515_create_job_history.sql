CREATE TABLE job_history
(
    employee_id   INTEGER     NOT NULL REFERENCES employees (employee_id),
    start_date    TIMESTAMP   NOT NULL,
    end_date      TIMESTAMP   NOT NULL,
    job_id        VARCHAR(10) NOT NULL REFERENCES jobs (job_id),
    department_id INTEGER REFERENCES departments (department_id),
    CONSTRAINT jhist_date_interval
        CHECK (end_date > start_date),
    PRIMARY KEY (employee_id, start_date)
);