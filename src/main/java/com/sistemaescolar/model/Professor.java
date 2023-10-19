package com.sistemaescolar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.demo.dto.ProfessorDto;
import com.example.demo.model.enums.MateriaEscolar;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Professor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String telefone;
	private String email;
	private com.sistemaescolar.model.enums.MateriaEscolar materiaEscolar;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "escola_id")
	private Escola escola;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "tb_professor_turma", joinColumns = @JoinColumn(name = "professor_id"), inverseJoinColumns = @JoinColumn(name = "turma_id"))
	private List<Turma> turmas = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL)
	private List<Nota> notas = new ArrayList<>();
	
	@JsonProperty("nomesAlunos")
	public List<String> getNomesAlunos() {
		return turmas.stream()
                .flatMap(turma -> turma.getAlunos().stream()
                .map(aluno -> "Id: " + aluno.getId() + " - " + "Nome: "  + aluno.getName() + " - Turma: " + turma.getNumeroDaTurma()))
                .collect(Collectors.toList());
	}
	
	@JsonProperty("numerosTurmas")
	public List<String> getNumerosTurmas() {
		return turmas.stream().map(Turma::getNumeroDaTurma).collect(Collectors.toList());
	}
	
	@JsonProperty("notasInfo")
	public List<String> getNotasInfo() {
		return notas.stream()
				.map(nota -> "Id Aluno: " + nota.getAluno().getId() + " - " + "Nome: " + nota.getAluno().getName() + " - " + "Nota: " + nota.getValorNota() + " - " + "Bimestre: " + nota.getBimestre())
				.collect(Collectors.toList());
	}

	public Professor() {
	}
	
	public Professor(ProfessorDto professorDto) {
		this.name = professorDto.getName();
		this.telefone = professorDto.getTelefone();
		this.email = professorDto.getEmail();
		this.materiaEscolar = professorDto.getMateriaEscolar();
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

	public MateriaEscolar getMateriaEscolar() {
		return materiaEscolar;
	}

	public void setMateriaEscolar(MateriaEscolar materiaEscolar) {
		this.materiaEscolar = materiaEscolar;
	}

	public Escola getEscola() {
		return escola;
	}

	public void setEscola(Escola escola) {
		this.escola = escola;
	}

	public List<Turma> getTurmas() {
		return turmas;
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
		Professor other = (Professor) obj;
		return Objects.equals(id, other.id);
	}

}
