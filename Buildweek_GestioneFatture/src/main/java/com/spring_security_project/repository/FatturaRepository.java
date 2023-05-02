package com.spring_security_project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring_security_project.model.Fattura;

public interface FatturaRepository extends JpaRepository<Fattura, Long> {

}
