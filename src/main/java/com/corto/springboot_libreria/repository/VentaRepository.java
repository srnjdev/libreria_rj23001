package com.corto.springboot_libreria.repository;

import com.corto.springboot_libreria.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {}