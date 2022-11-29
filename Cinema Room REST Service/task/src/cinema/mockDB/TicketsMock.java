package cinema.mockDB;

import cinema.items.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TicketsMock {
    private static List<Ticket> tickets = new ArrayList<>();

    public static void addTicket(Ticket ticket) {
        var list = new ArrayList<>(tickets);
        list.add(ticket);
        tickets = list;
    }

    public static List<Ticket> getSoldTickets() {
        return tickets;
    }

    public static void deleteTicket(String token) {
        tickets = tickets.stream().filter(el -> !el.getToken().toString().equals(token)).toList();
    }
}
