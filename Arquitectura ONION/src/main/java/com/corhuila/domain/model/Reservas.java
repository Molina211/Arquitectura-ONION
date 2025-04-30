package com.corhuila.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reservas {

    private Long id;

    private String tipo_vehiculo;

    private String tipo_servicio;

    private Double precio;

}
