package br.edu.ulbra.submissoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

/**
 *
 * @author Janderson
 */
@Controller
@RequestMapping("/")
public class IndexController {

	@GetMapping
	@ApiOperation(value = "Exibe Pagina inicial")
	public ModelAndView exibePaginaInicial() {
		ModelAndView mv = new ModelAndView("user/show");
		mv.addObject("index", "");
		return mv;
	}
}
