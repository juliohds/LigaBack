package com.project.Liga.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Liga.models.Mentor;
import com.project.Liga.repository.MentorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mentor")
public class MentorResource {
	
	@Autowired
	private MentorRepository mr;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Mentor> listarMentores() {
		Iterable<Mentor> listarMentores = mr.findAll();
		
		if(((List<Mentor>) listarMentores).isEmpty()) {
			Mentor m1 = new Mentor();
			m1.setTipo("TECNOLOGIA");
			mr.save(m1);
			Mentor m2 = new Mentor();
			m2.setTipo("NEGOCIO");
			mr.save(m2);
			Mentor m3 = new Mentor();
			m3.setTipo("FINANCEIRO");
			mr.save(m3);
		}
		
		listarMentores = mr.findAll();
			
		return listarMentores;
	}
	
	@PostMapping()
	public Mentor cadastraMentor(@RequestBody @Valid Mentor mentor) {
		
		return mr.save(mentor);
	}
	
}
