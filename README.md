# Boas práticas de RESTful

Esta aplicação usa o conceito de boas práticas de criação de API REST. Esta é uma aplicação de 'Chamado de Serviço'. A função da aplicação é criar chamado de serviço, finalizar os chamaos, cancelar chamados, e listar os chamados abertos.

### Rota[POST]
- [POST] _localhost:8080/ordens-servico

#### Body:
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
#### Rota [POST] - Inserir um comentário na ordem de serviço
- [POST] _localhost:8080/ordens-servico/{id}/comentarios

#### Body:
```
{
    "descricao": "Placa não foi reparada"
}
```
#### Rota [PUT] - Alterar o status da ordem de servico para cancelado
- [PUT] _localhost:8080/ordens-servico/{id}/finalizada

#### Body:
```
{
    "descricao": "Placa não foi reparada"
}
```
#### Rota[GET] - Listar todos clientes
- [GET] _localhost:8080/clientes

#### Resposta:
```
    {
        "id": 1,
        "nome": "João",
        "email": "joao@gmail.com",
        "telefone": "34 7394-4499"
    }
```

#### Rota[GET] - Listar cliente por id
- [GET] _localhost:8080/clientes/{id}

#### Resposta:
```
    {
        "id": 1,
        "nome": "João",
        "email": "joao@gmail.com",
        "telefone": "34 7394-4499"
    }
 ```

#### Rota[GET] - Listar ordem de serviço por id
- [GET] _localhost:8080/ordens-servico/{id}

#### Resposta:
```
{
    "descricao": "Reparo de noteboot dell. Cliente diz que não liga",
    "preco": 300.50,
    "status": "FINALIZADA",
    "dataAbertura": "2020-10-27T00:03:00.517491-03:00",
    "dataFinalizacao": "2020-10-27T02:28:02.898187-03:00"
}
```

#### Rota[GET] - Listar todas ordem de serviço
- [GET] _localhost:8080/ordens-servico/

#### Resposta:
```
{
    "descricao": "Reparo de noteboot dell. Cliente diz que não liga",
    "preco": 300.50,
    "status": "FINALIZADA",
    "dataAbertura": "2020-10-27T00:03:00.517491-03:00",
    "dataFinalizacao": "2020-10-27T02:28:02.898187-03:00"
}
```


## Requisitos:
- [x] Java 11<br>
- [x] DTO<br>
- [x] Java Swagger2 Swagger-ui<br>
- [x] Exception personalizada
