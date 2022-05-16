CREATE TABLE jobs
(
    job_id     VARCHAR(10) PRIMARY KEY,
    job_title  VARCHAR(35) NOT NULL,
    min_salary NUMERIC(6),
    max_salary NUMERIC(6)
);