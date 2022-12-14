package br.com.biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.biblioteca.entities.Emprestimo;
import br.com.biblioteca.entities.Livro;

@Controller
public class HomeController {

	@Autowired
	private LivroController livroController;
	

	@GetMapping("/home")
	public String index() {
		return "home/index";
	}

	@PostMapping("/home")
	public ModelAndView getFormAdd() {

		ModelAndView mv = new ModelAndView("home/index");

		List<Livro> listaLivros = this.livroController.findAll();
		mv.addObject("listaLivros", listaLivros);

		return mv;
	}

	@GetMapping("/home/{id}")
	public ModelAndView getId(@PathVariable("id") Long id) {
			ModelAndView mv = new ModelAndView("home/index");

			Livro livro = this.livroController.findById(id);
			mv.addObject("livroId", livro);
		
		return mv;
	}
	
	
}
