package com.neovia.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.neovia.helpdesk.domain.Chamado;
import com.neovia.helpdesk.domain.Cliente;
import com.neovia.helpdesk.domain.Tecnico;
import com.neovia.helpdesk.domain.enums.Perfil;
import com.neovia.helpdesk.domain.enums.Prioridade;
import com.neovia.helpdesk.domain.enums.Status;
import com.neovia.helpdesk.repositories.ChamadoRepository;
import com.neovia.helpdesk.repositories.ClienteRepository;
import com.neovia.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired 
	BCryptPasswordEncoder encoder;
	
	
		public void instanciaDB() {
			Tecnico tec1 = new Tecnico(null,"Nilton Pereira","06722137961","niljorgepereira@gmail.com", encoder.encode("123"));
			tec1.addPerfil(Perfil.ADMIN);
			
			Cliente cli1 = new Cliente(null,"Andre costa","75465016795","andre.costa@neoviaengenharia.com.br",encoder.encode("123"));
			
			Chamado c1 = new Chamado(null,Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01", "Primeiro chamado", tec1, cli1);
		
		
		tecnicoRepository .saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository .saveAll(Arrays.asList(c1));
		}

}
