package com.projetoapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@EqualsAndHashCode // O certo serial criar o Equal And HasCode só para 'private Long id;'
public class OrdemServico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

	@ManyToOne
	private Cliente cliente;
	
	private String descricao;
	
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING) //EnumType.ORDINAL - enumera números; EnumType.STRING - enumera string
	@JsonProperty(access = Access.READ_ONLY)
	private StatusOrdemServico status;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataAbertura;
	
	@JsonProperty(access = Access.READ_ONLY)
	private OffsetDateTime dataFinalizacao;

}
