package y.w.hrservice.model

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*

@Table("countries")
open class Country {
    @Id
    @Column("country_id")
    open var id: String? = null

    @Column("country_name")
    open var countryName: String? = null
}