package com.corhuila.domain.application.service;

import java.util.List;

import com.corhuila.domain.model.Reservas;

public interface IReservaService {

    public List<Reservas> findAll();

    public Reservas findById(Long id);

    public Reservas save(Reservas reserva);

    public void update(Reservas reserva, Long id);

    public void delete(Long id);

}
