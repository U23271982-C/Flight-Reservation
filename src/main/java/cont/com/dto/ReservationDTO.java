package cont.com.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class ReservationDTO {
    private Long id;
    @Valid // Validamos que los pasajeros sean válidos, ya que sin esto solo valida la
            // lista de pasajeros y no los objetos de la lista
    @NotEmpty(message = "You need at last one passenger") // Validamos que la lista de pasajeros no esté vacía
    private List<PassengerDTO> passengers;
    @Valid // Validamos que el itinerario sea válido
    private ItineraryDTO itinerary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<PassengerDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDTO> passengers) {
        this.passengers = passengers;
    }

    public ItineraryDTO getItinerary() {
        return itinerary;
    }

    public void setItinerary(ItineraryDTO itinerary) {
        this.itinerary = itinerary;
    }
}
