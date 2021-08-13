## Micronaut 2.5.11 Documentation

- [User Guide](https://docs.micronaut.io/2.5.11/guide/index.html)
- [API Reference](https://docs.micronaut.io/2.5.11/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/2.5.11/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Seguir os comandos realizados ##
## Criando container docker com imagem do scylla

- docker run --name apifilmes -p 9042:9042 --hostname apifilmes -d scylladb/scylla

## Entrando no shell cql do container criado (aguardar 90s para realizar comando)

-- docker exec -it apifilmes cqlsh

## Criando keyspace

-- CREATE KEYSPACE filmesdb WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 3};

## Usando keyspace

-- use filmesdb;

## Criando tabela no keyspace 

-- CREATE TABLE filme ( filmeUuid uuid, titulo text, sinopse text, PRIMARY KEY((filmeUuid))); 

