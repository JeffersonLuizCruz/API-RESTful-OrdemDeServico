package com.projetoapi.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.projetoapi.domain.exception.NegocioException;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@Entity

public class OrdemServico implements Serializable{
	

	private static final long serialVersionUID = -3527834270566272673L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@Valid
	//@ConvertGroup(from = Default.class, to = ValidationGroups.class)
	@NotNull
	@ManyToOne
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ordemServico")
	private List<Comentario> comentarios = new ArrayList<>();
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private BigDecimal preco;
	
	@Enumerated(EnumType.STRING) 
	//@JsonProperty(access = Access.READ_ONLY) // Torna o status inalterável para o cliente na hora de criar uma OS
	private StatusOrdemServico status;
	
	//@JsonProperty(access = Access.READ_ONLY) // Torna o dataAbertura inalterável para o cliente na hora de criar uma OS
	private OffsetDateTime dataAbertura;
	
	//@JsonProperty(access = Access.READ_ONLY) // Torna o dataFinalizacao inalterável para o cliente na hora de criar uma OS
	private OffsetDateTime dataFinalizacao;
	

	public void finalizar() {
		
		if(!StatusOrdemServico.ABERTA.equals(getStatus())){
			throw new NegocioException("Ordem de Serviço não pode ser finalizada");
			}
		setStatus(StatusOrdemServico.FINALIZADA);
		setDataFinalizacao(OffsetDateTime.now());
		
	}
	
	
	
	

}
