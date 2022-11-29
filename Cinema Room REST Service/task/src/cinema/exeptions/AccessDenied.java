package cinema.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AccessDenied extends ResponseStatusException {

    public AccessDenied(HttpStatus status, String reason) {
        super(status, reason);
    }
}