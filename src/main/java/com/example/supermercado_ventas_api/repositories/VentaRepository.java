package com.example.supermercado_ventas_api.repositories;

import com.example.supermercado_ventas_api.models.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta,Long> {
}
