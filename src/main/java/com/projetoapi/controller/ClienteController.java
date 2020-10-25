package com.projetoapi.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetoapi.IRepository.IClienteRepository;
import com.projetoapi.domain.service.CadastroClienteService;
import com.projetoapi.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	CadastroClienteService cadastroClienteService;
	
	@Autowired
	IClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> listar(){
		List<Cliente> listarClientes = clienteRepository.findAll();
		return listarClientes;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscar(@PathVariable Long id){
		Optional<Cliente> buscarCliente = clienteRepository.findById(id);
		
		if(buscarCliente.isPresent()) {
			return ResponseEntity.ok(buscarCliente.get());
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/adiciona")
	@ResponseStatus(code = HttpStatus.CREATED) //Resposta de 201 criado com sucesso - uma boa prática
	public Cliente salvar(@Valid @RequestBody Cliente clienteAdd){
		Cliente salvarCliente = cadastroClienteService.salvar(clienteAdd);
		return salvarCliente;
	}
	@PutMapping("id}")	
	public ResponseEntity<Cliente> editar(@Valid @PathVariable Long id,
										  @RequestBody Cliente clienteEditar){
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		clienteEditar.setId(id);
		clienteEditar = cadastroClienteService.salvar(clienteEditar);
		return ResponseEntity.ok(clienteEditar);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> remover(@PathVariable Long id){
		
		if(!clienteRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}else {
			clienteRepository.deleteById(id);
			return ResponseEntity.noContent().build();
			}
		
	}
}
