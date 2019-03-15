package id.co.telkomsigma.training.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import id.co.telkomsigma.training.spring.model.TwitterUser;
import id.co.telkomsigma.training.spring.repository.TwitterUserRepository;

@Controller
public class UserPageController {
	
	
	@Autowired
	TwitterUserRepository twitterUserRepository;

	@RequestMapping(value="/{username}")
	public String apapunItu( @PathVariable String username , Model model) {
		
		TwitterUser userFromDB = twitterUserRepository.cariDenganUsername(username);
		
		model.addAttribute("user", userFromDB);
		
		return "bootstrap";
			
	}
	
}
