package com.hennangadelha.apifilmes.filmes.models

import io.micronaut.http.annotation.Get
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Filme(
    private var titulo: String,
    private var sinopse: String
) {

    @Id
    @GeneratedValue
    val id: Long? = null;
    val filmeUuid: UUID = UUID.randomUUID()


    fun getTitulo() : String{
        return this.titulo
    }

    fun getSinopse() : String{
        return this.sinopse
    }

    fun setTitulo(titulo: String){
        this.titulo = titulo
    }

    fun setSinopse(sinopse: String){
        this.sinopse = sinopse
    }

}