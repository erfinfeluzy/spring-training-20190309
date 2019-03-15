package id.co.telkomsigma.training.spring.model;

import java.util.List;

import lombok.Data;

@Data
public class TwitterResponse {

	private List<TwitterUser> all;
	
	private String description;
	
}
