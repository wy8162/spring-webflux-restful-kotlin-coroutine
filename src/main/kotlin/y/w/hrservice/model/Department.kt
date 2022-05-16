package y.w.hrservice.model

import javax.persistence.*

@Entity
@Table(name = "departments")
open class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable = false)
    open var id: Int? = null

    @Column(name = "department_name", nullable = false, length = 30)
    open var departmentName: String? = null
}