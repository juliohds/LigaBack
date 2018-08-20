package com.project.Liga.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Liga.models.Socio;
import com.project.Liga.repository.SocioRepository;

@RestController
@RequestMapping("/socio")
public class SocioResource {
	
	@Autowired
	private SocioRepository sr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Socio> listarSocio() {
		Iterable<Socio> listarSocio = sr.findAll();
		return listarSocio;
	}
	
	@PostMapping()
	public Socio cadastraSocio(@RequestBody @Valid Socio socio) {
		return sr.save(socio);
	}
	
	@DeleteMapping()
	public Socio deletaSocio(@RequestBody Socio socio) {
		sr.delete(socio);
		return socio;				
	}
}
