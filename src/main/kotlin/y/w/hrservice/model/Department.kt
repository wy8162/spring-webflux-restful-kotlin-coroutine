package y.w.hrservice.model

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*

@Table("departments")
open class Department {
    @Id
    @Column("department_id")
    open var id: Int? = null

    @Column("department_name")
    open var departmentName: String? = null
}