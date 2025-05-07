package com.corto.springboot_libreria.controller;

import com.corto.springboot_libreria.model.Libro;
import com.corto.springboot_libreria.repository.LibroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroRepository repo;

    public LibroController(LibroRepository repo) {
        this.repo = repo;
    }

    /** GET /api/libros */
    @GetMapping
    public List<Libro> listarTodos() {
        return repo.findAll();
    }

    /** GET /api/libros/{id} */
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    /** POST /api/libros */
    @PostMapping
    public ResponseEntity<Libro> crear(@RequestBody Libro libro) {
        Libro guardado = repo.save(libro);
        return ResponseEntity.ok(guardado);
    }

    /** PUT /api/libros/{id} */
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizar(
            @PathVariable Long id,
            @RequestBody Libro datos) {
        return repo.findById(id)
                   .map(l -> {
                       l.setTitulo(datos.getTitulo());
                       l.setIsbn(datos.getIsbn());
                       l.setPrecio(datos.getPrecio());
                       l.setFechaPublicacion(datos.getFechaPublicacion());
                       l.setEditorial(datos.getEditorial());
                       l.setAutores(datos.getAutores());
                       return ResponseEntity.ok(repo.save(l));
                   })
                   .orElse(ResponseEntity.notFound().build());
    }

    /** DELETE /api/libros/{id} */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
