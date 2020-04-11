package br.biblioteca.livros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.biblioteca.livros.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

	@Query(value = " from #{#entityName} l left join fetch l.author a order by l.name desc ")
	List<Livro> listaLivros();
}
