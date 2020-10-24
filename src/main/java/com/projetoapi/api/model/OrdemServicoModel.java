package com.projetoapi.api.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;

import com.projetoapi.model.StatusOrdemServico;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrdemServicoModel implements Serializable{
	
	private static final long serialVersionUID = 6571192646644664933L;
	
	private Long id;
	private String nomeCliente;
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	private OffsetDateTime dataAbertura;
	private OffsetDateTime dataFinalizacao;

}
