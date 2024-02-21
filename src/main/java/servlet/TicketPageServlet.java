package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.testjpa.domain.Ticket;

@WebServlet(name = "ticketpage", urlPatterns = {"/TicketPage"})
public class TicketPageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch Ticket information (dummy data for demonstration)
    	TicketDao Tdao = new TicketDao();
        List<Ticket> tickets = Tdao.getAllTickets();
        System.out.println(tickets.size());
        
        // Set the list of tickets as a request attribute
        request.setAttribute("tickets", tickets);

        // Forward the request to the JSP page
        request.getRequestDispatcher("/ticketPage.jsp").forward(request, response);
    }
}

