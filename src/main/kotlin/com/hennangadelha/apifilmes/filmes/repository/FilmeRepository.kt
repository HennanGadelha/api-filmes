package com.hennangadelha.apifilmes.filmes.repository

import com.hennangadelha.apifilmes.filmes.models.Filme
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface FilmeRepository : JpaRepository<Filme, Long> {
     fun findByFilmeUuid(id: UUID) : Optional<Filme>

     fun deleteByFilmeUuid(filmeUuid: UUID)

}