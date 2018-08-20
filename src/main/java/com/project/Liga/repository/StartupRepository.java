package com.project.Liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Liga.models.Startup;

public interface StartupRepository extends JpaRepository<Startup, String> {
	
    @Query(value= "SELECT * FROM startup c WHERE c.id = ?", nativeQuery = true)
    public Startup findById(int id);
}
