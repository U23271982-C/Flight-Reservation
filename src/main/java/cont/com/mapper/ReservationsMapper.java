package cont.com.mapper;

import org.springframework.core.convert.converter.Converter;
import cont.com.dto.ReservationDTO;
import cont.com.model.Reservation;

import java.util.List;

public interface ReservationsMapper extends Converter<List<Reservation>, List<ReservationDTO>> {
    @Override
    List<ReservationDTO> convert(List<Reservation> source);
}
