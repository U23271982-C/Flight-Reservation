package cont.com.controllers;

import cont.com.dto.ReservationDTO;
import cont.com.service.ReservationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@Validated
@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private ReservationService service;

     @Autowired
    public ReservationController(ReservationService service) {
        this.service = service;
    }

    // Muestra todas las reservaciones
    @GetMapping
    public ResponseEntity<List<ReservationDTO>> getReservation(){
        List<ReservationDTO> response = service.getReservations();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Muestra solo la reservación por la id
    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationId(@PathVariable Long id){
        ReservationDTO response = service.getReservationById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Guarda una reserva, dando el cuerpo de la reserva
    // El id se autocomopleta en la bd
    @PostMapping
    public ResponseEntity<ReservationDTO> save(@Valid @RequestBody ReservationDTO reservationBody ){
        ReservationDTO response = service.save(reservationBody);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    // Actualiza la reserva a partir de un id
    @PutMapping("/{id}")
    public ResponseEntity<ReservationDTO> update
            (@Min(1) @PathVariable Long id, @Valid @RequestBody ReservationDTO reservationBody ){

         ReservationDTO response = service.update(id, reservationBody);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    // Borra la reserva a partir de un id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@Min(1) @PathVariable Long id){
         service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
