package com.hennangadelha.apifilmes.filmes.service

import com.hennangadelha.apifilmes.filmes.models.Filme
import java.util.*


interface FilmeService {

    fun buscarPorId(id: UUID): Optional<Filme>?

    fun listarTodos(): List<Filme>

    fun cadastrar(filme: Filme)

    fun deletar(id: UUID)

    fun alterar(filmeUUID: UUID, filme: Filme)

}