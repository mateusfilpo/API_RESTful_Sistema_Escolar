package com.sistemaescolar.dto;

import java.util.List;
import java.util.Objects;

import com.example.demo.model.enums.MateriaEscolar;

public class ProfessorDto {

	private Long id;
    private String name;
    private String telefone;
    private String email;
    private MateriaEscolar materiaEscolar;
    private Long escolaId;
    private List<Long> turmasIds;
    
    public ProfessorDto() {
    }
    
	public ProfessorDto(Long id, String name, String telefone, String email, MateriaEscolar materiaEscolar, Long escolaId,
			List<Long> turmasIds) {
		super();
		this.id = id;
		this.name = name;
		this.telefone = telefone;
		this.email = email;
		this.materiaEscolar = materiaEscolar;
		this.escolaId = escolaId;
		this.turmasIds = turmasIds;
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

	public Long getEscolaId() {
		return escolaId;
	}

	public void setEscolaId(Long escolaId) {
		this.escolaId = escolaId;
	}

	public List<Long> getTurmasIds() {
		return turmasIds;
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
		ProfessorDto other = (ProfessorDto) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
