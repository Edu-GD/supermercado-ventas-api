package com.example.supermercado_ventas_api.controllers;

import com.example.supermercado_ventas_api.models.Sucursal;
import com.example.supermercado_ventas_api.services.SucursalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sucursales")
@RequiredArgsConstructor
@Tag(name = "sucursales", description = "Gestión de las tiendas.")
public class SucursalController {
    private final SucursalService sucursalService;

    @GetMapping
    @Operation(summary = "Listar sucursales", description = "Obtiene todas las tiendas activas.")
    public ResponseEntity<List<Sucursal>> findAll() {
        return ResponseEntity.ok(sucursalService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener sucursal", description = "Obtener una sucursal por ID.")
    public ResponseEntity<Sucursal> findById(@PathVariable Long id) {
        return ResponseEntity.ok(sucursalService.findById(id));
    }

    @PostMapping
    @Operation(summary = "Crear sucursal", description = "Registrar una nueva sucursal")
    public ResponseEntity<Sucursal> create(@Valid @RequestBody Sucursal sucursal) {
        return new ResponseEntity<>(sucursalService.create(sucursal), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar sucursal", description = "Modifica los datos de una sucursal existente.")
    public ResponseEntity<Sucursal> update(@PathVariable Long id, @Valid @RequestBody Sucursal sucursal) {
        return ResponseEntity.ok(sucursalService.update(id, sucursal));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar sucursal", description = "Elimina una sucursal existente.")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        sucursalService.delete(id);
        return ResponseEntity.ok(Map.of("Mensaje", "Sucursal eliminada con exito"));
    }
}
