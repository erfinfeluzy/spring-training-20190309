package id.co.telkomsigma.training.spring.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_twitter_user")
public class TwitterUser {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "twitter_user_name")
	private String userName;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "profile_picture_url")
	private String profilePictureUrl;
	
	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	/**
	 * ========= Mar 16 material
	 */
	
	@Column(name = "email")
	private String email;
	
}
