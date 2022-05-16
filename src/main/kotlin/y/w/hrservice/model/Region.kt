package y.w.hrservice.model

import javax.persistence.*

@Entity
@Table(name = "regions")
open class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "region_id", nullable = false)
    open var id: Int? = null

    @Column(name = "region_name", length = 25)
    open var regionName: String? = null
}