package com.projetoapi.dto.request;


import com.projetoapi.model.Cliente;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class ClienteRequestDTO {

	private String nome;
	private String email;
	private String telefone;
	
	public Cliente build() {
		Cliente cliente = new Cliente()
				.setNome(this.nome)
				.setEmail(this.email)
				.setTelefone(this.telefone);
		
		return cliente;		
	}
	
}
