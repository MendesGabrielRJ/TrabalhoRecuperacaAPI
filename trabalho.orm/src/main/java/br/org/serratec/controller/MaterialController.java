package br.org.serratec.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.serratec.model.Material;
import br.org.serratec.repository.MaterialRepository;

@RestController
@RequestMapping("/produtos")

public class MaterialController {
	
	@Autowired
	private MaterialRepository materialRepository;

	@GetMapping
	public List<Material> listar(){
		return materialRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Material> buscar(@PathVariable Long id) {
		Optional<Material> produto = materialRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(produto.get());
		}
		
			return ResponseEntity.notFound().build();
		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Material inserir(@RequestBody Material produto) {
		return materialRepository.save(produto);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!materialRepository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		materialRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
