package test.testjpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Employe implements Serializable{
	private Long id;

	private String name;
	
	private Departement departement;
	
	private List<Ticket> tickets = new ArrayList<Ticket>();


	public Employe() {
		
	}
	public Employe(String name, Departement departement) {
		this.name = name;
		this.departement = departement;
	}

	public Employe(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToOne
	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		String msg = "Employee [id=" + id + ", name=" + name + ", Departement="
				+ departement.getName() + ", liste des tickets= ";
		for(Ticket ticket : tickets) {
			msg+= ticket.toString() + ",\n";
		}
		msg+= "]";
		return msg;
	}

}

