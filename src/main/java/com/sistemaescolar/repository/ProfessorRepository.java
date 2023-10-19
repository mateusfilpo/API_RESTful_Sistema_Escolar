package com.sistemaescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaescolar.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
