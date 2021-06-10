package br.com.redis.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.redis.teste.model.Produto;
import br.com.redis.teste.model.Status;
import br.com.redis.teste.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = produtoService.findAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/produtos/status", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Produto>> findByStatus(@RequestParam("status") Status status) {
		List<Produto> list = produtoService.findByStatus(status);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
		Produto response = produtoService.insert(produto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PutMapping(value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> update(@RequestBody Produto produto) {
		Produto response = produtoService.update(produto);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/produtos/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> delete(@PathVariable("sku") String sku) {
		produtoService.delete(sku);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
