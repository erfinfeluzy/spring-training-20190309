package id.co.telkomsigma.training.spring.ws.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.telkomsigma.training.spring.model.TwitterUser;
import id.co.telkomsigma.training.spring.repository.TwitterUserRepository;

@RestController
public class UserRestWS {
	
	@Autowired
	TwitterUserRepository twitterUserRepository;

	@GetMapping(value="/api/rest/{username}")
	public ResponseEntity<?> userRest( @PathVariable String username) {
		
		TwitterUser userFromDB = twitterUserRepository.cariDenganUsername(username);
		
		return ResponseEntity.ok().body(userFromDB);
			
	}

	
	@PostMapping(value="/api/rest/user/save")
	public ResponseEntity<?> userRest(@RequestBody TwitterUser user) {
		
		twitterUserRepository.save(user);
		
		return ResponseEntity.ok().body(user);
			
	}
	
}
