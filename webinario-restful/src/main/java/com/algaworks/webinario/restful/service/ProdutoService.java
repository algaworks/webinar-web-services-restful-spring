package com.algaworks.webinario.restful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.webinario.restful.domain.Produto;
import com.algaworks.webinario.restful.repository.ProdutoRepository;
import com.algaworks.webinario.restful.service.exception.ProdutoExistenteException;
import com.algaworks.webinario.restful.service.exception.ProdutoNaoEncontradoException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> listar() {
		return repository.findAll();
	}
	
	public Produto buscar(Long id) {
		Produto produto = repository.findOne(id);
		
		if(produto == null) {
			throw new ProdutoNaoEncontradoException("Produto não encontrado.");
		}
		
		return produto;
	}
	
	public Produto salvar(Produto produto) {
		verificarExistencia(produto);
		produto.setId(null);
		return repository.save(produto);
	}
	
	private void verificarExistencia(Produto produto) {
		if(produto.getId() != null && repository.findOne(produto.getId()) != null) {
			throw new ProdutoExistenteException("Produto já cadastrado.");
		}
	}

}