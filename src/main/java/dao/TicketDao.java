package dao;

import java.util.List;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Employe;
import test.testjpa.domain.Ticket;

public class TicketDao extends AbstractJpaDao<Long, Ticket>{

	public TicketDao() {
		super(Ticket.class);
	}
	
	public List<Ticket> getAllTickets() {
		return EntityManagerHelper.getEntityManager().createQuery("Select a from Ticket a ", Ticket.class).getResultList();

	}
	
	public Ticket getTicket(Long id) {
		return EntityManagerHelper.getEntityManager().createQuery("Select a from Ticket a where a.id = :id", Ticket.class).setParameter("id", id).getSingleResult();
		
	}
	
	public String getType(Long id) {
		Ticket t = EntityManagerHelper.getEntityManager().createQuery("Select a from Ticket a where a.id = :id", Ticket.class).setParameter("id", id).getSingleResult();
		return t.getClass().toString();
	}
}
