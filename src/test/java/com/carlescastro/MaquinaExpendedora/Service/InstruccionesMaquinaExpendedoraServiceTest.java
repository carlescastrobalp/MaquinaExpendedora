package com.carlescastro.MaquinaExpendedora.Service;

import com.carlescastro.MaquinaExpendedora.Repository.RepositoryProductos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

//Es necesario para inicializar las anotaciones de Mockito, sino salta un NullPointerException
@ExtendWith(MockitoExtension.class)
class InstruccionesMaquinaExpendedoraServiceTest {

    @Mock
    RepositoryProductos repositoryProductos;

    @InjectMocks
    InstruccionesMaquinaExpendedoraService instruccionesMaquinaExpendedoraService;

    @Test
    void testInsertarProductos() {
    }

    @Test
    public void testConsumirProducto() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> instruccionesMaquinaExpendedoraService.consumirProducto("2"));
        assertEquals("Codigo de producto incorrecto", exception.getMessage());
    }
}