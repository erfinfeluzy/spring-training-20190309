package id.co.telkomsigma.training.spring.ws.soap;

import java.util.List;

import javax.jws.WebService;

import id.co.telkomsigma.training.spring.model.TwitterUser;

@WebService
public interface TwitterUserSoapService {

	List < TwitterUser > getAllTwiiterUsers();
	
	TwitterUser createNewTwitterUser(TwitterUser user);
	
}
