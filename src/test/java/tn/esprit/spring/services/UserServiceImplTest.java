package tn.esprit.spring.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

//import tn.esprit.spring.services.IUserService;

@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {

	@Autowired
	IUserService us;

	@Test
	@Order(1)
	//void contextLoads() {
	
	//IUserService us;
		public void testRetrieveAllUsers() {
			List<User> listUsers = us.retrieveAllUsers();
		    assertEquals(7, listUsers.size());
	}
	@Test
	@Order(2)
	public void testAddUser() throws ParseException, java.text.ParseException{
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
	    Date d = dateFormat.parse("2010-01-20");
		User u = new User("Salma","Salma",d,Role.INGENIEUR );
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}
	@Test
	@Order(3)
	public void testModifyUser() throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
	    Date d = dateFormat.parse("2010-01-20");
	    User u = new User(5L,"Salma1","Salma",d,Role.INGENIEUR);
	    User userUpdated =us.updateUser(u);
		Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());

		
	}
	

	

	}
