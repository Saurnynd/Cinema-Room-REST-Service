package cinema.items;


import java.util.ArrayList;
import java.util.List;

public class Cinema {
    int total_rows;
    int total_columns;
    List<Seat> available_seats;

    public Cinema() {
    }

    public Cinema(int total_rows, int total_columns) {
        this.total_columns = total_columns;
        this.total_rows = total_rows;
        this.available_seats = new ArrayList<>();
        for (int i = 1; i <= total_rows; i++) {
            for (int j = 1; j <= total_columns; j++) {
                available_seats.add(new Seat(i, j));
            }
        }
    }

    public void deleteSeat(Seat seat) {
        available_seats = available_seats.stream().filter(el -> !el.equals(seat)).toList();
    }
    public void addSeat(final Seat seat) {
        var list = new ArrayList<>(available_seats);
        list.add(seat);
        available_seats = list;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public List<Seat> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Seat> available_seats) {
        this.available_seats = available_seats;
    }
}
