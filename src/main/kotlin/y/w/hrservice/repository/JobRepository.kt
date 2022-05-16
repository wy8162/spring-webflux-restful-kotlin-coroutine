package y.w.hrservice.repository

import org.springframework.data.r2dbc.repository.*
import y.w.hrservice.model.*

interface JobRepository: R2dbcRepository<Job, String>