package com.project.Liga.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Liga.models.Endereco;
import com.project.Liga.models.GrandeEmpresa;
import com.project.Liga.models.Socio;
import com.project.Liga.repository.EnderecoRepository;
import com.project.Liga.repository.GrandeEmpresaRepository;
import com.project.Liga.repository.SocioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/grande-empresa")
public class GrandeEmpresaResource {
	
	@Autowired
	private GrandeEmpresaRepository gr;
	@Autowired 
	private SocioRepository sor;
	@Autowired 
	private EnderecoRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<GrandeEmpresa> listarGrandeEmpresa() {
		Iterable<GrandeEmpresa> listarGrandeEmpresa = gr.findAll();
		return listarGrandeEmpresa;
	}
	
	@PostMapping()
	public @Valid GrandeEmpresa cadastraGrandeEmpresa(@RequestBody @Valid GrandeEmpresa grandeEmpresa) {
		
		if(grandeEmpresa.getEndereco() != null) {
			Endereco end = grandeEmpresa.getEndereco();
			er.save(end);
		}

		if(grandeEmpresa.getSocio() != null) {
			
			List<Socio> ls = grandeEmpresa.getSocio();
		
		if(!ls.isEmpty()) {
			for (Socio c : ls) {
				sor.save(c);
			}
		}
		}
		
		return gr.save(grandeEmpresa);
	}
	
	@DeleteMapping()
	public GrandeEmpresa deletaGrandeEmpresa(@RequestBody GrandeEmpresa grandeEmpresa) {
		gr.delete(grandeEmpresa);
		return grandeEmpresa;				
	}
	
	
}
