package test.testjpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance
@DiscriminatorColumn(name="type")
@DiscriminatorValue("ticket")
public class Ticket implements Serializable{
	private Long ticketId;

	private String libelle;
	
	private List<Employe> employes = new ArrayList<Employe>();

	//private String demandeur;
	
	public Ticket() {
		
	}
	public Ticket(String name) {
		this.libelle = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return ticketId;
	}

	public void setId(Long id) {
		this.ticketId = id;
	}

	public String getName() {
		return libelle;
	}

	public void setName(String name) {
		this.libelle = name;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="AttributionTickets")
	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> Employes) {
		this.employes = Employes;
	}
	
	/*@ManyToOne
	@JoinColumn(name="demandeurId")
	public Utilisateur getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(Utilisateur demandeur) {
		this.demandeur = demandeur;
	}*/

	@Override
	public String toString() {
		return "Ticket [id=" + ticketId + ", libelle=" + libelle +"]";
	}
	
	public String type() {
		return "type";
	}

}
