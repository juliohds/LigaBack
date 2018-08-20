package com.project.Liga.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="startup")
public class Startup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String ramo;
		
	private boolean temEmpresa;
	
	@OneToMany
	private List<Socio> socio;
	
	@OneToOne
	private Endereco endereco;
	
	@OneToOne
	private Mentor mentor;
	
	@NotBlank
	private String telefone;
	
	@NotBlank
	private String email;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRamo() {
		return ramo;
	}
	public void setRamo(String ramo) {
		this.ramo = ramo;
	}
	public boolean isTemEmpresa() {
		return temEmpresa;
	}
	public void setTemEmpresa(boolean temEmpresa) {
		this.temEmpresa = temEmpresa;
	}
	public List<Socio> getSocio() {
		return socio;
	}
	public void setSocio(List<Socio> socio) {
		this.socio = socio;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Mentor getMentor() {
		return mentor;
	}
	public void setMentor(Mentor mentor) {
		this.mentor = mentor;
	}
	
	
	
}
