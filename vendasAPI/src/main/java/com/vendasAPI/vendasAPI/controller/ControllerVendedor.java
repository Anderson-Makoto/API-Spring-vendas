package com.vendasAPI.vendasAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vendasAPI.vendasAPI.models.Vendedor;
import com.vendasAPI.vendasAPI.repository.VendedorRepository;

@RestController
@RequestMapping(value = "/vendedor")
public class ControllerVendedor {
	
	@Autowired
	VendedorRepository vendedorRepository;
	
	@PostMapping("/POSTvendedor") 
	public Vendedor addVendedor(@RequestBody Vendedor vendedor){
		return vendedorRepository.save(vendedor);
	}
	
	@GetMapping("/GETvendedor")
	public List<Vendedor> getAll(){
		return vendedorRepository.findAll();
	}
}
