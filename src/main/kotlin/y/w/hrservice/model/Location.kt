package y.w.hrservice.model

import org.springframework.data.annotation.*
import org.springframework.data.relational.core.mapping.*

@Table("locations")
open class Location {
    @Id
    @Column("location_id")
    open var id: Int? = null

    @Column("street_address")
    open var streetAddress: String? = null

    @Column("postal_code")
    open var postalCode: String? = null

    @Column("city")
    open var city: String? = null

    @Column("state_province")
    open var stateProvince: String? = null

    @Column("country_id")
    open var countryId: String? = null
}