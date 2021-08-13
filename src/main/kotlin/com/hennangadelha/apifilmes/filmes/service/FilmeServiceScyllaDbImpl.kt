package com.hennangadelha.apifilmes.filmes.service

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.hennangadelha.apifilmes.filmes.models.Filme
import java.util.*
import javax.inject.Singleton

@Singleton
class FilmeServiceScyllaDbImpl(private val cqlSession: CqlSession) : FilmeServiceScyllaDb {

    override fun cadastrar(filme: Filme): Filme {

        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO filmesdb.filme (filmeUuid, titulo, sinopse) VALUES (?,?,?) IF NOT EXISTS",
                filme.filmeUuid,
                filme.titulo,
                filme.sinopse
            )
        )
        return filme
    }

    override fun listarTodos(): List<Filme> {

        val resultQuery = cqlSession.execute(
            SimpleStatement
                .newInstance("SELECT * FROM filmesdb.filme")
        )
        return resultQuery.map {
            Filme(
                it.getUuid("filmeUuid"),
                it.getString("titulo"), it.getString("sinopse")
            )
        }.toList()
    }

    override fun buscarPorId(filmeUuid: UUID): Filme {

        val filme = cqlSession.execute(
            SimpleStatement
                .newInstance("SELECT * FROM filme WHERE filmeuuid = $filmeUuid")
        )
        return filme.map {
            Filme(
                it.getUuid("filmeUuid"),
                it.getString("titulo"),
                it.getString("sinopse")
            )
        }.first()
    }

    override fun deletar(filmeUuid: UUID) {
        cqlSession.execute(
            SimpleStatement
                .newInstance("DELETE  FROM filme WHERE filmeuuid = $filmeUuid")
        )
    }

    override fun alterar(filmeUuid: UUID, filme: Filme): Filme {

        cqlSession.execute(
            SimpleStatement.newInstance(
                "UPDATE filmesdb.filme SET titulo = ?, sinopse = ? WHERE filmeuuid = $filmeUuid",
                filme.titulo,
                filme.sinopse
            )
        )
        return filme
    }

}