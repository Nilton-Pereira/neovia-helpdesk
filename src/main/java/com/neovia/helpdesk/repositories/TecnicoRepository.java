package com.neovia.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.neovia.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository< Tecnico, Integer> {

}
