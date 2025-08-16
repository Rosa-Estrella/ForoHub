package com.alura.foro.controller;

import com.alura.foro.dto.*;
import com.alura.foro.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
    private final TopicoService service;

    public TopicoController(TopicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<DatosRespuestaTopico> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public DatosRespuestaTopico obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> crear(@RequestBody @Valid DatosRegistroTopico datos) {
        return ResponseEntity.ok(service.crear(datos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> actualizar(@PathVariable Long id,
                                                           @RequestBody @Valid DatosActualizarTopico datos) {
        return ResponseEntity.ok(service.actualizar(id, datos));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
