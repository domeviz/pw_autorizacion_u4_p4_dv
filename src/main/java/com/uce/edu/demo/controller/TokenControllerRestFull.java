package com.uce.edu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.security.JwtUtils;
import com.uce.edu.demo.service.to.UsuarioTO;

@RestController
@CrossOrigin
@RequestMapping("/tokens")
public class TokenControllerRestFull {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/obtener")
	public String getToken(@RequestBody UsuarioTO usuario) {
		this.autenticated(usuario.getUsername(), usuario.getPassword());
		return this.jwtUtils.generateJwtToken(usuario.getUsername());
	}

	private void autenticated(String usuario, String password) {
		Authentication authentication = this.authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(usuario, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}
