package id.co.telkomsigma.training.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import id.co.telkomsigma.training.spring.model.TwitterUser;

@Transactional
public interface TwitterUserRepository extends JpaRepository<TwitterUser, Long> {

	TwitterUser findByUserName(String userName);
	
	@Query(nativeQuery = true,
			value = "select * "
					+ "from tbl_twitter_user "
					+ "where twitter_user_name = :username")
	TwitterUser cariDenganUsername(@Param("username") String username);
	
}
