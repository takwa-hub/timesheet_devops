package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	UserRepository userRepository;

	private static final Logger l =   LogManager.getLogger(UserServiceImpl.class);;
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In Method retrieveAllUsers : ") ;
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				   l.debug("user :  "+ user.getLastName());
			} 
			l.info("out of Method retrieveAllUsers with success");
		}catch (Exception e) {
			 l.error("out of methos retrieveAllUsers with errors:"+ e);
		}

		return users;
	}


	public User addUser(User u) {
		l.info("In Method addUser : ") ;
		User u_saved = userRepository.save(u); 
		l.info("out of Method addUser with success : ") ;
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		l.info("In Method updateUser : ") ;
		User u_saved = userRepository.save(u); 
		l.info("In Method updateUser : ") ;
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		l.info("In Method deleteUser : ") ;
		userRepository.deleteById(Long.parseLong(id)); 
		l.info("out of Method deleteUser : ") ;
	}

	@Override
	public User retrieveUser(String id) {
		User u = null;
		try {
		l.info("In Method retrieveUser : ") ;
		 u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("In Method retrieveUser : ") ;
		}catch (Exception e) {
			l.error("error in retrieveUser():" + e);
		}
		return u; 
	}


	/*@Override
	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public User retrieveUser(String id) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
