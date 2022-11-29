package cinema.items;

import java.util.UUID;

public class Ticket {
    private UUID token;
    private Seat ticket;


    public Ticket(Seat seat){
        this.ticket = new Seat(seat.getRow(), seat.getColumn());
        this.token = UUID.randomUUID();
    }
    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public void setTicket(Seat ticket) {
        this.ticket = ticket;
    }

    public Seat getTicket() {
        return ticket;
    }
}
