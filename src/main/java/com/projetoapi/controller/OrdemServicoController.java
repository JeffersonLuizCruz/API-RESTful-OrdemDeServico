package com.projetoapi.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoapi.IRepository.IOrdemServicoRepository;
import com.projetoapi.domain.service.GestaoOrdemServicoService;
import com.projetoapi.dto.OrdemServicoDTO;
import com.projetoapi.model.OrdemServico;

@RestController
@RequestMapping("/ordens-servico")
public class OrdemServicoController {
	
	@Autowired
	private GestaoOrdemServicoService gestaoOrdemServico;
	
	@Autowired
	private IOrdemServicoRepository ordemServicoRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrdemServicoDTO criar(@Valid @RequestBody OrdemServico ordemServico){
	return toDTO(gestaoOrdemServico.criar(ordemServico));
	}
	
	@GetMapping
	public List<OrdemServicoDTO> listar(){
		return toCollectionDTO(ordemServicoRepository.findAll());
	}
	
	@PutMapping("/{ordemServicoId}/finalizada")
	@ResponseStatus(code = HttpStatus.NO_CONTENT) //Foi sucesso mas não tem resposta no corpo
	public void finalizacao(@PathVariable Long ordemServicoId){
	    gestaoOrdemServico.finalizar(ordemServicoId);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrdemServicoDTO> buscar(@PathVariable Long id){
		Optional<OrdemServico> ordemServico = ordemServicoRepository.findById(id);
		
		if(ordemServico.isPresent()){
			OrdemServicoDTO modelDTO = toDTO(ordemServico.get());
			return ResponseEntity.ok(modelDTO);
			}
		return ResponseEntity.notFound().build();
		}
	
	private OrdemServicoDTO toDTO(OrdemServico ordemServico) {
		return modelMapper.map(ordemServico, OrdemServicoDTO.class);
	}
	private List<OrdemServicoDTO> toCollectionDTO(List<OrdemServico> ordensServicos){
		return ordensServicos.stream()
				.map(ordemServico -> toDTO(ordemServico))
				.collect(Collectors.toList());
		
	}

}
