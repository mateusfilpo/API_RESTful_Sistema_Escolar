package com.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaescolar.dto.NotaDto;
import com.sistemaescolar.model.Aluno;
import com.sistemaescolar.model.Nota;
import com.sistemaescolar.model.Professor;
import com.sistemaescolar.repository.AlunoRepository;
import com.sistemaescolar.repository.NotaRepository;
import com.sistemaescolar.repository.ProfessorRepository;
import com.sistemaescolar.service.exception.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class NotaService {

	@Autowired
	private NotaRepository repository;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	public List<Nota> findAll() {
		return repository.findAll();
	}
	
	public Nota findById(Long id) {
		Optional<Nota> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Nota insert(NotaDto obj) {
		Aluno aluno = alunoRepository.getReferenceById(obj.getAlunoId());
		Professor professor = professorRepository.getReferenceById(obj.getProfessorId());
		Nota nota = new Nota(obj);
		nota.setAluno(aluno);
		nota.setProfessor(professor);
		nota.setMateriaEscolar(professor.getMateriaEscolar());
		nota.setNumeroDaTurma(aluno.getNumeroDaTurma());
		return repository.save(nota);
	}
	
	public void delete(Long id) {
		findById(id);
		Nota nota = repository.getReferenceById(id);
		nota.getAluno().getNotas().remove(nota);
		nota.getProfessor().getNotas().remove(nota);
		repository.deleteById(id);
	}
	
	public Nota update(Long id, Nota obj) {
		try {
			Nota entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException  e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Nota entity, Nota obj) {
		if(obj.getValorNota() != null)
			entity.setValorNota(obj.getValorNota());
	}
}
