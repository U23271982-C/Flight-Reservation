package cont.com.controllers;

import cont.com.dto.ReservationDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    // Muestra todas las reservaciones
    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getReservation(){
        List<ReservationDTO> response = new ArrayList<>();
        response.add(new ReservationDTO());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Muestra solo la reservación por la id
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationId(@PathVariable Long id){
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Guarda una reserva, dando el cuerpo de la reserva
    // El id se autocomopleta en la bd
    @PostMapping
    public ResponseEntity<ReservationDTO> save(@RequestBody ReservationDTO reservationBody ){
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Actualiza la reserva a partir de un id
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> update
            (@PathVariable Long id, @RequestBody ReservationDTO reservationBody ){
        ReservationDTO response = new ReservationDTO();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Borra la reserva a partir de un id
    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationDTO> delete(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
