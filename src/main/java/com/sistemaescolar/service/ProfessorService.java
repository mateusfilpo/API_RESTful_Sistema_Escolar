package com.sistemaescolar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.exception.ResourceNotFoundException;
import com.sistemaescolar.dto.ProfessorDto;
import com.sistemaescolar.model.Escola;
import com.sistemaescolar.model.Professor;
import com.sistemaescolar.model.Turma;
import com.sistemaescolar.repository.EscolaRepository;
import com.sistemaescolar.repository.ProfessorRepository;
import com.sistemaescolar.repository.TurmaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository repository;
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Professor> findAll(){
		return repository.findAll();
	}
	
	public Professor findById(Long id) {
		Optional<Professor> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Professor insert(ProfessorDto obj) {
		Escola escola = escolaRepository.getReferenceById(obj.getEscolaId());
		List<Turma> turmas = new ArrayList<>();
		obj.getTurmasIds().forEach(turmaId -> turmas.add(turmaRepository.getReferenceById(turmaId)));
		Professor professor = new Professor(obj);
		professor.setEscola(escola);
		professor.getTurmas().addAll(turmas);
		return repository.save(professor);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Professor update(Long id, ProfessorDto obj) {
		try {
			Professor entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException  e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Professor entity, ProfessorDto obj) {
		if(obj.getName() != null)
			entity.setName(obj.getName());
		if(obj.getTelefone() != null)
			entity.setTelefone(obj.getTelefone());
		if(obj.getEmail() != null)
			entity.setEmail(obj.getEmail());
		if(obj.getMateriaEscolar() != null)
			entity.setMateriaEscolar(obj.getMateriaEscolar());
		if(obj.getTurmasIds() != null) {
			List<Turma> turmas = new ArrayList<>();
			obj.getTurmasIds().forEach(turmaId -> turmas.add(turmaRepository.getReferenceById(turmaId)));
			entity.getTurmas().clear();
			entity.getTurmas().addAll(turmas);
		}
	}

}
