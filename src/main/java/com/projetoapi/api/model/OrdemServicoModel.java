package com.projetoapi.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.projetoapi.model.StatusOrdemServico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrdemServicoModel {
	
	private Long id;
	private String nomeCliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;

}
