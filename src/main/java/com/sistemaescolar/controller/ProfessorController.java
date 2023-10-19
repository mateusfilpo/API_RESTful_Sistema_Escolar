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

import com.example.demo.service.ProfessorService;
import com.sistemaescolar.dto.ProfessorDto;
import com.sistemaescolar.model.Professor;

@RestController
@RequestMapping(value = "/professores")
public class ProfessorController {

	@Autowired
	private ProfessorService service;
	
	@GetMapping
	public ResponseEntity<List<Professor>> findAll() {
		List<Professor> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Professor> findById(@PathVariable Long id) {
		Professor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Professor> insert(@RequestBody ProfessorDto obj) {
		Professor professor = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professor.getId()).toUri();
		return ResponseEntity.created(uri).body(professor);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delte(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Professor> update(@PathVariable Long id, @RequestBody ProfessorDto obj){
		Professor professor = service.update(id, obj);
		return ResponseEntity.ok().body(professor);
	}
	
}
