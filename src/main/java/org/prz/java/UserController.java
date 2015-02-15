package main.java.org.prz.java;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class UserController {
	
	private Integer topId=0;
	private List<User> UserList = new ArrayList<User>(); 
	
	private Integer userIdCounter() {
		if (topId != null)
			return ++topId;
		else
			return topId = 1;
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String showUsers(ModelMap model) {
		model.addAttribute("list",UserList);	
		return "users";
	}
	
	@RequestMapping(value = "/user/{name}/{surname}", method = RequestMethod.GET)
	public String createUser(ModelMap model, @PathVariable String name,@PathVariable String surname) {			
		UserList.add(new User(topId,name,surname));			
		userIdCounter();		
		model.addAttribute("list", UserList);		
		return "users";
	}
	
	@RequestMapping(value = "/user")
	public String editUser(ModelMap model, @RequestParam("id") String id, @RequestParam("name") String name, @RequestParam("surname") String surname){
		UserList.set(Integer.parseInt(id),new User(Integer.parseInt(id),name,surname));	
		model.addAttribute("list", UserList);		
		return "users";
		
	}
}
