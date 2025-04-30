package com.corhuila.domain.web.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corhuila.domain.application.service.IReservaService;
import com.corhuila.domain.model.Reservas;

@RestController
@RequestMapping("/api")
public class ReservaRestController {

    private final IReservaService reservaService;

    public ReservaRestController(IReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping("/reservas")
    public ResponseEntity<List<Reservas>> getAllReservas() {
        return new ResponseEntity<>(reservaService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/reservas/{id}")
    public ResponseEntity<Reservas> getReservaById(@PathVariable Long id) {
        Reservas reserva = reservaService.findById(id);
        return reserva != null
                ? new ResponseEntity<>(reserva, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/reservas")
    public ResponseEntity<Reservas> crearReserva(@RequestBody Reservas reserva) {
        return new ResponseEntity<>(reservaService.save(reserva), HttpStatus.CREATED);
    }

    @PutMapping("/reservas/{id}")
    public ResponseEntity<Reservas> updateReserva(@PathVariable Long id, @RequestBody Reservas reserva) {
        reserva.setId(id);
        Reservas updatedReserva = reservaService.save(reserva);
        return updatedReserva != null
                ? new ResponseEntity<>(updatedReserva, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reservas/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Long id) {
        reservaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
