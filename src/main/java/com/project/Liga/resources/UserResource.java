package com.project.Liga.resources;

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

import com.project.Liga.EnviarEmail;
import com.project.Liga.models.User;
import com.project.Liga.repository.UserRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserResource {
	
	@Autowired
	private UserRepository ur;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<User> listaUser() {
		Iterable<User> ListaUser = ur.findAll();
		return ListaUser;
	}
	
	@PostMapping()
	public @Valid User cadastraUser(@RequestBody @Valid User user) {
		return ur.save(user);
	}
	
	@PostMapping(value="/forgot-password")
	public String enviarEmailDeEsqueciaSenha(@RequestBody User user){
		
		EnviarEmail ee = new EnviarEmail();
		ee.setEmailDestinatario(user.getEmail());
		User us = ur.findByEmail(user.getEmail());
		String senha = us.getSenha();
		ee.setMsg("Email de recuperação de senha"+senha);
		ee.setAssunto("Recuperação de Senha");
		ee.enviarGmail();
		
		return "ok";
	}
	
	@PostMapping(value="/login")
	public @Valid User login(@RequestBody @Valid User user) {
		
		String email = user.getEmail();
		String senha = user.getSenha();
		User us = ur.findByEmailAndSenha(email, senha);
		return us;
		
	}
	
	@PostMapping(value="/loginFace")
	public @Valid User loginFace(@RequestBody User user) {
		
		String email = user.getEmail();
		User us = ur.findByEmail(email);
		return us;
		
	}
	
	@DeleteMapping()
	public User deletaUser(@RequestBody User user) {
		ur.delete(user);
		return user;				
	}
}
