package com.spring_security_project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.spring_security_project.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>, PagingAndSortingRepository<Cliente, Long> {

	public boolean existsByEmail(String email);
	
	 @Query("SELECT c FROM Cliente c ORDER BY c.nomeContatto ASC")
	    List<Cliente> findAllOrderBynameDesc();
	 
	 @Query("SELECT c FROM Cliente c ORDER BY c.fatturatoAnnuale DESC")
	 List<Cliente> findAllOrderByFatturato();
	 
	 @Query("SELECT c FROM Cliente c ORDER BY c.dataInserimento ASC")
	 List<Cliente> findAllOrderByDataInserimento();
	 
	 @Query("SELECT c FROM Cliente c ORDER BY c.dataUltimoContatto ASC")
	 List<Cliente> findAllOrderByDataUltimoContatto();
	 
	 @Query("SELECT c FROM Cliente c ORDER BY c.sedeLegale.comune.nome_provincia ASC")
	 List<Cliente> findAllOrderByProvincia();
	 
	 @Query("SELECT c FROM Cliente c WHERE c.nomeContatto LIKE %:parte_del_nome%")
	    List<Cliente> findByParteDelNome(String parte_del_nome);
	 
	 @Query("SELECT c FROM Cliente c WHERE c.fatturatoAnnuale >= :fatturato ")
	 List<Cliente> findByFatturatoMaggioreDi(Integer fatturato);
	 
	 @Query("SELECT c FROM Cliente c WHERE c.fatturatoAnnuale <= :fatturato ")
	 List<Cliente> findByFatturatoMinoreDi(Integer fatturato);

	 @Query("SELECT c FROM Cliente c WHERE c.dataInserimento BETWEEN :dataInizio AND :dataFine ")
	 List<Cliente> findByDataInserimento(Date dataInizio, Date dataFine);
	 
	 @Query("SELECT c FROM Cliente c WHERE c.dataUltimoContatto BETWEEN :dataInizio AND :dataFine ")
	 List<Cliente> findByDataUltimoContatto(Date dataInizio, Date dataFine);
	 
}		 
