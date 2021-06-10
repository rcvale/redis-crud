package br.com.redis.teste.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.redis.teste.model.Produto;
import br.com.redis.teste.model.Status;

public interface ProdutoRepository extends CrudRepository<Produto, String> {

	List<Produto> findAll();

	List<Produto> findByStatus(Status status);

}
