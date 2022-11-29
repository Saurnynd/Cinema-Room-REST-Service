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

import static cinema.Config.MESSAGE_ALREADY_PURCHASE;
import static cinema.Config.MESSAGE_OUT_OF_BOUNDS;

@RestController
public class PurchaseController {

    @PostMapping("/purchase")
    public ResponseEntity<?> returnSeats(@RequestBody Seat seat) {
        try {

            Ticket ticket = BuySeat.tryToBuySeat(seat);

            return ResponseEntity.status(HttpStatus.OK).body(ticket);

        } catch (SeatOutOfBounds e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(MESSAGE_OUT_OF_BOUNDS);
        } catch (SeatAlreadyRepurchased e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(MESSAGE_ALREADY_PURCHASE);
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }

    }
}
