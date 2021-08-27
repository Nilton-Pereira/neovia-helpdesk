package com.neovia.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neovia.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository< Cliente, Integer> {

}
