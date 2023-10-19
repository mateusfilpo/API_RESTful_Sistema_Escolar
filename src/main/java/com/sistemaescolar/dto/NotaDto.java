package com.sistemaescolar.dto;

import com.sistemaescolar.model.enums.Bimestre;

public class NotaDto {

	private Long id;
    private Double valorNota;
    private Bimestre bimestre;
    private Long alunoId;
    private Long professorId;
    
    public NotaDto() {
    }

	public NotaDto(Long id, Double valorNota, Bimestre bimestre, Long alunoId, Long professorId) {
		super();
		this.id = id;
		this.valorNota = valorNota;
		this.bimestre = bimestre;
		this.alunoId = alunoId;
		this.professorId = professorId;
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

	public Long getAlunoId() {
		return alunoId;
	}

	public void setAlunoId(Long alunoId) {
		this.alunoId = alunoId;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}
	
}
