package br.biblioteca.livros.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.models.Avaliacao;
import br.biblioteca.livros.repository.AvaliacaoRepository;

@Service
public class AvaliacaoService {
	
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	public Long salvarAvaliacao(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao).getId();
	}
	

}
