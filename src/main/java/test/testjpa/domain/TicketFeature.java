package test.testjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Feature")
public class TicketFeature extends Ticket{
	
	public TicketFeature() {
		super();
		
	}
	
	@Column(insertable=false, updatable=false)
	public String type() {
		return "feature";
	}
}
