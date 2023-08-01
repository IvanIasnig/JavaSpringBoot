package ivaniasnig.esMartedi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrenotazioneController {

    @GetMapping("/booking-rules")
    public ResponseEntity<String> getBookingRules(@RequestParam("lang") String lang) {
        String rules;

        switch (lang) {
            case "it":
                rules = "Le regole per la prenotazione sono: rispondere male al receptionist";
                break;
            case "en":
                rules = "The rules for booking are: rispons mals tu de resepscionist";
                break;
            default:
                return new ResponseEntity<>("Unsupported language", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(rules, HttpStatus.OK);
    }
}



