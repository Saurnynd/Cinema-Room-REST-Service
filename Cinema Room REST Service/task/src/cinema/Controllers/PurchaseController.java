package cinema.Controllers;

import cinema.Controllers.Actions.BuySeat;
import cinema.exeptions.SeatAlreadyRepurchased;
import cinema.exeptions.SeatOutOfBounds;
import cinema.items.Seat;
import cinema.items.Ticket;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PurchaseController {

    @PostMapping("/purchase")
    public ResponseEntity<?> returnSeats(@RequestBody Seat seat) {
        try {

            Ticket ticket = BuySeat.tryToBuySeat(seat);

            return ResponseEntity.status(HttpStatus.OK).body(ticket);

        } catch (SeatOutOfBounds e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\n" +
                            "    \"error\": \"The number of a row or a column is out of bounds!\"\n" +
                            "}");
        } catch (SeatAlreadyRepurchased e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\n" +
                            "    \"error\": \"The ticket has been already purchased!\"\n" +
                            "}");
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
}
