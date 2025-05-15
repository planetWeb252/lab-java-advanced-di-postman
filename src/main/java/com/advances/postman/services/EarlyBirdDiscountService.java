package com.advances.postman.services;

import com.advances.postman.DTO.RequestDTO;
import com.advances.postman.exceptions.FechaInvalidaException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class EarlyBirdDiscountService {


    //Logica de discount
    public ResponseEntity<?> earlyBirdDiscount(RequestDTO dto) {
        // fecha de evento no anterior a hoy
        if (dto.getEventDate().isBefore(LocalDate.now())) {
            throw new FechaInvalidaException("La Fecha del evento " + dto.getEventDate() + " no puede ser anterior a " +
                    "hoy");
        }
        // fecha de reserva no anterior a hoy
        if (dto.getBookingDate().isBefore(LocalDate.now())) {
            throw new FechaInvalidaException("La Fecha de reserva " + dto.getBookingDate() + " no puede ser anterior a" +
                    " hoy");
        }
        // que la fecha de reserva no se posterior a la fecha del evento
        if (dto.getBookingDate().isAfter(dto.getEventDate())) {
            throw new FechaInvalidaException("La fecha de reserva: " + dto.getBookingDate() + " no puede ser anterior a " +
                    "la fecha de evento :" + dto.getEventDate());
        }
        // que no haya una diferencia entre las dos fechas a 30 dias
        long diferenciaDias = ChronoUnit.DAYS.between( dto.getBookingDate(),dto.getEventDate());
        if (diferenciaDias > 30) {
            return ResponseEntity.ok("Descuento por reserva anticipada aplicado: 15%");
        }
        return ResponseEntity.ok("Reserva demasiado tardia para descuento, el descuento no sera aplicado");


    }
}
