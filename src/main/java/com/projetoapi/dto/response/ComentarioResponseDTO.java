package com.projetoapi.dto.response;

import java.time.OffsetDateTime;

import com.projetoapi.model.Comentario;

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
public class ComentarioResponseDTO {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;
	
	public ComentarioResponseDTO(Comentario comentario) {
		
		this.id = comentario.getId();
		this.descricao = comentario.getDescricaoTecnica();
		this.dataEnvio = comentario.getDataEnvio();
	}

}
