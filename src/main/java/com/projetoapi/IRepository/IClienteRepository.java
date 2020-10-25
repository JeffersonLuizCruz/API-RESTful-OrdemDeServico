package com.projetoapi.IRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoapi.model.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long>{
	List<Cliente> findByNomeContaining(String nome); //Containing - faz busca por conjuntos de letras
	Cliente findByEmail(String email);
}
