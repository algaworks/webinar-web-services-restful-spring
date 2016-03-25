package com.algaworks.webinario.restful.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.webinario.restful.domain.Produto;
import com.algaworks.webinario.restful.service.ProdutoService;
import com.algaworks.webinario.restful.service.exception.ProdutoExistenteException;
import com.algaworks.webinario.restful.service.exception.ProdutoNaoEncontradoException;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Produto> listar() {
		return service.listar();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> salvarProduto(@RequestBody Produto produto) {
		try {
			produto = service.salvar(produto);
			String uri = "http://localhost:8080/produtos/" + produto.getId();
			return ResponseEntity.created(URI.create(uri)).build();
		} catch (ProdutoExistenteException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> buscarProduto(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(service.buscar(id));
		} catch (ProdutoNaoEncontradoException e) {
			return ResponseEntity.notFound().build();
		}
	}

}
