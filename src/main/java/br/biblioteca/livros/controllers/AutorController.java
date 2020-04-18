package br.biblioteca.livros.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.biblioteca.livros.models.Autor;
import br.biblioteca.livros.service.AutorService;

@Controller
@RequestMapping("autores")
public class AutorController {

	@Autowired
	AutorService autorService;
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("autor/list");
		List<Autor> listaAutores = autorService.listarTodosAutores();
		modelAndView.addObject("autores", listaAutores);
		
		return modelAndView;
	}
}
