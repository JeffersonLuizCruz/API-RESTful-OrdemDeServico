package com.projetoapi.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
public class Cliente implements Serializable{
	

	private static final long serialVersionUID = 4692580249936313415L;

	//@NotNull(groups = ValidationGroups.ClienteId.class)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		
	@NotBlank //NotBlack - o valor não é null, não é vazio e não contem espaços.
	@Size(max = 50) // Tamanho máximo de uma coluna da base de dados
	private String nome;
	
	@NotBlank
	@Email //valida email
	@Size(max = 50)
	private String email;
	
	@NotBlank
	@Size(max = 20)
	private String telefone;
	

}
