package y.w.hrservice.model

import org.hibernate.*
import java.io.Serializable
import java.time.*
import java.util.*
import javax.persistence.*

@Embeddable
open class JobHistoryId : Serializable {
    @Column(name = "employee_id", nullable = false)
    open var employeeId: Int? = null

    @Column(name = "start_date", nullable = false)
    open var startDate: Instant? = null

    override fun hashCode(): Int = Objects.hash(employeeId, startDate)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false

        other as JobHistoryId

        return employeeId == other.employeeId &&
                startDate == other.startDate
    }

    companion object {
        private const val serialVersionUID = 3382465306185125715L
    }
}