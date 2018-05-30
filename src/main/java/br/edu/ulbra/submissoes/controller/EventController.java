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
@RequestMapping("/evento")
public class EventController {

	@GetMapping
	@ApiOperation(value = "Exibe listagem de eventos")
	public ModelAndView pageEvent() {
		ModelAndView mv = new ModelAndView("event/eventList");
		mv.addObject("eventList", "");
		return mv;
	}

	@GetMapping("/{id}")
	@ApiOperation(value = "Exibe detalhamento de evento")
	public ModelAndView pageDetail(@PathVariable("id") Long eventId) {
		ModelAndView mv = new ModelAndView("event/eventDetail");
		mv.addObject("eventDetail", "");
		return mv;
	}

	@GetMapping("/{id}/delete")
	@ApiOperation(value = "Exclusão de evento")
	@ResponseBody
	public String delete(@PathVariable("id") Long eventId) {
		return "OK";
	}

	@PostMapping
	@ApiOperation(value = "Inserção de dados de evento")
	@ResponseBody
	public String save(@RequestBody Object input) {
		return "OK";
	}

	@PostMapping("{id}")
	@ApiOperation(value = "Update de evento")
	@ResponseBody
	public String update(@PathVariable("id") Long eventId, @RequestBody Object input) {
		return "OK";
	}
}
