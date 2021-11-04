//package tn.esprit.spring.entities;

//public class Employe {
	package tn.esprit.spring.entities;

	import java.io.Serializable;
	import java.util.List;

	import javax.persistence.Entity;
	import javax.persistence.EnumType;
	import javax.persistence.Enumerated;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.ManyToMany;
	import javax.persistence.OneToOne;

	import com.fasterxml.jackson.annotation.JsonIgnore;


	@Entity
	public class Employe implements Serializable {
		
		private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		//@SequenceGenerator(name="seq")
		private Long id;
		
		private String prenom;
		

		private String nom;
			
		//@Column(unique=true)
		//@Pattern(regex=".+\@.+\..+")
		private String email;

		private String password;
		
		private boolean actif;
		
		@Enumerated(EnumType.STRING)
		//@NotNull
		private Role role;
		
		//@JsonBackReference  
		@JsonIgnore
		@ManyToMany(mappedBy="employes" )
		//@NotNull
		private List<Departement> departements;
		
		@OneToOne
		private Contrat contrat; 
		
		public Employe() {
			super();
		}
		
			
		public Employe(long id, String prenom, String nom, String email, String password, boolean actif, Role role) {
			super();
			System.out.println("test"); 
			this.id = id;
			this.setPrenom(prenom);
			this.setNom(nom);
			this.setEmail(email);
			this.setPassword(password);
			this.setActif(actif);
			this.role = role;
		}


		public String getPrenom() {
			return prenom;
		}


		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}


		public String getNom() {
			return nom;
		}


		public void setNom(String nom) {
			this.nom = nom;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public boolean isActif() {
			return actif;
		}


		public void setActif(boolean actif) {
			this.actif = actif;
		}
		
	}