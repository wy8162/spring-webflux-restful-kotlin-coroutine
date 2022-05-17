package y.w.hrservice.model

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*
import java.time.*

@Table("job_history")
open class JobHistory {
    @Id
    @Column("job_id")
    open var id: String? = null

    @Column("employee_id")
    open var employeeId: Int? = null

    @Column("start_date")
    open var startDate: Instant? = null

    @Column("end_date")
    open var endDate: Instant? = null

    @Column("department_id")
    open var departmentId: Int? = null
}