package com.neovia.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neovia.helpdesk.domain.Tecnico;
import com.neovia.helpdesk.repositories.TecnicoRepository;
import com.neovia.helpdesk.services.exceptions.ObjectnotFoundException;


@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById (Integer id) {
		Optional <Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto Não encontrado!!! Id " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}
}
