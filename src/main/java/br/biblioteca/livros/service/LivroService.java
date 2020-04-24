package br.biblioteca.livros.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.biblioteca.livros.exception.LivroNotFoundException;
import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.repository.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;
	
	public List<Livro> listaTodosLivros() {
		return livroRepository.listaLivros();
	}
	
	public void salvarLivro(Livro livro) {
		 livroRepository.save(livro);
	}
	
	public Livro buscaLivro(Long id) {
		return livroRepository.findById(id).orElseThrow(() -> new LivroNotFoundException());
	}
	
	public void excluirLivro(Long id) {
		livroRepository.deleteById(id);
	}
}
