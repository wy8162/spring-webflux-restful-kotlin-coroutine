package y.w.hrservice.model

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*
import java.math.*

@Table("jobs")
open class Job {
    @Id
    @Column("job_id")
    open var id: String? = null

    @Column("job_title")
    open var jobTitle: String? = null

    @Column("min_salary")
    open var minSalary: BigDecimal? = null

    @Column("max_salary")
    open var maxSalary: BigDecimal? = null
}