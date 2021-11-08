/*package tn.esprit.spring.services;

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
	public void testRetrieveUser() {
		User userRetrieved = us.retrieveUser("2");
		Assertions.assertEquals(2L, userRetrieved.getId());
	}
	@Test
	@Order(4)
	public void testModifyUser() throws ParseException {
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
	    Date d = dateFormat.parse("2010-01-20");
	    User u = new User(5L,"Salma1","Salma",d,Role.INGENIEUR);
	    User userUpdated =us.updateUser(u);
		Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());

		
	}
	@Test
	@Order(5)
	public void testDeleteUser() {
		us.deleteUser("s");
		Assertions.assertNull(us.retrieveUser("S"));
	}

	

	}*/
package tn.esprit.spring.services;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;
import tn.esprit.spring.services.UserServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceImplTest {
	
	@Autowired
	IUserService us;

	@Test
	@Order(2)
	public void testRetrieveAllUsers() {
	List<User> listUsers = us.retrieveAllUsers();
	Assertions.assertEquals(2, listUsers.size());
	}
	
	@Test
	@Order(1)
	public void testAddUser() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User ("maysa", "maysa", d, Role.INGENIEUR);
		User userAdded = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}
		
	@Test
	@Order(3)
	public void testUpdateUser() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-15");
		User u = new User (7L, "TAKWA","TAKWA", d, Role.INGENIEUR);
		User userUpdated = us.addUser(u);
		Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
		
		
	}
	/*@Test
	@Order(5)
	public void testDeleteUser(){
		us.deleteUser("11");
		Assertions.assertNull(us.retrieveUser("11"));
		
	}*/
	
	@Test
	@Order(4)
	public void testRetrieveUser(){
		User userRetrieved = us.retrieveUser("7");
		Assertions.assertEquals(7L, userRetrieved.getId().longValue());
		
	}
	//private static final Logger L = LogManager.getLogger(UserServiceImpl.class);
	
	/*@Test
	public void testAll(){
		try{
			L.info("In testAll()");
			testRetrieveAllUsers();
			testAddUser();
			testUpdateUser();
			testDeleteUser();
			testRetrieveUser();
			L.info("Out of testAll()");
		}catch(Exception e){
			L.error("Out of testAll()with error:" +e);
		}
		
	}*/
	

}
