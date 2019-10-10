package com.vendasAPI.vendasAPI.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vendasAPI.vendasAPI.models.Vendas;

//JpaRepository auxilia com as operações de CRUD no banco de dados
public interface VendasRepository extends JpaRepository<Vendas, Integer> {
	
	@Query(value = "select cast(NOME as varchar), cast(count(VALOR) as int), cast(count(VALOR) as decimal(6,2))/cast(datediff(day, ?1, ?2) as decimal(6,2)) "
			+ "from TB_VENDAS, TB_VENDEDOR where FK_VENDEDOR = TB_VENDEDOR.ID_VENDEDOR and DATA between ?1 and ?2 "
			+ "group by FK_VENDEDOR", nativeQuery = true)
	List<Object[]> findByDate(Date dt1, Date dt2);
}
