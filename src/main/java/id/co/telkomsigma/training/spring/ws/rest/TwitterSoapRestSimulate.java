package id.co.telkomsigma.training.spring.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import id.co.telkomsigma.training.spring.model.TwitterUser;
import id.co.telkomsigma.training.spring.ws.soap.TwitterUserSoapService;

@RestController
public class TwitterSoapRestSimulate {

	/** Simulate SOAP consumer over REST producer **/
	
	@Autowired
	@Qualifier("client")
	TwitterUserSoapService twitterUserSoapService;
	
	
	@GetMapping(value="/api/rest/twitters")
	public ResponseEntity<?> getAllTwitterUsers() {
		
		System.out.println("Simulate SOAP consumer over REST producer!");
		
		List<TwitterUser> users = twitterUserSoapService.getAllTwiiterUsers();
		
		return ResponseEntity.ok().body(users);
			
	}
	
}
