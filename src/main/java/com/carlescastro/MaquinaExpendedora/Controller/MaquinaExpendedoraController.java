package com.carlescastro.MaquinaExpendedora.Controller;

import com.carlescastro.MaquinaExpendedora.Service.InstruccionesMaquinaExpendedoraService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class MaquinaExpendedoraController {

    private InstruccionesMaquinaExpendedoraService instruccionesMaquinaExpendedoraService;

    @GetMapping("/estado")
    public ResponseEntity<List<String>> obtenerStock(){
        List<String> estadoStock = instruccionesMaquinaExpendedoraService.estadoProductos();
        return ResponseEntity.ok(estadoStock);
    }
}
