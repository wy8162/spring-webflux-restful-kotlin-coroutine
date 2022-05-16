package y.w.hrservice.repository

import org.springframework.data.r2dbc.repository.*
import y.w.hrservice.model.*

interface CountryRepository: R2dbcRepository<Country, String>