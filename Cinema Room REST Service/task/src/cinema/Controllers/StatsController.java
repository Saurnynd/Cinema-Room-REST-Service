package cinema.Controllers;

import cinema.Config;
import cinema.Controllers.Actions.GetStats;
import cinema.exeptions.AccessDenied;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class StatsController {

    @PostMapping("/stats")
    @ResponseBody
    public ResponseEntity<?> returnStats(@RequestParam(name = "password", required = false) String password) {
        try{
            var response = GetStats.stats(password);

            return ResponseEntity.status(HttpStatus.OK).body(response);
        }catch (AccessDenied e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Config.MESSAGE_WRONG_PASSWORD);
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Config.MESSAGE_WRONG_PASSWORD);
        }
    }


}
