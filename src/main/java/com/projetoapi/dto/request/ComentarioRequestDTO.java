package com.projetoapi.dto.request;



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
public class ComentarioRequestDTO {
	
	private String descricaoTecnica;
	
	public Comentario build() {
		Comentario comentario = new Comentario()
				.setDescricaoTecnica(this.descricaoTecnica);
		return comentario;
	}

}
