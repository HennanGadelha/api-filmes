package com.hennangadelha.apifilmes.filmes.models

import io.micronaut.http.annotation.Get
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Filme(
    val filmeUuid: UUID?,
    var titulo: String?,
    var sinopse: String?,

    ) {

    @Id
    @GeneratedValue
    val id: Long? = null;

}