package com.hennangadelha.apifilmes.filmes.controller

import com.hennangadelha.apifilmes.filmes.models.Filme
import com.hennangadelha.apifilmes.filmes.models.dtos.FilmeRequest
import com.hennangadelha.apifilmes.filmes.models.dtos.FilmeResponse
import com.hennangadelha.apifilmes.filmes.service.FilmeService
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpResponse.*
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/api/v1/filmes")
class FilmeController(private val filmeService: FilmeService) {

    @Post("/cadastro")
    fun cadastro(@Body request: FilmeRequest) : HttpResponse<Any> {

        val filme = request.toModel()
        filmeService.cadastrar(filme)

        return created(location(filme.filmeUuid))

    }
    private fun location(filmeUuid: UUID) = HttpResponse.uri("/api/v1/filmes/$filmeUuid")

    @Get
    fun listarTodos() : HttpResponse<List<FilmeResponse>>{

        val filmes: List<FilmeResponse> =
            filmeService.listarTodos().map { FilmeResponse( it.filmeUuid.toString(), it.getTitulo(), it.getSinopse()) }

        return ok(filmes)
    }

    @Get("/{filmeUuid}")
    fun buscarPorUuid(filmeUuid: UUID): HttpResponse<FilmeResponse>{

        val filme = filmeService.buscarPorId(filmeUuid)

        if (filme!!.isEmpty) return notFound()

        return ok(FilmeResponse(filme!!.get().filmeUuid.toString(), filme!!.get().getTitulo(), filme.get().getSinopse()))
    }

    @Delete("/{filmeUuid}")
    fun deletar(filmeUuid: UUID): HttpResponse<Any>{

        filmeService.deletar(filmeUuid)

        return ok()
    }

    @Put("/{filmeUuid}")
    fun alterar(filmeUuid: UUID, @Body request: FilmeRequest): HttpResponse<Any>{


        val filme = filmeService.buscarPorId(filmeUuid)

        filme!!.get().setTitulo(request.titulo)
        filme.get().setSinopse(request.sinopse)

        if (filme!!.isEmpty) return notFound()

        filmeService.alterar(filmeUuid, filme.get())

        return ok<FilmeResponse>()
            .body(FilmeResponse(filme.get().filmeUuid.toString(), filme.get().getTitulo(), filme.get().getSinopse()))
    }




}