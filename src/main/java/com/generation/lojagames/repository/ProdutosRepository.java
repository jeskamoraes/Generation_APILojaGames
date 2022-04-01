package com.generation.lojagames.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.lojagames.model.Produtos;

@Repository
public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

	public List<Produtos> findAllByNomeContainingIgnoreCase(String nome);

	/*
	 * BUSCAR OS PRODUTOS QUE TEM O VALOR MAIOR QUE O DIGITADO E APRESENTÁ-LOS
	 * ORDENADOS EM ORDEM CRESECENTE. CORRESPONDE AO SELECT * FROM tb_produtos WHERE
	 * PRECO > PRECO ORDER BY PRECO
	 */
	public List<Produtos> findByPrecoGreaterThanOrderByPreco(BigDecimal preco);

	/*
	 * BUSCAR OS PRODUTOS QUE TEM O VALOR MENOR QUE O DIGITADO E APRESENTÁ-LOS
	 * ORDENADOS EM ORDEM DECRESECENTE. CORRESPONDE AO SELECT * FROM tb_produtos
	 * WHERE PRECO < PRECO ORDER BY PRECO DESC
	 */
	public List<Produtos> findByPrecoLessThanOrderByPrecoDesc(BigDecimal preco);
}
