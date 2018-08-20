package com.project.Liga.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Liga.models.Mentor;
import com.project.Liga.models.Startup;

public interface MentorRepository extends JpaRepository<Mentor, String>{
	
	@Query(value= "SELECT * FROM mentor c WHERE c.id = ?", nativeQuery = true)
    public Mentor findById(int id);
}
