package com.hennangadelha.apifilmes.filmes.service

import com.hennangadelha.apifilmes.filmes.models.Filme
import com.hennangadelha.apifilmes.filmes.models.dtos.FilmeRequest
import com.hennangadelha.apifilmes.filmes.repository.FilmeRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class FilmeServiceImpl(private val filmeRepository: FilmeRepository) : FilmeService {

    override fun cadastrar(filme: Filme) {
        filmeRepository.save(filme)
    }

    override fun deletar(id: UUID) {
        filmeRepository.deleteByFilmeUuid(id)
    }

    override fun alterar(filmeUUID: UUID, filme: Filme) {

        filmeRepository.update(filmeRepository.update(filme))
    }

    override fun listarTodos(): List<Filme> {
        return filmeRepository.findAll()
    }

    override fun buscarPorId(id: UUID): Optional<Filme> {
        return filmeRepository.findByFilmeUuid(id)
    }


}