package com.carlescastro.MaquinaExpendedora.Service;

import com.carlescastro.MaquinaExpendedora.Repository.RepositoryProductos;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class InstruccionesMaquinaExpendedoraTest {

    @Mock
    RepositoryProductos repositoryProductos;

    @InjectMocks InstruccionesMaquinaExpendedora instruccionesMaquinaExpendedora;

    @Test
    void insertarProductos() {
    }

    @Test
    public void consumirProducto() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> instruccionesMaquinaExpendedora.consumirProducto("2"));
        assertEquals("Codigo de producto incorrecto", exception.getMessage());
    }
}