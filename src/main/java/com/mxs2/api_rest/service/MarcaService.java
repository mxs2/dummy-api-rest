package com.mxs2.api_rest.service;

import com.mxs2.api_rest.dto.MarcaDTO;
import com.mxs2.api_rest.entity.Marca;
import com.mxs2.api_rest.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarcaService {
    
    @Autowired
    private MarcaRepository marcaRepository;
    
    public Integer create(MarcaDTO marcaDTO) {
        Marca marca = new Marca();
        marca.setNome(marcaDTO.getNome());
        marca.setDataFundacao(marcaDTO.getDataFundacao());
        
        Marca savedMarca = marcaRepository.save(marca);
        return savedMarca.getId();
    }
    
    public MarcaDTO read(Integer id) {
        Optional<Marca> marca = marcaRepository.findById(id);
        if (marca.isPresent()) {
            Marca m = marca.get();
            return new MarcaDTO(m.getId(), m.getNome(), m.getDataFundacao());
        }
        throw new RuntimeException("Marca não encontrada com ID: " + id);
    }
    
    public void update(MarcaDTO marcaDTO) {
        Optional<Marca> optionalMarca = marcaRepository.findById(marcaDTO.getId());
        if (optionalMarca.isPresent()) {
            Marca marca = optionalMarca.get();
            marca.setNome(marcaDTO.getNome());
            marca.setDataFundacao(marcaDTO.getDataFundacao());
            marcaRepository.save(marca);
        } else {
            throw new RuntimeException("Marca não encontrada com ID: " + marcaDTO.getId());
        }
    }
    
    public void delete(Integer id) {
        if (marcaRepository.existsById(id)) {
            marcaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Marca não encontrada com ID: " + id);
        }
    }
    
    public List<MarcaDTO> readAll() {
        List<Marca> marcas = marcaRepository.findAll();
        return marcas.stream()
                .map(m -> new MarcaDTO(m.getId(), m.getNome(), m.getDataFundacao()))
                .collect(Collectors.toList());
    }
}