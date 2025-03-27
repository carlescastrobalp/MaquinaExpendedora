package com.carlescastro.MaquinaExpendedora.Service;

import com.carlescastro.MaquinaExpendedora.Repository.RepositoryProductos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

//Es necesario para inicializar las anotaciones de Mockito, sino salta un NullPointerException
@ExtendWith(MockitoExtension.class)
class InstruccionesMaquinaExpendedoraTest {

    @Mock
    RepositoryProductos repositoryProductos;

    @InjectMocks InstruccionesMaquinaExpendedora instruccionesMaquinaExpendedora;

    @Test
    void testInsertarProductos() {
    }

    @Test
    public void testConsumirProducto() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> instruccionesMaquinaExpendedora.consumirProducto("2"));
        assertEquals("Codigo de producto incorrecto", exception.getMessage());
    }
}