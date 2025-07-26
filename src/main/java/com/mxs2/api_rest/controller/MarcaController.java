package com.mxs2.api_rest.controller;

import com.mxs2.api_rest.dto.MarcaDTO;
import com.mxs2.api_rest.service.MarcaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/marcas")
@CrossOrigin(origins = "*")
public class MarcaController {
    
    @Autowired
    private MarcaService marcaService;
    
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody MarcaDTO marcaDTO) {
        try {
            Integer id = marcaService.create(marcaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> read(@PathVariable Integer id) {
        try {
            MarcaDTO marca = marcaService.read(id);
            return ResponseEntity.ok(marca);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody MarcaDTO marcaDTO) {
        try {
            marcaService.update(marcaDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            marcaService.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping
    public ResponseEntity<List<MarcaDTO>> readAll() {
        List<MarcaDTO> marcas = marcaService.readAll();
        return ResponseEntity.ok(marcas);
    }
}