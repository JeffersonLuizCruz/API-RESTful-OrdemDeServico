package com.projetoapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoapi.IRepository.ComentarioRepository;
import com.projetoapi.IRepository.IOrdemServicoRepository;
import com.projetoapi.domain.exception.EntidadeNaoEncontradaException;
import com.projetoapi.domain.service.GestaoOrdemServicoService;
import com.projetoapi.model.Comentario;
import com.projetoapi.model.OrdemServico;

@RestController
@RequestMapping("/ordens-servico/{id}/comentarios")
public class ComentarioController {
	
	@Autowired
	GestaoOrdemServicoService gestaoOrdemService;
	
	@Autowired
	ComentarioRepository comentarioRepository;
	
	@Autowired
	IOrdemServicoRepository ordemServicoRepository;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Comentario adicionar(@PathVariable @Valid @RequestBody Comentario id, String descricao) {
		Comentario result = gestaoOrdemService.adicionarComentario(id, descricao);
		return comentarioRepository.save(result);
	}
	
	@GetMapping
	public List<Comentario> lista(@PathVariable Long id){
		OrdemServico ordemServico = ordemServicoRepository.findById(id)
		.orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de Servico não encontrada"));
		
		return ordemServico.getComentarios();
	}

}
