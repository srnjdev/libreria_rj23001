package com.corto.springboot_libreria.repository;

import com.corto.springboot_libreria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {}