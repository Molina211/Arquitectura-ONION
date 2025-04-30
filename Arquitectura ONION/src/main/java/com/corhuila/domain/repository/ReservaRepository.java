package com.corhuila.domain.repository;

import java.util.List;
import java.util.Optional;

import com.corhuila.domain.model.Reservas;

public interface ReservaRepository {

    public List<Reservas> findAll();

    public Optional<Reservas> findById(Long id);

    public Reservas save(Reservas reserva);

    public void update(Reservas reserva, Long id);

    public void delete(Long id);

}
