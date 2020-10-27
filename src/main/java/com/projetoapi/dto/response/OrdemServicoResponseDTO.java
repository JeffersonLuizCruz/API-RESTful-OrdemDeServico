package com.projetoapi.dto.response;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.projetoapi.model.Cliente;
import com.projetoapi.model.Comentario;
import com.projetoapi.model.OrdemServico;
import com.projetoapi.model.StatusOrdemServico;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
public class OrdemServicoResponseDTO {
	
	private Long id;
	private Cliente cliente;
	private List<Comentario> comentarios = new ArrayList<>();
	private String descricao;
	private BigDecimal preco;
	private StatusOrdemServico status;
	
	public OrdemServicoResponseDTO(OrdemServico ordemServico) {
		
		this.id = ordemServico.getId();
		this.cliente = ordemServico.getCliente();
		this.comentarios = ordemServico.getComentarios();
		this.descricao = ordemServico.getDescricao();
		this.preco = ordemServico.getPreco();
		this.status = ordemServico.getStatus();
	}

}
