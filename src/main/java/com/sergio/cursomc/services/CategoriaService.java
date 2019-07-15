package com.sergio.cursomc.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sergio.cursomc.domain.Categoria;
import com.sergio.cursomc.repositories.CategoriaRepository;
import com.sergio.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if (obj == null) {
			
		}
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encotrado, ID: " + id + ", Tipo: " + Categoria.class.getName()));	
	}
	
	public Categoria insert (Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}