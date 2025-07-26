package com.mxs2.api_rest.service;

import com.mxs2.api_rest.dto.ModeloDTO;
import com.mxs2.api_rest.entity.Marca;
import com.mxs2.api_rest.entity.Modelo;
import com.mxs2.api_rest.repository.MarcaRepository;
import com.mxs2.api_rest.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloService {
    
    @Autowired
    private ModeloRepository modeloRepository;
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    public Integer create(ModeloDTO modeloDTO) {
        validateDataInicioFim(modeloDTO.getDataInicioLinha(), modeloDTO.getDataFimLinha());
        
        Optional<Marca> marca = marcaRepository.findById(modeloDTO.getIdMarca());
        if (!marca.isPresent()) {
            throw new RuntimeException("Marca não encontrada com ID: " + modeloDTO.getIdMarca());
        }
        
        Modelo modelo = new Modelo();
        modelo.setNome(modeloDTO.getNome());
        modelo.setDataInicioLinha(modeloDTO.getDataInicioLinha());
        modelo.setDataFimLinha(modeloDTO.getDataFimLinha());
        modelo.setMarca(marca.get());
        
        Modelo savedModelo = modeloRepository.save(modelo);
        return savedModelo.getId();
    }
    
    public ModeloDTO read(Integer id) {
        Optional<Modelo> modelo = modeloRepository.findById(id);
        if (modelo.isPresent()) {
            Modelo m = modelo.get();
            return new ModeloDTO(m.getId(), m.getNome(), m.getDataInicioLinha(), 
                               m.getDataFimLinha(), m.getMarca().getId());
        }
        throw new RuntimeException("Modelo não encontrado com ID: " + id);
    }
    
    public void update(ModeloDTO modeloDTO) {
        validateDataInicioFim(modeloDTO.getDataInicioLinha(), modeloDTO.getDataFimLinha());
        
        Optional<Modelo> optionalModelo = modeloRepository.findById(modeloDTO.getId());
        if (!optionalModelo.isPresent()) {
            throw new RuntimeException("Modelo não encontrado com ID: " + modeloDTO.getId());
        }
        
        Optional<Marca> marca = marcaRepository.findById(modeloDTO.getIdMarca());
        if (!marca.isPresent()) {
            throw new RuntimeException("Marca não encontrada com ID: " + modeloDTO.getIdMarca());
        }
        
        Modelo modelo = optionalModelo.get();
        modelo.setNome(modeloDTO.getNome());
        modelo.setDataInicioLinha(modeloDTO.getDataInicioLinha());
        modelo.setDataFimLinha(modeloDTO.getDataFimLinha());
        modelo.setMarca(marca.get());
        
        modeloRepository.save(modelo);
    }
    
    public void delete(Integer id) {
        if (modeloRepository.existsById(id)) {
            modeloRepository.deleteById(id);
        } else {
            throw new RuntimeException("Modelo não encontrado com ID: " + id);
        }
    }
    
    public List<ModeloDTO> readAll() {
        List<Modelo> modelos = modeloRepository.findAll();
        return modelos.stream()
                .map(m -> new ModeloDTO(m.getId(), m.getNome(), m.getDataInicioLinha(), 
                                      m.getDataFimLinha(), m.getMarca().getId()))
                .collect(Collectors.toList());
    }
    
    private void validateDataInicioFim(java.time.LocalDate dataInicio, java.time.LocalDate dataFim) {
        if (dataFim != null && dataInicio.isAfter(dataFim)) {
            throw new RuntimeException("Data de início deve ser menor ou igual à data de fim");
        }
    }
}