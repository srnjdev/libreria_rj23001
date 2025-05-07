package com.corto.springboot_libreria.repository;

import com.corto.springboot_libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {}
