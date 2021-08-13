package com.hennangadelha.apifilmes.filmes.models.dtos

import com.hennangadelha.apifilmes.filmes.models.Filme
import java.util.*

data class FilmeRequest(val filmeUuid: UUID =  UUID.randomUUID(), val titulo: String, val sinopse: String){

    fun toModel() : Filme{
        return Filme(filmeUuid, titulo, sinopse)
    }

}
