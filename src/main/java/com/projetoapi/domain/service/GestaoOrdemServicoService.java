package com.projetoapi.domain.service;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoapi.IRepository.ComentarioRepository;
import com.projetoapi.IRepository.IClienteRepository;
import com.projetoapi.IRepository.IOrdemServicoRepository;
import com.projetoapi.domain.exception.EntidadeNaoEncontradaException;
import com.projetoapi.domain.exception.NegocioException;
import com.projetoapi.model.Cliente;
import com.projetoapi.model.Comentario;
import com.projetoapi.model.OrdemServico;
import com.projetoapi.model.StatusOrdemServico;

@Service
public class GestaoOrdemServicoService {
	
	@Autowired
	private IOrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private IClienteRepository clienteRepository;
	
	@Autowired
	private ComentarioRepository comentarioRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
				.orElseThrow(() -> new NegocioException("Cliente não encontrado"));
		//.orElseThrow é uma exceção para Optional quando estiver null.
		
		ordemServico.setCliente(cliente);
		ordemServico.setStatus(StatusOrdemServico.ABERTA);
		ordemServico.setDataAbertura(OffsetDateTime.now());
		
		return ordemServicoRepository.save(ordemServico);
	}
	
	public Comentario adicionarComentario(Long id, String descricao) {
		OrdemServico ordemServico = ordemServicoRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de Serviço não encontrada"));
		
		Comentario comentario = new Comentario();
		
		comentario.setDataEnvio(OffsetDateTime.now());
		comentario.setDescricaoTecnica(descricao);
		comentario.setOrdemServico(ordemServico);
		
		return comentarioRepository.save(comentario);
	}
	
	public void finalizar(Long ordemServicoId){
	    OrdemServico ordemServico = buscar(ordemServicoId);
	    
	    ordemServico.finalizar();
	    ordemServicoRepository.save(ordemServico);
	}
	
	private OrdemServico buscar(Long ordemServicoId){
	    return ordemServicoRepository.findById(ordemServicoId)
	    .orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não encontrada"));
	}
	

}
