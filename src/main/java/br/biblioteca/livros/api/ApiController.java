package br.biblioteca.livros.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.method.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.service.AvaliacaoService;
import br.biblioteca.livros.service.LivroService;
import static br.biblioteca.livros.conversor.LivroConverter.toDTO;

import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.dto.LivroDTO;
import br.biblioteca.livros.exception.LivroNotFoundException;
import br.biblioteca.livros.facade.ApiFacade;
@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ApiFacade apiFacade;
	
	@GetMapping("/livros/list")
	public ResponseEntity<List<LivroDTO>> livros() {
		List<Livro> listaLivros = apiFacade.listaTodosLivros();
		
		return ResponseEntity.ok(toDTO(listaLivros));
		
	}
	
	@PostMapping("/livros/avalicao/{id}")
	public ResponseEntity<Long> comentario(@PathVariable("id") Long id, @RequestBody AvaliacaoDTO avaliacao) {
		
		try {			
			return ResponseEntity.ok(apiFacade.salvarAvaliacao(id, avaliacao));
		} catch (LivroNotFoundException e) {
			return ResponseEntity.notFound().build();
		}
	}
}
