package y.w.hrservice.model

import javax.persistence.*

@Entity
@Table(name = "locations")
open class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    open var id: Int? = null

    @Column(name = "street_address", length = 40)
    open var streetAddress: String? = null

    @Column(name = "postal_code", length = 12)
    open var postalCode: String? = null

    @Column(name = "city", nullable = false, length = 30)
    open var city: String? = null

    @Column(name = "state_province", length = 25)
    open var stateProvince: String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    open var country: Country? = null
}