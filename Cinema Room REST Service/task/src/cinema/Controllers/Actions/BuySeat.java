package cinema.Controllers.Actions;

import cinema.exeptions.SeatAlreadyRepurchased;
import cinema.exeptions.SeatOutOfBounds;
import cinema.items.Seat;
import cinema.items.Ticket;
import cinema.mockDB.CinemaMock;
import cinema.mockDB.TicketsMock;
import org.springframework.http.HttpStatus;

public class BuySeat {

    public static Ticket tryToBuySeat(Seat selectedSeat) throws SeatAlreadyRepurchased, SeatOutOfBounds {

        tryCheckSeatRange(selectedSeat);

        tryFindSeat(selectedSeat);

        CinemaMock.deleteSeat(selectedSeat);

        Ticket ticket = new Ticket(selectedSeat);

        TicketsMock.addTicket(ticket);

        return ticket;
    }

    private static void tryCheckSeatRange(Seat seat) {
        if (seat.getRow() >= CinemaMock.getTotalRows() ||
                seat.getColumn() >= CinemaMock.getTotalColumns() ||
                seat.getRow() <= 0 ||
                seat.getColumn() <= 0) {
            throw new SeatOutOfBounds(HttpStatus.BAD_REQUEST,
                    "The number of a row or a column is out of bounds!");
        }
    }

    private static void tryFindSeat(Seat desiredSeat) {
        var temp  = CinemaMock.getFreeSeats().getAvailable_seats();
        if (temp.stream()
                .filter(seat -> seat.equals(desiredSeat))
                .findAny()
                .isEmpty()) {
            throw new SeatAlreadyRepurchased(HttpStatus.BAD_REQUEST,
                    "The ticket has been already purchased!");
        }
    }
}
