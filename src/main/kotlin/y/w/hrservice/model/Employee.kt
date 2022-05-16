package y.w.hrservice.model

import java.math.*
import java.time.*
import javax.persistence.*

@Entity
@Table(name = "employees")
open class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    open var id: Int? = null

    @Column(name = "first_name", length = 20)
    open var firstName: String? = null

    @Column(name = "last_name", nullable = false, length = 25)
    open var lastName: String? = null

    @Column(name = "email", nullable = false, length = 25)
    open var email: String? = null

    @Column(name = "phone_number", length = 20)
    open var phoneNumber: String? = null

    @Column(name = "hire_date", nullable = false)
    open var hireDate: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    open var job: Job? = null

    @Column(name = "salary", precision = 8, scale = 2)
    open var salary: BigDecimal? = null

    @Column(name = "commission_pct", precision = 2, scale = 2)
    open var commissionPct: BigDecimal? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    open var manager: Employee? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    open var department: Department? = null
}