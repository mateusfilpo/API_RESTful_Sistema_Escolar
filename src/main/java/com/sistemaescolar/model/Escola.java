package com.sistemaescolar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Escola {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String telefone;
	private String email;
	
	@OneToOne(mappedBy = "escola", cascade = CascadeType.ALL)
    private Endereco endereco;
	
	@OneToMany(mappedBy = "escola", cascade = CascadeType.ALL) 
    private List<Turma> turmas = new ArrayList<>();
	
	@OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
	private List<Professor> professores = new ArrayList<>();
	
	@OneToMany(mappedBy = "escola", cascade = CascadeType.ALL)
	private List<Aluno> alunos = new ArrayList<>();
	
	public Escola() {
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
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}
	
	public List<Professor> getProfessores() {
		return professores;
	}
	
	public List<Aluno> getAlunos() {
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
		Escola other = (Escola) obj;
		return Objects.equals(id, other.id);
	}
	
}
