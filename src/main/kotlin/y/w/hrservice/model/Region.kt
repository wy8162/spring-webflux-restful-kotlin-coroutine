package y.w.hrservice.model

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*

@Table("regions")
open class Region {
    @Id
    @Column("region_id")
    open var id: Int? = null

    @Column("region_name")
    open var regionName: String? = null
}