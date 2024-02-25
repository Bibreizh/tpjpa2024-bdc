package dao;

import java.util.List;

import jpa.EntityManagerHelper;
import test.testjpa.domain.Employe;
import test.testjpa.domain.Ticket;

public class EmployeDao extends AbstractJpaDao<Long, Employe>{

	public EmployeDao() {
		super(Employe.class);
	}
	
	public Boolean userExist(String name) {
		return EntityManagerHelper.getEntityManager().createQuery("Select a from Employe a where a.name = :name", Employe.class).setParameter("name", name).getResultList().size() > 0;
		//return EntityManagerHelper.getEntityManager().createQuery("Select e.name from Employe as e", Employe.class).getResultList().size() > 0;

	}
	
	public List<Ticket> getTicketAttribueToEmploye(Employe emp){
		return EntityManagerHelper.getEntityManager().createQuery("Select TICKETS_ID from AttributionTickets where EMPLOYE_ID = :id ").setParameter("id", emp.getId()).getResultList();
	}
}
