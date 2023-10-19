package com.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.AlunoDto;
import com.sistemaescolar.model.Aluno;
import com.sistemaescolar.model.Escola;
import com.sistemaescolar.model.Turma;
import com.sistemaescolar.repository.AlunoRepository;
import com.sistemaescolar.repository.EscolaRepository;
import com.sistemaescolar.repository.TurmaRepository;
import com.sistemaescolar.service.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	public List<Aluno> findAll() {
		return repository.findAll();
	}
	
	public Aluno findById(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Aluno insert(AlunoDto obj) {
		Escola escola = escolaRepository.getReferenceById(obj.getEscolaId());
		Turma turma = turmaRepository.getReferenceById(obj.getTurmaId());
		Aluno aluno = new Aluno(obj);
		aluno.setEscola(escola);
		aluno.setTurma(turma);
		return repository.save(aluno);
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public Aluno update(Long id, AlunoDto obj) {
		try {
			Aluno entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException  e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Aluno entity, AlunoDto obj) {
		if(obj.getName() != null)
			entity.setName(obj.getName());
		if(obj.getEmail() != null)
			entity.setEmail(obj.getEmail());
		if(obj.getTelefone() != null)
			entity.setTelefone(obj.getTelefone());
		if(obj.getTurmaId() != null) {
			Turma turma = turmaRepository.getReferenceById(obj.getTurmaId());
			entity.setTurma(turma);
		}
	}
}
