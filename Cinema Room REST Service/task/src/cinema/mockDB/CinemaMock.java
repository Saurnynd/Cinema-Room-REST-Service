package cinema.mockDB;

import cinema.items.Cinema;
import cinema.items.Seat;


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
