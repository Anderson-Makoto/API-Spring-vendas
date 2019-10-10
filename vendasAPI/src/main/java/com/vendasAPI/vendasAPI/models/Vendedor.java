package com.vendasAPI.vendasAPI.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "TB_VENDEDOR")
public class Vendedor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVendedor")
	private int id;
	
	@NotEmpty(message = "Não pode ser nulo")
	@Column(name = "nome")
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "fkVendedor")
	private Set<Vendas> vendas =new HashSet<Vendas>();
	
	public Vendedor() {}
	
	public Vendedor(String nome){
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
