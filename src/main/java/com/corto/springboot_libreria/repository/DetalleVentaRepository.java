package com.corto.springboot_libreria.repository;

import com.corto.springboot_libreria.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {}