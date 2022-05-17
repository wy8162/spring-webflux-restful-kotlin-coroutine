package y.w.hrservice.model

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*
import java.math.*
import java.time.*

@Table(value = "employees")
open class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("employee_id")
    open var id: Int? = null

    @Column("first_name")
    open var firstName: String? = null

    @Column("last_name")
    open var lastName: String? = null

    @Column("email")
    open var email: String? = null

    @Column("phone_number")
    open var phoneNumber: String? = null

    @Column("hire_date")
    open var hireDate: Instant? = null

    @Column("job_id")
    open var jobId: String? = null

    @Column("salary")
    open var salary: BigDecimal? = null

    @Column("commission_pct")
    open var commissionPct: BigDecimal? = null

    @Column("manager_id")
    open var managerId: Int? = null

    @Column("department_id")
    open var departmentId: Int? = null
}