package com.sergio.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergio.cursomc.domain.Cliente;
import com.sergio.cursomc.repositories.ClienteRepository;
import com.sergio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if (obj == null) {
			
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encotrado, ID: " + id + ", Tipo: " + Cliente.class.getName()));	
	}
}