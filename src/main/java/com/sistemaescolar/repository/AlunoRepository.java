package com.sistemaescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaescolar.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

}
