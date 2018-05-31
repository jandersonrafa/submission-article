package br.edu.ulbra.submissoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ulbra.submissoes.exception.UserException;
import br.edu.ulbra.submissoes.input.UserInput;
import br.edu.ulbra.submissoes.model.User;
import br.edu.ulbra.submissoes.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/usuario")
public class UserController {

    private final UserService userService;

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

    @PostMapping
    @ApiOperation(value = "Inserção de dados de usuario")
    @ResponseBody
    public String save(@RequestBody UserInput userInput) throws UserException {
        userInput.setId(null);
        try {
            userService.save(userInput, false);
        } catch (UserException e) {
            return e.getMessage();
        }
        return "OK";
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Alteração de dados de usuario")
    @ResponseBody
    public String update(@PathVariable("id") Long userId, @RequestBody UserInput userInput) throws UserException {
        userInput.setId(userId);
        try {
            userService.save(userInput, true);
        } catch (UserException e) {
            return e.getMessage();
        }
        return "OK";
    }

    @DeleteMapping("/exemplo/{userId}/delete")
    @ApiOperation(value = "Exclusão de usuário")
    @ResponseBody
    public String delete(@PathVariable("userId") Long userId) {
        try {
            userService.delete(userId);
        } catch (UserException e) {
            return e.getMessage();
        }
        return "OK";
    }
}
