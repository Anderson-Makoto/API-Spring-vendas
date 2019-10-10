package com.vendasAPI.vendasAPI;

import java.sql.Date;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vendasAPI.vendasAPI.models.Vendas;
import com.vendasAPI.vendasAPI.models.Vendedor;
import com.vendasAPI.vendasAPI.repository.VendasRepository;
import com.vendasAPI.vendasAPI.repository.VendedorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class vedasTeste {
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private VendasRepository vendaRepository;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void InsercaoVendedor() {
		
		Vendedor vendedor = new Vendedor("Anderson");
		this.vendedorRepository.save(vendedor);
		
		Assertions.assertThat(vendedor.getId()).isEqualTo(1);
		Assertions.assertThat(vendedor.getNome()).isEqualTo("Anderson");		
	}
	
	@Test
	public void InsercaoVendedorNulo() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("Não pode ser nulo");

		Vendedor vendedor = new Vendedor();
		this.vendedorRepository.save(vendedor);
		
	}
	
	@Test
	public void InsercaoVenda() {
		
		Vendedor vendedor = new Vendedor("Anderson");
		this.vendedorRepository.save(vendedor);
		
		Vendas vendas = new Vendas("2018-01-02", 10.00f, vendedor);
		this.vendaRepository.save(vendas);
		
		Assertions.assertThat(vendas.getId()).isEqualTo(1);
		Assertions.assertThat(vendas.getValor()).isEqualTo(10.00f);
		Assertions.assertThat(vendas.getData()).isEqualTo("2018-01-02");
		
	}
	
	@Test
	public void InsercaoVendaNula() {
		thrown.expect(ConstraintViolationException.class);
		thrown.expectMessage("Não pode ser nulo");
		
		Vendedor vendedor = new Vendedor("Anderson");
		this.vendedorRepository.save(vendedor);

		Vendas vendas = new Vendas();
		this.vendaRepository.save(vendas);				
	}
	
	//Este teste não está dando certo pois não está retornando a resposta do "findByDate"
	@Test
	public void retornarVendas() {
		Vendedor vendedor = new Vendedor("Anderson");
		this.vendedorRepository.save(vendedor);
		
		Vendas vendas = new Vendas("2018-01-02", 10.00f, vendedor);
		this.vendaRepository.save(vendas);
		
		List<Object[]> obj = this.vendaRepository.findByDate(Date.valueOf("2017-12-20"), Date.valueOf("2018-01-06"));
		
		Assertions.assertThat(obj.get(0)[0]).isEqualTo("Anderson");
	}
	
	@Test
	public void retornarTodosVendedores() {
		Vendedor vendedor = new Vendedor("Anderson");
		this.vendedorRepository.save(vendedor);
		
		List<Vendedor> outroVendedor = this.vendedorRepository.findAll();
		
		Assertions.assertThat(outroVendedor.get(0).getId()).isEqualTo(1);
	}
	
	@Test
	public void retornarTodasVendas() {
		Vendedor vendedor = new Vendedor("Anderson");
		this.vendedorRepository.save(vendedor);
		
		Vendas vendas = new Vendas("2018-01-02", 10.00f, vendedor);
		this.vendaRepository.save(vendas);
		
		List<Vendas> outraVenda = this.vendaRepository.findAll();
		
		Assertions.assertThat(outraVenda.get(0).getId()).isEqualTo(1);
	}
}
