package com.advances.postman.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    @NotNull(message = "la fecha del evento no puede ser vacia o nula")
    private LocalDate eventDate;
    @NotNull(message = "la fecha de la reserva no puede ser vacia o nula")
    private LocalDate bookingDate;

}
