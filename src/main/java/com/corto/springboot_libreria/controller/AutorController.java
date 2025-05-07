package com.corto.springboot_libreria.controller;

import com.corto.springboot_libreria.model.Autor;
import com.corto.springboot_libreria.repository.AutorRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorRepository repo;

    public AutorController(AutorRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Autor> listarTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Autor> obtener(@PathVariable Long id) {
        return repo.findById(id)
                   .map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Autor crear(@RequestBody Autor autor) {
        return repo.save(autor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> actualizar(
            @PathVariable Long id,
            @RequestBody Autor datos) {
        return repo.findById(id)
                   .map(a -> {
                       a.setNombre(datos.getNombre());
                       // setea otros campos…
                       return ResponseEntity.ok(repo.save(a));
                   })
                   .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
