package com.spring_security_project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring_security_project.model.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Long>{
	public List<Provincia> findBySigla(String nome);

}
