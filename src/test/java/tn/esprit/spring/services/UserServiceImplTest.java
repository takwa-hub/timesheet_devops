package tn.esprit.spring.services;

import java.util.List;


//import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.User;
//import tn.esprit.spring.services.IUserService;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {

	@Autowired
	IUserService us;

	@Test
	//void contextLoads() {
	
	//IUserService us;
		public void testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers();
		    assertEquals(0, listUsers.size());
	}

	}
