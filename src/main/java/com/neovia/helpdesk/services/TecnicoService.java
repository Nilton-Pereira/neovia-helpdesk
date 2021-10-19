package com.neovia.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neovia.helpdesk.domain.Pessoa;
import com.neovia.helpdesk.domain.Tecnico;
import com.neovia.helpdesk.domain.dtos.TecnicoDTO;
import com.neovia.helpdesk.repositories.PessoaRepository;
import com.neovia.helpdesk.repositories.TecnicoRepository;
import com.neovia.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.neovia.helpdesk.services.exceptions.ObjectnotFoundException;


@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	public Tecnico findById (Integer id) {
		Optional <Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Objeto Não encontrado!!! Id " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Tecnico newObj = new Tecnico(objDTO);
		return repository.save(newObj);
		
	}
	
	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF Cadastrado no Sistema");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email Cadastrado no Sistema");
		}
		
	
	}
}


