package com.corhuila.domain.infrastructure.persistence.mapper;

import com.corhuila.domain.infrastructure.persistence.entity.ReservasEntity;
import com.corhuila.domain.model.Reservas;

public class ReservasMapper {

    public static Reservas toDomain(ReservasEntity entidad) {
        return new Reservas(
                entidad.getId(),
                entidad.getTipo_vehiculo(),
                entidad.getTipo_servicio(),
                entidad.getPrecio());
    }

    public static ReservasEntity toEntity(Reservas doReserva) {
        return new ReservasEntity(
                doReserva.getId(),
                doReserva.getTipo_vehiculo(),
                doReserva.getTipo_servicio(),
                doReserva.getPrecio());
    }
}
