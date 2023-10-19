package com.sistemaescolar.dto;

import java.util.Objects;

public class AlunoDto {

	private Long id;
    private String name;
    private String telefone;
    private String email;
    private Long escolaId;
    private Long turmaId;
    
    public AlunoDto() {
    }
    
	public AlunoDto(Long id, String name, String telefone, String email, Long escolaId, Long turmaId) {
		super();
		this.id = id;
		this.name = name;
		this.telefone = telefone;
		this.email = email;
		this.escolaId = escolaId;
		this.turmaId = turmaId;
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

	public Long getEscolaId() {
		return escolaId;
	}

	public void setEscolaId(Long escolaId) {
		this.escolaId = escolaId;
	}

	public Long getTurmaId() {
		return turmaId;
	}
	
	public void setTurmaId(Long turmaId) {
		this.turmaId = turmaId;
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
		AlunoDto other = (AlunoDto) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
