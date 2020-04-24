package br.biblioteca.livros.conversor;

import java.util.List;
import java.util.stream.Collectors;

import br.biblioteca.livros.dto.AvaliacaoDTO;
import br.biblioteca.livros.models.Avaliacao;
import br.biblioteca.livros.models.Livro;

public class AvaliacaoConverter {

	public static Avaliacao toModel(AvaliacaoDTO avaliacaoDTO) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setComment(avaliacaoDTO.getComentario());
		avaliacao.setRate(avaliacaoDTO.getNota());
		
		return avaliacao;
	}
	
	public static Avaliacao toModel(AvaliacaoDTO avaliacaoDTO, Livro livro) {
		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setComment(avaliacaoDTO.getComentario());
		avaliacao.setRate(avaliacaoDTO.getNota());
		avaliacao.setBook(livro);
		
		return avaliacao;
	}
	public static AvaliacaoDTO toDTO(Avaliacao avaliacao) {
		AvaliacaoDTO dto = new AvaliacaoDTO();
		dto.setComentario(avaliacao.getComment());
		dto.setNota(avaliacao.getRate());
		
		return dto;
	}
	public static List<AvaliacaoDTO> toDTO(List<Avaliacao> avaliacoes) {
		return avaliacoes.stream().map(a -> toDTO(a)).collect(Collectors.toList());		
	}

}
