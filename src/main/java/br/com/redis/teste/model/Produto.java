package br.com.redis.teste.model;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("produto")
public class Produto implements Serializable {

	@Id
	private String sku;

	@Indexed
	private String nome;

	@Indexed
	private Status status;

	@TimeToLive(unit = TimeUnit.SECONDS)
	private Long expiration;

}
