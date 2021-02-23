package org.generation.farmacia.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity                                             				// ESSA CLASSE VAI SEE UMA ENTIDADE DO JPA
@Table(name = "tb_categoria")										// ESSA CLASSE VAI SER UMA TABELA COM NOME "tb_categoria"
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 			//GERA O VALOR E TRANFORMA ID EM CHAVE PRIMARIA
	private long id;
	
	@NotNull                                       					// INDICA QUE O VALOR NÃO PODE SER NULO
	@Size(min = 5, max = 100)										// INDICA A QUANTIDADE MINIMA E MAXIMA DE CARACTER
	private String tipo;
	
	@Size(min = 10, max = 500)
	private String observacao;
	
	@OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)	//NOTAÇÃO DE RELAÇÃO (UM PARA MUITOS)
	@JsonIgnoreProperties("categoria")								//QUANDO CHEGAR EM CATEGORIA ELE PARA
	private List<Produto> produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}
	
}
