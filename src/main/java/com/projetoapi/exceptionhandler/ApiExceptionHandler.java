package com.projetoapi.exceptionhandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projetoapi.domain.exception.EntidadeNaoEncontradaException;
import com.projetoapi.domain.exception.NegocioException;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	/*
	 * ResponseEntityExceptionHandler
	 * Classe que trata exceções das saídas JSON
	 * */
	@Autowired
	private MessageSource messageSource; 
	//interface para personalizar mensagem no arquivo /src/main/resources/messages.properties
	//private Object bindingResult;
	
	
	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<Object> handleEntidadeNaoEncontrada(NegocioException ex, WebRequest request){
		/*
		 *
		 * * */
		var status = HttpStatus.NOT_FOUND;

		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo(ex.getMessage());
		problema.setDataHora(OffsetDateTime.now());

		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
		}
	
	
	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<Object> handleNegocio(NegocioException ex, WebRequest request){
		/*Caso uma determinada exceção for lançada caia neste método que tem tratamento
		 *para ela. Neste caso a exceção é NegocioException
		 * * */
		var status = HttpStatus.BAD_REQUEST;

		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setTitulo(ex.getMessage());
		problema.setDataHora(OffsetDateTime.now());

		return handleExceptionInternal(ex, problema, new HttpHeaders(), status, request);
		}
	
	
	/*handleMethodArgumentNotValid() - esse método torna possível redenrizar a resposta de erro do HTTP */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request) {
		
		//original-ArrayList<Campo> campoList = new ArrayList<Campo>();
		var campos = new ArrayList<Problema.Campo>();
		
		//List<FieldError> errors = (List<FieldError>) ((Object) bindingResult);
		for(ObjectError error : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) error).getField();
			String mensagem = messageSource.getMessage(error, LocaleContextHolder.getLocale());
			
			campos.add(new Problema.Campo(nome, mensagem));
		}
		
		var problema = new Problema();
		problema.setStatus(status.value());
		problema.setDataHora(OffsetDateTime.now());
		problema.setTitulo("Campo inválido. Preencha novamente.");
		problema.setCampos(campos);
		//--problema.setCampos(campoList);
		
		//Retorno abaixo faz parte do método original do handleMethodArgumentNotValid()
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
		
		return super.handleExceptionInternal(ex, problema, headers, status, request);
		
	}
}
