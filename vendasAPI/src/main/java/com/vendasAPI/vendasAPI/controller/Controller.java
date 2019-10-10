package com.vendasAPI.vendasAPI.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendasAPI.vendasAPI.repository.VendasRepository;
import com.vendasAPI.vendasAPI.models.*;

@RestController
@RequestMapping(value = "/venda")
public class Controller {
	int data = 6;
	@Autowired
	VendasRepository vendasRepository;
	
	@PostMapping("/POSTvenda") 
	public Vendas addVendedor(@RequestBody Vendas vendas){
		return vendasRepository.save(vendas);
	}
	
	@GetMapping("/GETvenda/{data}/{data2}")
	public List<Object[]> get(@PathVariable(value = "data")Date data,@PathVariable(value = "data2")Date data2){
		List<Object[]> obj = vendasRepository.findByDate(data, data2);
		
		return obj;
	}
	
	@GetMapping("/GETall")
	public List<Vendas> getAll(){
		return vendasRepository.findAll();
	}

	
}
 