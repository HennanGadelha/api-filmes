package com.hennangadelha.apifilmes.filmes.service

import com.hennangadelha.apifilmes.filmes.models.Filme
import java.util.*

interface FilmeServiceNoSql {

    fun cadastrar(filme: Filme) : Filme;

    fun listarTodos(): List<Filme>

    fun buscarPorId(filmeUuid: UUID): Filme

    fun deletar(filmeUuid: UUID)

    fun alterar(filmeUuid: UUID, filme: Filme): Filme

}