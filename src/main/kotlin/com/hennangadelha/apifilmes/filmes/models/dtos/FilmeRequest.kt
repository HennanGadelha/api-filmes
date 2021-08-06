package com.hennangadelha.apifilmes.filmes.models.dtos

import com.hennangadelha.apifilmes.filmes.models.Filme

data class FilmeRequest(val titulo: String, val sinopse: String){

    fun toModel() : Filme{
        return Filme(titulo, sinopse)
    }

}
