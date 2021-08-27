package com.neovia.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neovia.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository< Pessoa, Integer> {

}
