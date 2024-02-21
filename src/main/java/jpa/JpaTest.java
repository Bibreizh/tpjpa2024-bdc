package jpa;


import java.util.List;

import dao.EmployeDao;
import dao.TicketDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import test.testjpa.domain.Employe;
import test.testjpa.domain.Ticket;
import test.testjpa.domain.TicketBug;
import test.testjpa.domain.TicketFeature;
import test.testjpa.domain.Utilisateur;
import test.testjpa.domain.Departement;

public class JpaTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TicketDao Tdao = new TicketDao();
		EmployeDao Edao = new EmployeDao();
		Employe emp = new Employe();
		emp.setName("Test Employe");
		if(!Edao.userExist(emp.getName())) {
			Edao.save(emp);
		}
		Ticket ticket = new TicketFeature();
		ticket.setName("Test ticket Feature DAO");
		Tdao.save(ticket);
		List<Ticket> listeT = emp.getTickets();
		listeT.add(ticket);
		emp.setTickets(listeT);
		Edao.update(emp);
		Ticket ticket2 = Tdao.getTicket((long) 202);
		System.out.println(ticket2.type());
		/*List<Ticket> lTicket = Edao.getTicketAttribueToEmploye(emp);
		System.out.println(lTicket.size());
		try {
			//test.createEmployees();
			//test.createTicket();
			//test.createUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}
	
	
	
	
	
	
	/*private void createUsers() {
		int numOfEmployees = manager.createQuery("SELECT a FROM Utilisateur a", Utilisateur.class).getResultList().size();
		if (numOfEmployees == 0) {
			manager.persist(new Utilisateur("Test user","test@mail.fr"));
		}
	}

	private void createEmployees() {
		int numOfEmployees = manager.createQuery("SELECT a FROM Employe a", Employe.class).getResultList().size();
		if (numOfEmployees == 0) {
			Departement department = new Departement("java");
			manager.persist(department);
			manager.persist(new Employe("Jakab Gipsz",department));
			manager.persist(new Employe("Captain Nemo",department));
		}
	}

	private void listEmployees() {
		List<Employe> resultList = manager.createQuery("SELECT a FROM Employe a", Employe.class).getResultList();
		System.out.println("num of employes:" + resultList.size());
		for (Employe next : resultList) {
			System.out.println("next employee: " + next);
		}
	}
	
	private void createTicket() {
		List<Employe> resultList = manager.createQuery("Select a From Employe a", Employe.class).getResultList();
		Ticket ticket = new Ticket("Problème java");
		for (Employe next : resultList) {
			
			List<Ticket> tickets = next.getTickets();
			tickets.add(ticket);
			next.setTickets(tickets);
		}
		
	}*/
}
