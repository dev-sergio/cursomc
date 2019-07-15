package com.sergio.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergio.cursomc.domain.Pedido;
import com.sergio.cursomc.repositories.PedidoRepository;
import com.sergio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if (obj == null) {
			
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encotrado, ID: " + id + ", Tipo: " + Pedido.class.getName()));	
	}
}