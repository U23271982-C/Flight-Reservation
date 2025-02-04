package cont.com.service;

import cont.com.dto.ReservationDTO;
import cont.com.exception.ExceptionApp;
import cont.com.model.Reservation;
import cont.com.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationRepository repository;

    private ConversionService conversionService;

    @Autowired
    public ReservationService(ReservationRepository repository,
                              ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    public List<ReservationDTO> getReservations() {
        return  conversionService.convert(repository.getReservations(), List.class);
    }

    public ReservationDTO getReservationById(Long id) {
        Optional<Reservation> result = repository.getReservationById(id);
        if(result.isEmpty()) {
            throw new ExceptionApp("Not exist");
        }
        return conversionService.convert(result.get(), ReservationDTO.class);
    }

    public ReservationDTO save(ReservationDTO reservation) {
        // Validar que no exista la reserva que se quiere guardar
        if(Objects.nonNull(reservation.getId())) {
            throw new ExceptionApp("Duplicate it");
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.save(Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public ReservationDTO update(Long id, ReservationDTO reservation) {
        if(getReservationById(id) == null) {
            throw new ExceptionApp("Not exist");
        }

        Reservation transformed = conversionService.convert(reservation, Reservation.class);
        Reservation result = repository.update(id, Objects.requireNonNull(transformed));
        return conversionService.convert(result, ReservationDTO.class);
    }

    public void delete(Long id) {
        if(getReservationById(id) == null) {
            throw new ExceptionApp("Not exist");
        }

        repository.delete(id);
    }
}
