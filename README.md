projeto-api

Esta aplicação usa o conceito de boas práticas de criação de API Rest. Esta é uma aplicação de 'Chamado de Serviço'. Função da aplicação é criar chamado de serviço, finalizar os chamaos, cancelar chamados, e listar os chamados abertos.

<h3> SQL</h1>

CREATE TABLE `cliente` (
  `id` bigint NOT NULL AUTO_INCREMENT,</br>
  `nome` varchar(60) NOT NULL,
  `email` varchar(255) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `ordem_servico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cliente_id` bigint NOT NULL,
  `descricao` text NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `status` varchar(20) NOT NULL,
  `data_abertura` datetime NOT NULL,
  `data_finalizacao` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ordem_servico_cliente` (`cliente_id`),
  CONSTRAINT `fk_ordem_servico_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
