package cinema.mockDB;

import cinema.items.Cinema;
import cinema.items.Seat;
import cinema.items.Ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CinemaMock {
    private static final Cinema cinema = new Cinema(9, 9);


    public static Cinema getFreeSeats() {
        return cinema;
    }

    public static int getTotalRows() {
        return cinema.getTotal_rows();
    }

    public static int getTotalColumns() {
        return cinema.getTotal_columns();
    }

    public static void deleteSeat(Seat seat) {
        cinema.deleteSeat(seat);
    }

    public static void addSeat(Seat seat) {
        cinema.addSeat(seat);
    }


}
