package test.testjpa.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Utilisateur{
	protected Long idUser;

	protected String name;
	
	
	private String mail;
	private List<Ticket> tickets = new ArrayList<Ticket>();

	
	public Utilisateur() {
		
	}
	
	public Utilisateur(String name, String mail) {
		this.name = name;
		this.mail = mail;
	}
	@Id
	@GeneratedValue
	public Long getId() {
		return idUser;
	}

	public void setId(Long id) {
		this.idUser = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	/*@OneToMany(mappedBy = "demandeur", cascade = CascadeType.PERSIST)
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}*/
}
