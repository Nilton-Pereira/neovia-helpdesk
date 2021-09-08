package com.neovia.helpdesk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.neovia.helpdesk.domain.Tecnico;
import com.neovia.helpdesk.repositories.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById (Integer id) {
		Optional <Tecnico> obj = repository.findById(id);
		return obj.orElse(null);
	}
}
