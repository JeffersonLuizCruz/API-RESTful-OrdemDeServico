package com.projetoapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoapi.IRepository.IClienteRepository;
import com.projetoapi.IRepository.IOrdemServicoRepository;
import com.projetoapi.domain.exception.NegocioException;
import com.projetoapi.model.Cliente;
import com.projetoapi.model.OrdemServico;
import com.projetoapi.model.StatusOrdemServico;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private IOrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		//.orElseThrow é uma exceção para Optional quando estiver null.
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	

}
