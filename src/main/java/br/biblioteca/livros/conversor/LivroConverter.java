package br.biblioteca.livros.conversor;

import java.util.List;
import java.util.stream.Collectors;

import br.biblioteca.livros.dto.LivroDTO;
import br.biblioteca.livros.models.Livro;

public class LivroConverter {

	public static LivroDTO toDTO(Livro livro) {
		LivroDTO dto = new LivroDTO();
		dto.setTitulo(livro.getName());
		dto.setPaginas((int)livro.getNumberPages());
		dto.setAutor(livro.getAuthor() != null ? livro.getAuthor().getName() : null);
		
		return dto;
	}
	
	public static List<LivroDTO> toDTO(List<Livro> livros) {
		return livros.stream().map(livro -> toDTO(livro)).collect(Collectors.toList());
	}
}
