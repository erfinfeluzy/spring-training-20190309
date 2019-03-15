package id.co.telkomsigma.training.spring.ws.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import id.co.telkomsigma.training.spring.model.TwitterResponse;
import id.co.telkomsigma.training.spring.model.TwitterUser;
import id.co.telkomsigma.training.spring.repository.TwitterUserRepository;

@RestController
public class TwitterRestAPI {
	
	
	@Autowired
	TwitterUserRepository twitterUserRepository;

	@GetMapping(value="/api/v2/get/{username}")
	public ResponseEntity<?> getByUsername( @PathVariable String username) {
		
		try {
			
			TwitterUser userFromDB = twitterUserRepository.cariDenganUsername(username);
			
			if(userFromDB == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
			return ResponseEntity.ok().body(userFromDB);
				
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		}
		
	}
	
	@GetMapping(value="/api/v2/all")
	public ResponseEntity<?> getAllUser() {
		
		TwitterResponse response = new TwitterResponse();
		
		List<TwitterUser> allUser = twitterUserRepository.findAll();
		
		response.setAll(allUser);
		response.setDescription("ini loh gan");
		
		return ResponseEntity.ok().body(response);

		
	}
	
	@PostMapping(value="/api/v2/save")
	public ResponseEntity<?> save( @RequestBody TwitterUser user) {
		
		try {
			
			twitterUserRepository.save(user);
			
			return ResponseEntity.ok().body(user);
				
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		
		}
		
	}
	
}
