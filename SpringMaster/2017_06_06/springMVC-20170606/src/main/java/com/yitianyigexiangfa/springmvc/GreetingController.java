package com.yitianyigexiangfa.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	@RequestMapping(value = "/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "world", required = false) String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
}
