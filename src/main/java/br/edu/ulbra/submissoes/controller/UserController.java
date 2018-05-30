package br.edu.ulbra.submissoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ulbra.submissoes.exception.UserException;
import br.edu.ulbra.submissoes.model.User;
import br.edu.ulbra.submissoes.service.UserService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/usuario")
public class UserController {

	private final UserService userService;

	@Autowired
	UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{userId}")
	@ApiOperation(value = "Exibe dados do usuário")
	public ModelAndView exibeUsuario(@PathVariable("userId") Long userId) {
		ModelAndView mv = new ModelAndView("user/show");
		try {
			User user = userService.findById(userId);
			mv.addObject("user", user);
			return mv;
		} catch (UserException e) {
			mv.addObject("error", e.getMessage());
		}
		return mv;
	}

	@GetMapping("/cadastro")
	@ApiOperation(value = "Exibe formulario cadastro de usuário")
	public ModelAndView pageRegisterUser() {
		ModelAndView mv = new ModelAndView("user/show");
		mv.addObject("userRegister", "");
		return mv;
	}

	@PostMapping("/cadastro")
	@ApiOperation(value = "Inserção de dados de usuario")
	@ResponseBody
	public String save(@RequestBody Object input) {
		return "OK";
	}

//	// Exemplo para insert de usuário via API
//	@PostMapping("/exemplo")
//	@ApiOperation(value = "Exemplo de inserção de dados de usuário")
//	@ResponseBody
//	public String exemploInsertUsuario(@RequestBody UserInput userInput) {
//		userInput.setId(null);
//		try {
//			userService.save(userInput, false);
//		} catch (UserException e) {
//			return e.getMessage();
//		}
//		return "OK";
//	}
//
//	@GetMapping("/exemplo/{userId}/delete")
//	@ApiOperation(value = "Exemplo de exclusão de dados de usuário")
//	@ResponseBody
//	public String exemploInsertUsuario(@PathVariable("userId") Long userId) {
//		try {
//			userService.delete(userId);
//		} catch (UserException e) {
//			return e.getMessage();
//		}
//		return "OK";
//	}
}
