package com.vendasAPI.vendasAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vendasAPI.vendasAPI.models.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Integer> {
	
	/*@Modifying
	@Query(value = "insert into TB_VENDEDOR (NOME) values('?1')", nativeQuery = true)
	List<Vendedor> addValue(String name);*/
}
