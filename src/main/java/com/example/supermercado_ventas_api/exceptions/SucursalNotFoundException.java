package com.example.supermercado_ventas_api.exceptions;

public class SucursalNotFoundException extends RuntimeException {

    public SucursalNotFoundException(Long id) {
        super("La sucursal con ID " + id + " no existe en la base de datos.");
    }
}
