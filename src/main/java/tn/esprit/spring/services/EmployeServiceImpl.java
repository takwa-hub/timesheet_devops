package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

public abstract  class EmployeServiceImpl implements IEmployeService{
	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l =   LogManager.getLogger(EmployeServiceImpl.class);
	@Override
	public List<Employe> retrieveAllEmployees() { 
		List<Employe> employees = null; 
		try {

			l.info("In Method retrieveAllEmployees : ") ;
			employees = (List<Employe>) employeRepository.findAll();  
			for (Employe employe : employees) {
				l.debug("employe :  "+ employe.getNom());
			} 
			l.info("out of Method retrieveAllEmployees with success");
		}catch (Exception e) {
			l.error("out of methos retrieveAllEmployees with errors:"+ e);
		}

		return employees;
	}
	public Employe addEmploye(Employe e) {
		l.info("In Method addEmploye : ") ;
		Employe e_saved = employeRepository.save(e); 
		l.info("out of Method addEmploye with success : ") ;
		return e_saved; 
	}
	@Override 
	public Employe updateEmploye(Employe e) { 
		l.info("In Method updateEmploye : ") ;
		Employe e_saved = employeRepository.save(e); 
		l.info("In Method updateEmploye : ") ;
		return e_saved; 
	}
	public void deleteEmploye(Long id) {
		l.info("In Method deleteUser : ") ;
		employeRepository.deleteById((long) id); 
		l.info("out of Method deleteEmploye : ") ;
	}

	public Employe retrieveEmploye(Long id) {
		l.info("In Method retrieveEmploye : ") ;
		Employe e =  employeRepository.findById((long) id).get(); 
		l.info("In Method retrieveEmploye : ") ;
		return e; 
	}
	/*@Override
	public void deleteEmploye(String id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Employe retrieveEmploye(String id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
