package com.sistemaescolar.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.service.AlunoService;
import com.sistemaescolar.dto.AlunoDto;
import com.sistemaescolar.model.Aluno;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoController {

	@Autowired
	private AlunoService service;
	
	@GetMapping
	public ResponseEntity<List<Aluno>> findAll() {
		List<Aluno> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable Long id) {
		Aluno obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Aluno> insert(@RequestBody AlunoDto obj) {
		Aluno aluno = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).body(aluno);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Aluno> update(@PathVariable Long id, @RequestBody AlunoDto obj){
		Aluno aluno = service.update(id, obj);
		return ResponseEntity.ok().body(aluno);
	}
}
