package br.biblioteca.livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.Autor;
import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.service.AutorService;
import br.biblioteca.livros.service.LivroService;

@Controller
@RequestMapping("livros")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@Autowired
	AutorService autorService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("livro/list");		
		List<Livro> livrosLista = livroService.listaTodosLivros();				
		modelAndView.addObject("livros", livrosLista);
		
		return modelAndView;		
	}
	
	@GetMapping("/new")
	public ModelAndView add(@ModelAttribute Livro livro) {
		ModelAndView modelAndView = new ModelAndView("livro/form");
		
		List<Autor> listaAutores = autorService.listarTodosAutores();
		modelAndView.addObject("autores", listaAutores);
		return modelAndView;
	}
	
	@PostMapping(value = "/create")
	public ModelAndView create(Livro livro) {
		
		livroService.salvarLivro(livro);
		
		return new ModelAndView("redirect:/livros/list");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id")Long id) {
		Livro livro = livroService.buscaLivro(id);
		
		List<Autor> listaAutores = autorService.listarTodosAutores();
		
		ModelAndView modelAndView = new ModelAndView("livro/form");
		modelAndView.addObject("autores", listaAutores);
		modelAndView.addObject("livro", livro);
		
		return modelAndView;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id")Long id) {
		
		livroService.excluirLivro(id);
		return new ModelAndView("redirect:/livros/list");
	}
	
}
