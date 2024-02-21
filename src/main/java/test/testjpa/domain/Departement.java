package test.testjpa.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Departement implements Serializable{

	private Long departementId;

	private String name;

	private List<Employe> Employes = new ArrayList<Employe>();


	public Departement() {
		
	}
	public Departement(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return departementId;
	}

	public void setId(Long id) {
		this.departementId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "departement", cascade = CascadeType.PERSIST)
	public List<Employe> getEmployes() {
		return Employes;
	}

	public void setEmployes(List<Employe> Employes) {
		this.Employes = Employes;
	}
}


