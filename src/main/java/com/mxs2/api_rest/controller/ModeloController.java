package com.mxs2.api_rest.controller;

import com.mxs2.api_rest.dto.ModeloDTO;
import com.mxs2.api_rest.service.ModeloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/modelos")
@CrossOrigin(origins = "*")
public class ModeloController {
    
    @Autowired
    private ModeloService modeloService;
    
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody ModeloDTO modeloDTO) {
        try {
            Integer id = modeloService.create(modeloDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        try {
            ModeloDTO modelo = modeloService.read(id);
            return ResponseEntity.ok(modelo);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody ModeloDTO modeloDTO) {
        try {
            modeloService.update(modeloDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            modeloService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<List<ModeloDTO>> readAll() {
        List<ModeloDTO> modelos = modeloService.readAll();
        return ResponseEntity.ok(modelos);
    }
}