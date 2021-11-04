package tn.esprit.spring.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import tn.esprit.spring.services.IUserService;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;

@SpringBootTest
//@TestMethodOrder(OrderAnnotation.class)
public class EmployeServiceImplTest {

	@Autowired
	IEmployeService es;

	//@Test
	//@Order(1)
	
	/*public void testRetrieveAllEmployees() {
		List<Employe> listEmployees = es.retrieveAllEmployees();
		assertEquals(7, listEmployees.size());
	}*/
	@Order(1)
	@Test
	public void testAddEmploye() throws ParseException, java.text.ParseException{
		Employe e = new Employe(0, "takwa","ghodhbeni","takwa.ghodhbeni@esprit.tn", " password", true, Role.INGENIEUR );
		Employe employeAdded = es.addEmploye(e);
		Assertions.assertEquals(e.getNom(), employeAdded.getNom());
	}
	@Order(2)
	@Test
	
	public void testModifyEmploye() throws ParseException {
		Employe e = new Employe(0, "takwa12","ghodhbeni","takwa.ghodhbeni@esprit.tn", " password", true, Role.INGENIEUR);
		Employe employeUpdated =es.updateEmploye(e);
		Assertions.assertEquals(e.getNom(), employeUpdated.getNom());


	}


}
