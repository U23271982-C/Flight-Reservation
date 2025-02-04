package cont.com.mapper;

import org.springframework.core.convert.converter.Converter;
import cont.com.dto.ReservationDTO;
import cont.com.model.Reservation;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
// Convierte de Reservation a ReservationDTO
public interface ReservationMapper extends Converter<Reservation, ReservationDTO> {
    @Override
    ReservationDTO convert(Reservation source);
}
