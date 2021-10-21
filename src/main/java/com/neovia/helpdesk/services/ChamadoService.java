package com.neovia.helpdesk.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neovia.helpdesk.domain.Chamado;
import com.neovia.helpdesk.domain.Cliente;
import com.neovia.helpdesk.domain.Tecnico;
import com.neovia.helpdesk.domain.dtos.ChamadoDTO;
import com.neovia.helpdesk.domain.enums.Prioridade;
import com.neovia.helpdesk.domain.enums.Status;
import com.neovia.helpdesk.repositories.ChamadoRepository;
import com.neovia.helpdesk.services.exceptions.ObjectnotFoundException;


@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;
	
	
	public Chamado findById(Integer id) {
		Optional<Chamado> obj = repository.findById(id);
		return obj.orElseThrow (() -> new ObjectnotFoundException("Objeto Não encontrado! ID:" + id));
	}

	public List<Chamado> findAll() {
		return repository.findAll();
	}

	public Chamado create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}
	
	
	
	public Chamado update(Integer id, @Valid ChamadoDTO objDTO) {
		objDTO.setId(id);
		Chamado oldObj = findById(id);
		oldObj = newChamado(objDTO);
		return repository.save(oldObj);
	}
	
	
	private Chamado newChamado(ChamadoDTO obj) {
		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());
		
		Chamado chamado = new Chamado();
		if(obj.getId() != null ) {
			chamado.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2));
			chamado.setDataFechamento(LocalDate.now());
		
		chamado.setTecnico(tecnico);
		chamado.setCliente(cliente);
		chamado.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamado.setStatus(Status.toEnum(obj.getStatus()));
		chamado.setTitulo(obj.getTitulo());
		chamado.setObservacoes(obj.getObservacoes());
		return chamado;
		
		
		
	}


}
