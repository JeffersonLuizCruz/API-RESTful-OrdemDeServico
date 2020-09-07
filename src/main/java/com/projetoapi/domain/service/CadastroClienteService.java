package com.projetoapi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoapi.IRepository.IClienteRepository;
import com.projetoapi.domain.exception.NegocioException;
import com.projetoapi.model.Cliente;

@Service
public class CadastroClienteService {
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		Cliente clienteExistente = clienteRepository.findByEmail(cliente.getEmail());
		
		if(clienteExistente != null && !clienteExistente.equals(cliente)){
			throw new NegocioException("Já existe um cliente cadastrado com este E-mail.");
			}
		
		return clienteRepository.save(cliente);
	}
	
	public void excluir(Long clienteid) {
		clienteRepository.deleteById(clienteid);
	}

}
