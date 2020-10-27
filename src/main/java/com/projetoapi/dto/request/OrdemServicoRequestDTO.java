package com.projetoapi.dto.request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import com.projetoapi.model.Cliente;
import com.projetoapi.model.Comentario;
import com.projetoapi.model.OrdemServico;

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
public class OrdemServicoRequestDTO {
	
	private Cliente cliente;
	private List<Comentario> comentarios = new ArrayList<>();
	private String descricao;
	private BigDecimal preco;
	private OffsetDateTime dataAbertura;
	
	public OrdemServico build() {
		OrdemServico ordemServico = new OrdemServico()
				.setCliente(this.cliente)
				.setComentarios(this.comentarios)
				.setDescricao(this.descricao)
				.setPreco(this.preco)
				.setDataAbertura(this.dataAbertura);
		return ordemServico;
	}

}
