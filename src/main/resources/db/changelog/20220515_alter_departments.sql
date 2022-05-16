ALTER TABLE DEPARTMENTS
    ADD CONSTRAINT dept_mgr_fk
        FOREIGN KEY (manager_id)
            REFERENCES employees (employee_id);