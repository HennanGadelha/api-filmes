package com.hennangadelha.apifilmes.filmes.controller

import com.hennangadelha.apifilmes.filmes.models.dtos.FilmeRequest
import com.hennangadelha.apifilmes.filmes.models.dtos.FilmeResponse
import com.hennangadelha.apifilmes.filmes.service.FilmeServiceScyllaDb
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.*
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/api/v1/filmes")
class FilmeController(private val filmeServiceScyllaDb: FilmeServiceScyllaDb) {

    @Post("/cadastro")
    fun cadastro(@Body request: FilmeRequest): HttpResponse<Any> {

        val filme = request.toModel()
        filmeServiceScyllaDb.cadastrar(filme)

        return created(location(filme.filmeUuid))

    }

    private fun location(filmeUuid: UUID?) = HttpResponse.uri("/api/v1/filmes/$filmeUuid")

    @Get
    fun listarTodos(): HttpResponse<List<FilmeResponse>> {

        val filmes: List<FilmeResponse> =
            filmeServiceScyllaDb.listarTodos()
                .map { FilmeResponse(it.filmeUuid.toString(), it.titulo.toString(), it.sinopse.toString()) }

        return ok(filmes)
    }

    @Get("/{filmeUuid}")
    fun buscarPorUuid(filmeUuid: UUID): HttpResponse<FilmeResponse> {

        val filme = filmeServiceScyllaDb.buscarPorId(filmeUuid)

        return ok(FilmeResponse(filme.filmeUuid.toString(), filme.titulo.toString(), filme.sinopse.toString()))
    }

    @Delete("/{filmeUuid}")
    fun deletar(filmeUuid: UUID): HttpResponse<Any> {

        filmeServiceScyllaDb.deletar(filmeUuid)

        return ok()
    }

    @Put("/{filmeUuid}")
    fun alterar(filmeUuid: UUID, @Body request: FilmeRequest): HttpResponse<Any> {

        val filme = filmeServiceScyllaDb.buscarPorId(filmeUuid)

        filme.titulo = request.titulo
        filme.sinopse = request.sinopse

        filmeServiceScyllaDb.alterar(filmeUuid, filme)

        return ok<FilmeResponse>()
            .body(FilmeResponse(filme.filmeUuid.toString(), filme.titulo.toString(), filme.sinopse.toString()))
    }


}