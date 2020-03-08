package br.biblioteca.livros.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class Autor {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "author")
	private List<Livro> books = new ArrayList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Livro> getBooks() {
		return books;
	}

	public void setBooks(List<Livro> books) {
		this.books = books;
	}
	
	
}
