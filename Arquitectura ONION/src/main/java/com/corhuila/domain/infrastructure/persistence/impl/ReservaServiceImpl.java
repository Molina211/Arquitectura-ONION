package com.corhuila.domain.infrastructure.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.corhuila.domain.application.service.IReservaService;
import com.corhuila.domain.model.Reservas;
import com.corhuila.domain.repository.ReservaRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservaServiceImpl implements IReservaService {

    private final ReservaRepository reservaRepository;

    @Override
    public List<Reservas> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Reservas findById(Long id) {
        Optional<Reservas> reservas = reservaRepository.findById(id);
        return reservas.orElse(null);
    }

    @Override
    public Reservas save(Reservas reservas) {
        return reservaRepository.save(reservas);
    }

    @Override
    public void update(Reservas reserva, Long id) {
        Optional<Reservas> reservaActual = reservaRepository.findById(id);
        if (reservaActual.isPresent()) {
            Reservas res = reservaActual.get();
            res.setTipo_vehiculo(reserva.getTipo_vehiculo());
            res.setTipo_servicio(reserva.getTipo_servicio());
            res.setPrecio(reserva.getPrecio());
            reservaRepository.save(res);
        } else {
            System.out.println("Reserva no encontrada");
        }
    }

    @Override
    public void delete(Long id) {
        reservaRepository.delete(id);
    }

}
