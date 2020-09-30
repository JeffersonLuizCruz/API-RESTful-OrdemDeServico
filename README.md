projeto-api

Esta aplicação usa o conceito de boas práticas de criação de API Rest. Esta é uma aplicação de 'Chamado de Serviço'. Função da aplicação é criar chamado de serviço, finalizar os chamaos, cancelar chamados, e listar os chamados abertos.

<h3> SQL</h1>

CREATE TABLE `cliente` (</br>
  `id` bigint NOT NULL AUTO_INCREMENT,</br>
  `nome` varchar(60) NOT NULL,</br>
  `email` varchar(255) NOT NULL,</br>
  `telefone` varchar(20) NOT NULL,</br>
  PRIMARY KEY (`id`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `ordem_servico` (</br>
  `id` bigint NOT NULL AUTO_INCREMENT,</br>
  `cliente_id` bigint NOT NULL,</br>
  `descricao` text NOT NULL,</br>
  `preco` decimal(10,2) NOT NULL,</br>
  `status` varchar(20) NOT NULL,</br>
  `data_abertura` datetime NOT NULL,</br>
  `data_finalizacao` datetime DEFAULT NULL,</br>
  PRIMARY KEY (`id`),</br>
  KEY `fk_ordem_servico_cliente` (`cliente_id`),</br>
  CONSTRAINT `fk_ordem_servico_cliente` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`)</br>
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
