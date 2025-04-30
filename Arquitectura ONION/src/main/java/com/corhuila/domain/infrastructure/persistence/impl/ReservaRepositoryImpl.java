package com.corhuila.domain.infrastructure.persistence.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.corhuila.domain.infrastructure.persistence.entity.ReservasEntity;
import com.corhuila.domain.infrastructure.persistence.jpa.ReservasJpaRepository;
import com.corhuila.domain.infrastructure.persistence.mapper.ReservasMapper;
import com.corhuila.domain.model.Reservas;
import com.corhuila.domain.repository.ReservaRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ReservaRepositoryImpl implements ReservaRepository {

    private final ReservasJpaRepository jpaRepo;

    @Override
    public List<Reservas> findAll() {
        return jpaRepo.findAll().stream()
                .map(ReservasMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Reservas> findById(Long id) {
        return jpaRepo.findById(id)
                .map(ReservasMapper::toDomain);
    }

    @Override
    public Reservas save(Reservas reservas) {
        ReservasEntity reserva = ReservasMapper.toEntity(reservas);
        return ReservasMapper.toDomain(jpaRepo.save(reserva));
    }

    @Override
    public void update(Reservas reserva, Long id) {
        Optional<ReservasEntity> reservaActual = jpaRepo.findById(id);
        if (reservaActual.isPresent()) {
            ReservasEntity res = reservaActual.get();
            res.setTipo_vehiculo(reserva.getTipo_vehiculo());
            res.setTipo_servicio(reserva.getTipo_servicio());
            res.setPrecio(reserva.getPrecio());
            jpaRepo.save(res);
        } else {
            System.out.println("Reserva no encontrada");
        }
    }

    @Override
    public void delete(Long id) {
        jpaRepo.deleteById(id);
    }

}
