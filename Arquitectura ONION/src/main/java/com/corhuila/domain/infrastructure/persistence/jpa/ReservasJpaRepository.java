package com.corhuila.domain.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corhuila.domain.infrastructure.persistence.entity.ReservasEntity;

@Repository
public interface ReservasJpaRepository extends JpaRepository<ReservasEntity, Long> {

}
