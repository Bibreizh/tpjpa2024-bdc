<%@ page import="test.testjpa.domain.Ticket" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tickets</title>
</head>
<body>
    <h1>Tickets</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Libelle</th>
                <th>Type</th>
            </tr>
        </thead>
        <tbody>
            <!-- Iterate over the list of Ticket objects -->
            <c:forEach items="${tickets}" var="ticket">
                <tr>
                    <td>${ticket.getLibelle()}</td>
                    <td>${ticket.type()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <form action="ticketForm.html">
        <input type="submit" value="Create New Ticket">
    </form>
</body>
</html>
