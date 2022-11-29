package cinema.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class SeatOutOfBounds extends ResponseStatusException {

    public SeatOutOfBounds(HttpStatus status, String reason) {
        super(status, reason);
    }
}
