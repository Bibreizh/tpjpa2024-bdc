package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import dao.TicketDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.testjpa.domain.Ticket;
import test.testjpa.domain.TicketBug;
import test.testjpa.domain.TicketFeature;

@WebServlet(name = "ticketinfo", urlPatterns = {"/TicketInfo"})
public class TicketServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Ticket crée :</h1>");
        out.println("<ul>");
        out.println("<li>Libelle: " + request.getParameter("libelle") + "</li>");
        out.println("<li>Type: " + request.getParameter("type") + "</li>");
        out.println("</ul>");
        out.println("    <form action=\"ticketPage.html\">"
		+ "        <input type=\"submit\" value=\"voir la liste des tickets\">"
		+ "    </form>");
        out.println("</body></html>");
        
        TicketDao Tdao = new TicketDao();
        Ticket t = new Ticket();
        if(request.getParameter("type").equals("Bug")) {
        	t = new TicketBug();
        }else {
        	t = new TicketFeature();
        }
        t.setName(request.getParameter("libelle"));
        Tdao.save(t);
    }
}
