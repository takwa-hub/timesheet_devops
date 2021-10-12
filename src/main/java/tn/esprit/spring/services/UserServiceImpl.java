package tn.esprit.spring.services;

import java.util.List;
//import java.util.logging.Logger;

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

	private static final Logger l =  (Logger) LogManager.getLogger(UserServiceImpl.class);;
	@Override
	public List<User> retrieveAllUsers() { 
		List<User> users = null; 
		try {
	
			l.info("In Method retrieveAllUsers : ") ;
			users = (List<User>) userRepository.findAll();  
			for (User user : users) {
				// TODO Log à ajouter pour affiher chaque user dans les logs   
				   l.debug("user :  "+ user.getLastName());
			} 
			// TODO Log à ajouter à la fin de la méthode 
			l.info("out of Method retrieveAllUsers with success");
		}catch (Exception e) {
			// TODO Log à ajouter pour gérer les erreurs 
			((org.apache.logging.log4j.Logger) l).error("out of methos retrieveAllUsers with errors:"+ e);
		}

		return users;
	}


	public User addUser(User u) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In Method addUser : ") ;
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		l.info("out of Method addUser with success : ") ;
		return u_saved; 
	}

	@Override 
	public User updateUser(User u) { 
		// TODO Log à ajouter en début de la méthode 
		User u_saved = userRepository.save(u); 
		// TODO Log à ajouter à la fin de la méthode 
		return u_saved; 
	}

	@Override
	public void deleteUser(String id) {
		// TODO Log à ajouter en début de la méthode 
		l.info("In Method deleteUser : ") ;
		userRepository.deleteById(Long.parseLong(id)); 
		// TODO Log à ajouter à la fin de la méthode
		l.info("out of Method deleteUser : ") ;
	}

	@Override
	public User retrieveUser(String id) {
		// TODO Log à ajouter en début de la méthode
		l.info("In Method retrieveUser : ") ;
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		User u =  userRepository.findById(Long.parseLong(id)).get(); 
		// TODO Log à ajouter à la fin de la méthode
		l.info("In Method retrieveUser : ") ;
		return u; 
	}

}
