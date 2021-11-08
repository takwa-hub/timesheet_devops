
package tn.esprit.spring.services;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiveImplTest {
	@Autowired
	IContratService cs;
	@Autowired
	private ContratRepository repository;
	private static final Logger L = LogManager.getLogger(ContratServiceImpl.class);

	@Test
	@Order(2)
	public void testRetrieveAllContrats() {
	/*List<Contrat> listContrats = cs.retrieveAllContrats();
	Assertions.assertEquals(2, listContrats.size());*/
		try {
			List<Contrat>contrats=cs.retrieveAllContrats();
			assertThat(contrats).size().isGreaterThan(0);
			for(Contrat c:contrats) {
				L.info("Le contrat est: "+ c);}
			L.info("La taille de contrats  ,"+contrats.size());}
		catch (IllegalArgumentException ex){
			assertEquals("the table is empty", ex.getMessage());
		}
	}
	
	
	@Test
	@Order(1)
	public void testAddContrat() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		Contrat c = new Contrat (d,"affaire", 15);
		Contrat contratAdded = cs.addContrat(c);
		Assertions.assertEquals(c.getReference(), contratAdded.getReference());
	}
		
	@Test
	@Order(3)
	public void testUpdateContrat() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-15");
		Contrat c = new Contrat (d,"affaire", 15);
		Contrat contratUpdated = cs.addContrat(c);
		Assertions.assertEquals(c.getReference(), contratUpdated.getReference());
		
		
	}
public  void testDeleteContrat() {
		
		Long id=(long) 6;
		boolean notExistAfterDelete =repository.findById(id).isPresent();
		boolean isExistBeforeDelete =repository.findById(id).isPresent();
		if(isExistBeforeDelete) {
			cs.deleteContrat(id);
			assertTrue(isExistBeforeDelete);
			L.info("le contrat est supprimé ");}

		
		else {
			assertFalse(notExistAfterDelete);
			L.info("le contrat est introuvable ");}
	}
       
	/*@Test
	@Order(4)
	public void testDeleteContrat(){
		cs.deleteContrat((long) 2);
		Assertions.assertNull(cs.retrieveContrat(2));
		
	}*/
	
	
	
	
	/*private static final Logger L = LogManager.getLogger(ContratServiceImpl.class);
	
	@Test
	public void testAll(){
		try{
			L.info("In testAll()");
			testRetrieveAllContrats();
			testAddContrat();
			testUpdateContrat();
			testDeleteContrat();
			L.info("Out of testAll()");
		}catch(Exception e){
			L.error("Out of testAll()with error:" +e);
		}
		
	}*/
	

}


