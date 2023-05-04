package com.spring_security_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring_security_project.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {

	public boolean existsByEmail(String email);
	
	 @Query("SELECT c FROM Cliente c ORDER BY c.nomeContatto ASC")
	    List<Cliente> findAllOrderBynameDesc();
}
