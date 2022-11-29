package cinema.Controllers.Actions;

import cinema.exeptions.AccessDenied;
import cinema.items.Seat;
import cinema.items.Ticket;
import cinema.mockDB.CinemaMock;
import cinema.mockDB.TicketsMock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class GetStats {
    public static Map<String, Integer> stats(String password) throws AccessDenied{
        checkAccess(password);

        Map<String, Integer> response = new HashMap();

        response.put("current_income",getIncome());
        response.put("number_of_available_seats",getNumbOfAvailableSeats());
        response.put("number_of_purchased_tickets",getNumbOfPurchasedSeats());

        return response;

    }

    private static Integer getNumbOfPurchasedSeats() {
        return TicketsMock.getSoldTickets().size();
    }

    private static Integer getNumbOfAvailableSeats() {
        return CinemaMock.getFreeSeats().getAvailable_seats().size();
    }

    private static Integer getIncome() {
        return TicketsMock.getSoldTickets().stream()
                .mapToInt(el -> el.getTicket().getPrice())
                .sum();
    }

    private static void checkAccess(String password) throws AccessDenied {
        if(!"super_secret".equals(password))
            throw new AccessDenied(HttpStatus.UNAUTHORIZED,"The password is wrong!");
    }
}
