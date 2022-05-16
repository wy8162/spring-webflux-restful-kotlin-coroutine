package y.w.hrservice.model

import javax.persistence.*

@Entity
@Table(name = "countries")
open class Country {
    @Id
    @Column(name = "country_id", nullable = false, length = 2)
    open var id: String? = null

    @Column(name = "country_name", length = 40)
    open var countryName: String? = null
}