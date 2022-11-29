package cinema.Controllers.Actions;

import cinema.exeptions.WrongToken;
import cinema.items.Seat;
import cinema.items.Ticket;
import cinema.mockDB.CinemaMock;
import cinema.mockDB.TicketsMock;
import org.springframework.http.HttpStatus;

public class ReturnTicket {

    public static Seat tryToReturnTicket(String token) throws WrongToken {

        Ticket ticket = tryFindTicket(token);

        TicketsMock.deleteTicket(token);

        CinemaMock.addSeat(ticket.getTicket());

        return ticket.getTicket();
    }

    private static Ticket tryFindTicket(String token) throws WrongToken {
        var list = TicketsMock.getSoldTickets();
        var result = list.stream()
                .filter(el -> el.getToken().toString().equals(token))
                .findAny();
        if(result.isEmpty()){
            throw new WrongToken(HttpStatus.BAD_REQUEST,"Wrong token!");
        }
        return result.get();
    }

}
