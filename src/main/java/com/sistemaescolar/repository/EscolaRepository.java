package com.sistemaescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaescolar.model.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

}
