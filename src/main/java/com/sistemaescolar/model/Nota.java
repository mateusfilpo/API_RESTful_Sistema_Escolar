package com.sistemaescolar.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sistemaescolar.dto.NotaDto;
import com.sistemaescolar.model.enums.Bimestre;
import com.sistemaescolar.model.enums.MateriaEscolar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Double valorNota;
	private Bimestre bimestre;
	private String numeroDaTurma;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;
	
	private MateriaEscolar materiaEscolar;
	
	@JsonProperty("nomeProfessor")
	public String getNomeProfessor() {
		return professor.getName();
	}
	
	@JsonProperty("nomeAluno")
	public String getNomeAluno() {
		return aluno.getName();
	}
	
//	@JsonProperty("numeroTurma")
//	public String getNumeroTurma() {
//		return aluno.getNumeroDaTurma();
//	}
	
	public Nota() {
	}
	
	public Nota(NotaDto notaDto) {
		this.valorNota = notaDto.getValorNota();
		this.bimestre = notaDto.getBimestre();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValorNota() {
		return valorNota;
	}

	public void setValorNota(Double valorNota) {
		this.valorNota = valorNota;
	}

	public Bimestre getBimestre() {
		return bimestre;
	}

	public void setBimestre(Bimestre bimestre) {
		this.bimestre = bimestre;
	}
	
	public String getNumeroDaTurma() {
		return numeroDaTurma;
	}
	
	public void setNumeroDaTurma(String numeroDaTurma) {
		this.numeroDaTurma = numeroDaTurma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public MateriaEscolar getMateriaEscolar() {
		return materiaEscolar;
	}

	public void setMateriaEscolar(MateriaEscolar materiaEscolar) {
		this.materiaEscolar = materiaEscolar;
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
		Nota other = (Nota) obj;
		return Objects.equals(id, other.id);
	}

}
