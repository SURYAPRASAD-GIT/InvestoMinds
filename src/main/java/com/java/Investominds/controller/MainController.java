package com.java.Investominds.controller;

import com.java.Investominds.repository.PlansRepo;
import com.java.Investominds.service.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private PlansRepo plansRepo;

	@GetMapping("/login")
	public String home() {
				return "index";
	}



	 @GetMapping("/")
	public String index(@AuthenticationPrincipal LoginUser usr, Model model){
		model.addAttribute("usr",usr);
		return "dashboard";
	}


	@GetMapping("/log")
	public String loginpage(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
			return "redirect:/login?notlogin";
		}
		return "redirect:/";
	}

	@GetMapping("/privacy")
	public String products() {
		return "privacy_policy";
	}

	@GetMapping("/contactus")
	public String contactus() {
		return "contact_us";
	}

	@GetMapping("/aboutus")
	public String aboutus() {
		return "aboutus";
	}


}































/*	@GetMapping("/login")
	public String login(Model model) {
		List<Plans> plans = plansRepo.findAll();
		model.addAttribute("plans",plans);
		return "login";
	}*/
