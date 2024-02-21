package test.testjpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bug")
public class TicketBug extends Ticket{
	
	public TicketBug() {
		super();
	}
	
	@Column(insertable=false, updatable=false)
	public String type() {
		return "bug";
	}
}
