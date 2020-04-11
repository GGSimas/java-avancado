package br.biblioteca.livros.controllers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.Livro;
import br.biblioteca.livros.service.LivroService;

@Controller
@RequestMapping("livros")
public class LivroController {
	
	@Autowired
	LivroService livroService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("livro/list");		
		List<Livro> livrosLista = livroService.listaTodosLivros();				
		modelAndView.addObject("livros", livrosLista);
		
		return modelAndView;		
	}
	
	@GetMapping("/new")
	public ModelAndView add() {
		return new ModelAndView("livro/new");
	}
	
	@PostMapping(value = "/create")
	public ModelAndView create(Livro livro) {
		return new ModelAndView("redirect:livro/list");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id")Long id) {
		return new ModelAndView("redirect:livro/list");
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id")Long id) {
		return new ModelAndView("redirect:livro/list");
	}
	
}
