package com.generation.lojagames.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojagames.model.Produtos;
import com.generation.lojagames.repository.CategoriasRepository;
import com.generation.lojagames.repository.ProdutosRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {
	
	@Autowired
	private ProdutosRepository produtosRepository;
	@Autowired
	private CategoriasRepository categoriasRepository;

	@GetMapping
	public ResponseEntity<List<Produtos>> getAll() {
		/* LISTAR TODOS OS REGISTROS DA TABELA CATEGORIAS */
		return ResponseEntity.ok(produtosRepository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Produtos> getById(@PathVariable Long id) {
		return produtosRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Produtos>> getByNome(@PathVariable String nome) {
		return ResponseEntity.ok(produtosRepository.findAllByNomeContainingIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Produtos> postProdutos(@Valid @RequestBody Produtos produtos) {
		if(categoriasRepository.existsById(produtos.getCategorias().getId()))
			return ResponseEntity.status(HttpStatus.CREATED).body(produtosRepository.save(produtos));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping
	public ResponseEntity<@Valid Produtos> putProdutos(@Valid @RequestBody Produtos produtos) {
		if(produtosRepository.existsById(produtos.getId())) {
			if(produtosRepository.existsById(produtos.getCategorias().getId()))
				return ResponseEntity.status(HttpStatus.OK).body(produtosRepository.save(produtos));
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProdutos(@PathVariable Long id) {
		return produtosRepository.findById(id).map(resposta -> {
			produtosRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());

	}

}
