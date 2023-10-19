package com.sistemaescolar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistemaescolar.dto.TurmaDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Turma {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numeroDaTurma;
	private String numeroDaSala;
	private String anoEscolar;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola escola;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "turmas")
	private List<Professor> professores = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "turma")
	private List<Aluno> alunos = new ArrayList<>();
	
	@JsonProperty("nomesAlunos")
	public List<String> getNomesAlunos() {
		return alunos.stream()
				.map(aluno -> "Id: " + aluno.getId() + " - " + "Nome: " + aluno.getName())
				.collect(Collectors.toList());
	}
	
	@JsonProperty("nomesProfessoresMaterias")
	public List<String> getNomesProfessores() {
		return professores.stream()
				.map(professor -> "Id: " + professor.getId() + " - " + "Nome: " + professor.getName() + " - " + "Matéria: " + professor.getMateriaEscolar())
				.collect(Collectors.toList());
	}
	
	public Turma() { 
	}
	
	public Turma(TurmaDto turmaDto) {
		this.numeroDaTurma = turmaDto.getNumeroDaTurma();
		this.numeroDaSala = turmaDto.getNumeroDaSala();
		this.anoEscolar = turmaDto.getAnoEscolar();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroDaTurma() {
		return numeroDaTurma;
	}

	public void setNumeroDaTurma(String numeroDaTurma) {
		this.numeroDaTurma = numeroDaTurma;
	}

	public String getNumeroDaSala() {
		return numeroDaSala;
	}

	public void setNumeroDaSala(String numeroDaSala) {
		this.numeroDaSala = numeroDaSala;
	}

	public String getAnoEscolar() {
		return anoEscolar;
	}

	public void setAnoEscolar(String anoEscolar) {
		this.anoEscolar = anoEscolar;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}
	
	public List<Professor> getProfessores(){
		return professores;
	}
	
	public List<Aluno> getAlunos(){
		return alunos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}
	
}
