package y.w.hrservice.model

import java.math.*
import javax.persistence.*

@Entity
@Table(name = "jobs")
open class Job {
    @Id
    @Column(name = "job_id", nullable = false, length = 10)
    open var id: String? = null

    @Column(name = "job_title", nullable = false, length = 35)
    open var jobTitle: String? = null

    @Column(name = "min_salary", precision = 6)
    open var minSalary: BigDecimal? = null

    @Column(name = "max_salary", precision = 6)
    open var maxSalary: BigDecimal? = null
}