package com.corto.springboot_libreria.repository;

import com.corto.springboot_libreria.model.Autor;  
import org.springframework.data.jpa.repository.JpaRepository;


public interface AutorRepository extends JpaRepository<Autor, Long> {}