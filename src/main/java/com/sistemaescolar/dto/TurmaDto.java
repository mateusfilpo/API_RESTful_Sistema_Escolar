package com.sistemaescolar.dto;

import java.util.Objects;

public class TurmaDto {

	private Long id;
    private String numeroDaTurma;
    private String numeroDaSala;
    private String anoEscolar;
    private Long escolaId;
    
    public TurmaDto() {
    }
    
    public TurmaDto(Long id, String numeroDaTurma, String numeroDaSala, String anoEscolar, Long escolaId) {
        this.id = id;
        this.numeroDaTurma = numeroDaTurma;
        this.numeroDaSala = numeroDaSala;
        this.anoEscolar = anoEscolar;
        this.escolaId = escolaId;
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
	
	public Long getEscolaId() {
		return escolaId;
	}
	
	public void setEscolaId(Long escolaId) {
		this.escolaId = escolaId;
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
		TurmaDto other = (TurmaDto) obj;
		return Objects.equals(id, other.id);
	}
    
    
}
