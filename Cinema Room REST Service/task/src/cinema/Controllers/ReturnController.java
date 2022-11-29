package cinema.Controllers;

import cinema.Controllers.Actions.ReturnTicket;
import cinema.exeptions.WrongToken;

import cinema.items.Seat;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class ReturnController {

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody String token) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode node = mapper.readTree(token);

            Seat seat = ReturnTicket.tryToReturnTicket(node.findValue("token").asText());

            Map<String, Seat> response = new HashMap();

            response.put("returned_ticket",seat);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        } catch (WrongToken e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\n" +
                            "    \"error\": \"Wrong token!\"\n" +
                            "}");
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
