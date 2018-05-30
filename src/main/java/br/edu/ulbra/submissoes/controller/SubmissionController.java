package br.edu.ulbra.submissoes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.ApiOperation;

/**
 *
 * @author Janderson
 */
@Controller
@RequestMapping("/submission")
public class SubmissionController {

	@GetMapping
	@ApiOperation(value = "Exibe eventos que usuario submeteu artigos")
	public ModelAndView pageListSubmission() {
		ModelAndView mv = new ModelAndView("submission/submissionList");
		mv.addObject("submissionList", "");
		return mv;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Exibe detalhamento de artigo submetido")
	public ModelAndView pageDetail(@PathVariable("id") Long submissionId) {
		ModelAndView mv = new ModelAndView("submission/submissionDetail");
		mv.addObject("submissionDetail", "");
		return mv;
	}

	@GetMapping("/{id}/delete")
	@ApiOperation(value = "Exclusão de artigo submetido")
	@ResponseBody
	public String delete(@PathVariable("id") Long submissionId) {
		return "OK";
	}

	@PostMapping("{id}")
	@ApiOperation(value = "Update de artigo submetido")
	@ResponseBody
	public String update(@PathVariable("id") Long submissionId, @RequestBody Object input) {
		return "OK";
	}

	@PostMapping("/evento/{idEvento}")
	@ApiOperation(value = "Cria nova Submissao de artigo")
	@ResponseBody
	public String save(@PathVariable("idEvento") Long idEvento, @RequestBody Object input) {
		return "OK";
	}

	@GetMapping("/evento/{idEvento}")
	@ApiOperation(value = "Formulario submissao de artigo")
	public ModelAndView pageSubmission(@PathVariable("idEvento") Long idEvento) {
		ModelAndView mv = new ModelAndView("submission/submissionRegister");
		mv.addObject("submissionRegister", "");
		return mv;
	}
}
