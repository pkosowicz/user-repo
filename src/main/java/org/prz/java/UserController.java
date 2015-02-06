package main.java.org.prz.java;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class UserController {

	Integer counter = 0;

	private Integer userCounter(){
         return ++counter;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		model.addAttribute("userCounter", userCounter());
		model.addAttribute("message", "Welcome");
		return "user";
	}
	
	@RequestMapping(value = "/user/{name}", method = RequestMethod.GET)
	public String welcomeName(ModelMap model, @PathVariable String name) {
		model.addAttribute("message", name);
		model.addAttribute("userCounter", userCounter());
		return "user";
	}
}
