package com.sistemaescolar.controller;

import java.net.URI;
import java.util.List;
import java.util.NoSuchElementException;

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

import com.example.demo.service.EscolaService;
import com.sistemaescolar.model.Escola;

@RestController
@RequestMapping(value = "/escolas")
public class EscolaController {

	@Autowired
	private EscolaService service;
	
	@GetMapping
	public ResponseEntity<List<Escola>> findAll() {
		List<Escola> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Escola> findById(@PathVariable Long id) {
		Escola obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Escola> insert(@RequestBody Escola obj) {
		if(obj.getEndereco() == null)
			throw new NoSuchElementException();
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Escola> update(@PathVariable Long id, @RequestBody Escola obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	
}
