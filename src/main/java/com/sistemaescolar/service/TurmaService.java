package com.sistemaescolar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.service.exception.ResourceNotFoundException;
import com.sistemaescolar.dto.TurmaDto;
import com.sistemaescolar.model.Escola;
import com.sistemaescolar.model.Turma;
import com.sistemaescolar.repository.EscolaRepository;
import com.sistemaescolar.repository.TurmaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository repository;
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	public List<Turma> findAll() {
		return repository.findAll();
	}
	
	public Turma findById(Long id) {
		Optional<Turma> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public Turma insert(TurmaDto obj) {
		Escola escola = escolaRepository.getReferenceById(obj.getEscolaId());
		Turma turma = new Turma(obj);
		turma.setEscola(escola);
		return repository.save(turma);
	}
	
	public void delete(Long id) {
		findById(id);
		Turma turma = repository.getReferenceById(id);
		turma.getAlunos().forEach(aluno -> aluno.setTurma(null));
		turma.getProfessores().forEach(professor -> professor.getTurmas().remove(turma));
		repository.deleteById(id);
	}
	
	public Turma update(Long id, Turma obj) {
		try {
			Turma entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	private void updateData(Turma entity, Turma obj) {
		if(obj.getNumeroDaSala() != null)
			entity.setNumeroDaSala(obj.getNumeroDaSala());
		if(obj.getAnoEscolar() != null)
			entity.setAnoEscolar(obj.getAnoEscolar());
		if(obj.getNumeroDaTurma() != null)
			entity.setNumeroDaTurma(obj.getNumeroDaTurma());
	}
}
