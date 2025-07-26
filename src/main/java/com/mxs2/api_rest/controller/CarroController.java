package com.mxs2.api_rest.controller;

import com.mxs2.api_rest.dto.CarroReadDTO;
import com.mxs2.api_rest.dto.CarroWriteDTO;
import com.mxs2.api_rest.service.CarroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/carros")
@CrossOrigin(origins = "*")
public class CarroController {
    
    @Autowired
    private CarroService carroService;
    
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody CarroWriteDTO carroDTO) {
        try {
            String placa = carroService.create(carroDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(placa);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/{placa}")
    public ResponseEntity<?> read(@PathVariable String placa) {
        try {
            CarroReadDTO carro = carroService.read(placa);
            return ResponseEntity.ok(carro);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody CarroWriteDTO carroDTO) {
        try {
            carroService.update(carroDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @DeleteMapping("/{placa}")
    public ResponseEntity<?> delete(@PathVariable String placa) {
        try {
            carroService.delete(placa);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @GetMapping("/consultar")
    public ResponseEntity<List<CarroReadDTO>> consultarPorAnos(
            @RequestParam Integer anoInicial, 
            @RequestParam Integer anoFinal) {
        List<CarroReadDTO> carros = carroService.consultarPorAnos(anoInicial, anoFinal);
        return ResponseEntity.ok(carros);
    }
}