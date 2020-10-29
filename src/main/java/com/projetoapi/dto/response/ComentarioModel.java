package com.projetoapi.dto.response;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComentarioModel {
	
	private Long id;
	private String descricao;
	private OffsetDateTime dataEnvio;

}
