package com.uce.edu.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uce.edu.demo.service.to.UsuarioTO;

@RestController
@CrossOrigin
@RequestMapping("/tokens")
public class TokenControllerRestFull {
	@GetMapping
	public String getToken(@RequestBody UsuarioTO usuario){
		return "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkRvbWUiLCJhcGVsbGlkbyI6IlZpeiIsImlhdCI6MTUxNjIzOTAyMn0.4x3Ugs8v2desDN6PO1tCIB3dB38sDD7P6-sk3WJ1OM4";
    }
}
