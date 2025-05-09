package com.corhuila.pulidorojo.domain.infrastructure.persistence.impl;

import com.corhuila.domain.infrastructure.persistence.impl.ReservaServiceImpl;
import com.corhuila.domain.model.Reservas;
import com.corhuila.domain.repository.ReservaRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReservaServiceImplTest {

    @Mock
    private ReservaRepository reservaRepository;

    @InjectMocks
    private ReservaServiceImpl reservaService;

    private Reservas reserva;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reserva = new Reservas();
        reserva.setId(1L);
        reserva.setTipo_vehiculo("Carro");
        reserva.setTipo_servicio("Lavado");
        reserva.setPrecio(BigDecimal.valueOf(25000).doubleValue());
    }

    @Test
    void testFindAll() {
        when(reservaRepository.findAll()).thenReturn(List.of(reserva));

        List<Reservas> resultado = reservaService.findAll();

        assertEquals(1, resultado.size());
        verify(reservaRepository, times(1)).findAll();
    }

    @Test
    void testFindByIdEncontrado() {
        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));

        Reservas resultado = reservaService.findById(1L);

        assertNotNull(resultado);
        assertEquals("Carro", resultado.getTipo_vehiculo());
    }

    @Test
    void testFindByIdNoEncontrado() {
        when(reservaRepository.findById(99L)).thenReturn(Optional.empty());

        Reservas resultado = reservaService.findById(99L);

        assertNull(resultado);
    }

    @Test
    void testSave() {
        when(reservaRepository.save(reserva)).thenReturn(reserva);

        Reservas resultado = reservaService.save(reserva);

        assertNotNull(resultado);
        assertEquals("Lavado", resultado.getTipo_servicio());
    }

    @Test
    void testUpdateConReservaExistente() {
        Reservas nueva = new Reservas();
        nueva.setTipo_vehiculo("Moto");
        nueva.setTipo_servicio("Polichado");
        nueva.setPrecio(30000.0);

        when(reservaRepository.findById(1L)).thenReturn(Optional.of(reserva));
        when(reservaRepository.save(any())).thenReturn(reserva);

        reservaService.update(nueva, 1L);

        verify(reservaRepository).save(argThat(actualizada -> actualizada.getTipo_vehiculo().equals("Moto") &&
                actualizada.getTipo_servicio().equals("Polichado") &&
                actualizada.getPrecio() == 30000.0));
    }

    @Test
    void testDelete() {
        reservaService.delete(1L);
        verify(reservaRepository, times(1)).delete(1L);
    }
}
