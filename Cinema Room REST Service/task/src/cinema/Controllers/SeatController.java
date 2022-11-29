package cinema.Controllers;

import cinema.items.Cinema;
import cinema.mockDB.CinemaMock;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeatController {

    @GetMapping("/seats")
    public Cinema returnSeats() {
        return CinemaMock.getFreeSeats();
    }
}
