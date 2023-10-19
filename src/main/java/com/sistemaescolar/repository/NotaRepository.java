package com.sistemaescolar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaescolar.model.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

}
