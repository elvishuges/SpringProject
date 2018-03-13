package com.algaworks.patrimonio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.algaworks.patrimonio.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
