package com.generation.lojagames.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_produtos")
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O campo nome não pode ficar em branco")
	@Size(min = 10, max = 255, message = "O campo deve conter entre 10 e 255 caracteres")
	private String nome;
	
	@NotBlank(message = "O campo descrição não pode ficar em branco")
	@Size(min = 10, max = 255, message = "O campo deve conter entre 10 e 255 caracteres")
	private String descricao;
	
	@NotBlank(message = "O campo console não pode ficar em branco")
	@Size(min = 3, max = 255, message = "O campo deve conter entre 3 e 255 caracteres")
	private String console;
	
	@NotNull(message = "O campo quantidade não pode ficar em branco")
	@Positive(message = "A quantidade deve ser maior que 0")
	private int quantidade;
	
	@NotNull(message = "O campo preço não pode ficar em branco")
	@Positive(message = "O preço deve ser maior que 0")
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	private BigDecimal preco;
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;
	
	public Categorias getCategorias() {
		return categorias;
	}
	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
}
