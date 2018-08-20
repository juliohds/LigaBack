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

import com.project.Liga.models.GrandeEmpresa;
import com.project.Liga.repository.GrandeEmpresaRepository;

@RestController
@RequestMapping("/grande-empresa")
public class GrandeEmpresaResource {
	
	@Autowired
	private GrandeEmpresaRepository gr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<GrandeEmpresa> listarGrandeEmpresa() {
		Iterable<GrandeEmpresa> listarGrandeEmpresa = gr.findAll();
		return listarGrandeEmpresa;
	}
	
	@PostMapping()
	public @Valid GrandeEmpresa cadastraGrandeEmpresa(@RequestBody @Valid GrandeEmpresa grandeEmpresa) {
		return gr.save(grandeEmpresa);
	}
	
	@DeleteMapping()
	public GrandeEmpresa deletaGrandeEmpresa(@RequestBody GrandeEmpresa grandeEmpresa) {
		gr.delete(grandeEmpresa);
		return grandeEmpresa;				
	}
	
	
}
