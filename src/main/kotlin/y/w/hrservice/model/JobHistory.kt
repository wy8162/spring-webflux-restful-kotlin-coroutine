package y.w.hrservice.model

import java.time.*
import javax.persistence.*

@Entity
@Table(name = "job_history")
open class JobHistory {
    @EmbeddedId
    open var id: JobHistoryId? = null

    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    open var employee: Employee? = null

    @Column(name = "end_date", nullable = false)
    open var endDate: Instant? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    open var department: Department? = null
}