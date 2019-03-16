package id.co.telkomsigma.training.spring.ws.soap;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.co.telkomsigma.training.spring.model.TwitterUser;
import id.co.telkomsigma.training.spring.repository.TwitterUserRepository;

@Service
public class TwitterUserSoapServiceImpl implements TwitterUserSoapService {

	@Autowired
	TwitterUserRepository twitterUserRepository;
	
	@Override
	public List<TwitterUser> getAllTwiiterUsers() {
		
		List<TwitterUser> users = twitterUserRepository.findAll();
		
		return users;
	}

}
