package com.project.Liga.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Liga.models.Socio;
import com.project.Liga.models.Startup;
import com.project.Liga.repository.SocioRepository;
import com.project.Liga.repository.StartupRepository;

@RestController
@RequestMapping("/startup")
public class StartupResource {
	
	@Autowired
	private StartupRepository sr;
	@Autowired 
	private SocioRepository sor;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Startup> listaStartup() {
		Iterable<Startup> listaStartup = sr.findAll();
		return listaStartup;
	}
	
	@RequestMapping(value="/{id}/socio", method=RequestMethod.POST)
	public Socio cadastraSocioStartup(@RequestBody Socio socio,@PathVariable int id) {
		return socio;
	}
	
	@RequestMapping(value="/{id}/socio", method=RequestMethod.GET, produces="application/json")
	public Iterable<Socio> carregaSocioStartup(@PathVariable int id) {
		Iterable<Socio> is = sor.findWhereId(id);
		return is;
	}
		
	@PostMapping()
	public Startup cadastraStartup(@RequestBody @Valid Startup startup) {
		
		if(startup.getSocio() != null) {
			
			List<Socio> ls = startup.getSocio();
		
		if(!ls.isEmpty()) {
			for (Socio c : ls) {
				sor.save(c);
			}
		}
		}
		return sr.save(startup);
	}
	
	@DeleteMapping()
	public Startup deletaStartup(@RequestBody Startup startup) {
		sr.delete(startup);
		return startup;				
	}
}
