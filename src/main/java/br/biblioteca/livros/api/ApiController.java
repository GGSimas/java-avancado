package br.biblioteca.livros.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.service.LivroService;
import static br.biblioteca.livros.conversor.LivroConverter.toDTO;
import br.biblioteca.livros.dto.LivroDTO;
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	LivroService livroServices;
	
	
	@GetMapping("/livros/list")
	public ResponseEntity<List<LivroDTO>> livros() {
		List<Livro> listaLivros = livroServices.listaTodosLivros();
		
		return ResponseEntity.ok(toDTO(listaLivros));
		
	}
}
