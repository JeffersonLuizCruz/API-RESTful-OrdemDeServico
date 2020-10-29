# Boas práticas de RESTful

Esta aplicação usa o conceito de boas práticas de criação de API REST. Esta é uma aplicação de 'Chamado de Serviço'. A função da aplicação é criar chamado de serviço, finalizar os chamaos, cancelar chamados, e listar os chamados abertos.

## Rota[POST]
- [POST] _localhost:8080/ordens-servico

### Body:
```
{
	"cliente": {
		"id":1
	},
	"descricao": "Reparo de noteboot dell. Cliente diz que não liga",
	"preco": 300.50,
    "dataFinalizacao":"1970-04-01T00:29:37Z"
}
```
## Rota [POST] - Inserir um comentário na ordem de serviço
- [POST] _localhost:8080/ordens-servico/{id}/comentarios

### Body:
```
{
    "descricao": "Placa não foi reparada"
}
```
## Rota [PUT] - Alterar o status da ordem de servico para cancelado
- [PUT] _localhost:8080/ordens-servico/{id}/finalizada

### Body:
```
{
    "descricao": "Placa não foi reparada"
}
```
## Rota[GET] - Listar todos clientes
- [GET] _localhost:8080/clientes

## Rota[GET] - Listar cliente por id
- [GET] _localhost:8080/clientes/{id}

## Rota[GET] - Listar ordem de serviço por id
- [GET] _localhost:8080/ordens-servico/{id}

## Rota[GET] - Listar todas ordem de serviço
- [GET] _localhost:8080/ordens-servico/


## Requisitos:
- [x] Java 11<br>
- [x] DTO<br>
- [x] Java Swagger2 Swagger-ui<br>
- [x] Exception personalizada
