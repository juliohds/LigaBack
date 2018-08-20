package com.project.Liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Liga.models.Socio;

public interface SocioRepository extends JpaRepository<Socio, String> {
	
	@Query(value= "SELECT * FROM socio c WHERE c.id_startup = ?", nativeQuery = true)
	public Iterable<Socio> findWhereId(int pId);
}
