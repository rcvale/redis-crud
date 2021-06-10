package br.com.redis.teste.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.redis.teste.model.Produto;
import br.com.redis.teste.model.Status;
import br.com.redis.teste.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Value("${config.redis.timelive}")
	private Long timeToLive;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public List<Produto> findByStatus(Status status) {
		return produtoRepository.findByStatus(status);
	}

	public Produto insert(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void delete(String sku) {
		produtoRepository.deleteById(sku);
	}

	public Produto update(Produto produto) {
		produto.setExpiration(timeToLive);
		return produtoRepository.save(produto);
	}

}
