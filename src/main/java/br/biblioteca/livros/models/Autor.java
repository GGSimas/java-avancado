package br.biblioteca.livros.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Authors")
public class Autor implements Serializable {

	private static final long serialVersionUID = -2931921441183751443L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

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
