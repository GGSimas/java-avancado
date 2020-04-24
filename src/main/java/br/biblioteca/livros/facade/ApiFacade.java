package br.biblioteca.livros.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.conversor.AvaliacaoConverter;
import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.models.Avaliacao;
import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.service.AvaliacaoService;
import br.biblioteca.livros.service.LivroService;

@Service
public class ApiFacade {

	@Autowired
	LivroService livroServices;
	
	@Autowired
	AvaliacaoService avaliacaoService;

	public List<Livro> listaTodosLivros() {
		return livroServices.listaTodosLivros();
	}
	
	
	public Long salvarAvaliacao(Long idLivro, AvaliacaoDTO avaliacaoDTO ) {
		Livro livro = livroServices.buscaLivro(idLivro);
		
		Avaliacao avaliacao = AvaliacaoConverter.toModel(avaliacaoDTO, livro);
		return avaliacaoService.salvarAvaliacao(avaliacao);
		
	}
	
	
}
