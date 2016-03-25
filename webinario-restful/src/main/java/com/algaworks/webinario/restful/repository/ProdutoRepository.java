package com.algaworks.webinario.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.webinario.restful.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
