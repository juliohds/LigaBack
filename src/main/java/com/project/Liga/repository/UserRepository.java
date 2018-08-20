package com.project.Liga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.Liga.models.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	public User findByEmailAndSenha (String pEmail, String pSenha);
	
	public User findByEmail(String pEmail);
        
    /**
     * Usando JPql
     * @param pEmail
     * @return lista de usuarios com primeiro email igual ao informado
     */
    @Query(value= "SELECT * FROM User c WHERE c.email like ?1%", nativeQuery = true)
    public List<User> findAllByEmail(String pEmail);

    /**
     * Usando SQL nativo
     * @param pUltimoNome
     * @return lista de clientes com último nome igual ao informado
     */
    @Query(value = "SELECT * FROM USER c WHERE c.SENHA like %?1", nativeQuery = true)
    public List<User> findAllBySenha(String pSenha);
}
