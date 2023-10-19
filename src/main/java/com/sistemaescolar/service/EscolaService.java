package com.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.model.Escola;
import com.sistemaescolar.repository.EscolaRepository;
import com.sistemaescolar.service.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository repository;
	
	public List<Escola> findAll() {
		return repository.findAll();
	}
	
	public Escola findById(Long id) {
		Optional<Escola> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Escola insert(Escola obj) {
		obj.getEndereco().setEscola(obj);
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Escola update(Long id, Escola obj) {
		try {
			Escola entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException  e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Escola entity, Escola obj) {
		if(obj.getName() != null)
			entity.setName(obj.getName());
		if(obj.getTelefone() != null)
			entity.setTelefone(obj.getTelefone());
		if(obj.getEmail() != null)
			entity.setEmail(obj.getEmail());
	}
}
