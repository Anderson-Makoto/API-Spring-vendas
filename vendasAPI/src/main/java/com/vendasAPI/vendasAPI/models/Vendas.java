package com.vendasAPI.vendasAPI.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
//Define nome da tabela, caso contrário seria "Vendas"
@Table(name = "TB_VENDAS")
//Serialização é quando uma instancia de um objeto é transformado em uma sequencia de bytes
public class Vendas implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVenda")
	private int id;
	
	@NotNull(message = "Não pode ser nulo")
	@Column(name = "data")
	private Date data;
	
	@NotNull(message = "Não pode ser nulo")
	@Column(name = "valor")
	private float Valor;
	
	@ManyToOne
	@JoinColumn(name = "fkVendedor")
	@JsonBackReference
	private Vendedor fkVendedor;
	
	public Vendas() {}
	
	public Vendas(String data, float Valor, Vendedor kfVendedor) {
		this.data = Date.valueOf(data);
		this.Valor = Valor;
	}

	public Vendedor getFk_idVendedor() {
		return fkVendedor;
	}

	public void setFk_idVendedor(Vendedor fkVendedor) {
		this.fkVendedor = fkVendedor;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	public float getValor() {
		return Valor;
	}
	
	public void setValor(float valor) {
		this.Valor = valor;
	}
}
