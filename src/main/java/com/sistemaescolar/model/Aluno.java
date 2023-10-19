package com.sistemaescolar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistemaescolar.dto.AlunoDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String telefone;
	private String email;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "escola_id")
	private Escola escola;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	private List<Nota> notas = new ArrayList<>();
	
	@JsonProperty("nomesProfessoresMaterias")
	public List<String> getProfessoresMaterias() {
		return turma.getProfessores().stream()
				.map(professor -> "Nome: " + professor.getName() + " - " + "Matéria: " + professor.getMateriaEscolar())
				.collect(Collectors.toList());
	}
	
	@JsonProperty("notasInfo")
	public List<String> getNotasInfo() {
		return notas.stream()
				.map(nota -> "Professor: " + nota.getProfessor().getName() + " - " + "Matéria: "  + nota.getProfessor().getMateriaEscolar() +  " - " + "Nota: " + nota.getValorNota() + " - " + "Bimestre: " + nota.getBimestre())
				.collect(Collectors.toList());
	}
	
	@JsonProperty("numeroDaTurma")
	public String getNumeroDaTurma() {
		return turma.getNumeroDaTurma();
	}
	
	@JsonProperty("anoEscolar")
	public String getAnoEscolar() {
		return turma.getAnoEscolar();
	}
	
	public Aluno() {
	}
	
	public Aluno(Long id, String name, String email) {
		this.email = email;
	}
	
	public Aluno(AlunoDto alunoDto) {
		this.name = alunoDto.getName();
		this.telefone = alunoDto.getTelefone();
		this.email = alunoDto.getEmail();
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	
	public List<Nota> getNotas() {
		return notas;
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
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id);
	}
	
}
