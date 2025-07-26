package com.mxs2.api_rest.service;

import com.mxs2.api_rest.dto.CarroReadDTO;
import com.mxs2.api_rest.dto.CarroWriteDTO;
import com.mxs2.api_rest.entity.Carro;
import com.mxs2.api_rest.entity.Modelo;
import com.mxs2.api_rest.repository.CarroRepository;
import com.mxs2.api_rest.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarroService {
    
    @Autowired
    private CarroRepository carroRepository;
    
    @Autowired
    private ModeloRepository modeloRepository;
    
    public String create(CarroWriteDTO carroDTO) {
        validateAno(carroDTO.getAno());
        
        Optional<Modelo> modelo = modeloRepository.findById(carroDTO.getIdModelo());
        if (!modelo.isPresent()) {
            throw new RuntimeException("Modelo não encontrado com ID: " + carroDTO.getIdModelo());
        }
        
        Carro carro = new Carro();
        carro.setPlaca(carroDTO.getPlaca());
        carro.setIdProprietario(carroDTO.getIdProprietario());
        carro.setAno(carroDTO.getAno());
        carro.setModelo(modelo.get());
        
        Carro savedCarro = carroRepository.save(carro);
        return savedCarro.getPlaca();
    }
    
    public CarroReadDTO read(String placa) {
        Optional<Carro> carro = carroRepository.findById(placa);
        if (carro.isPresent()) {
            Carro c = carro.get();
            return new CarroReadDTO(c.getPlaca(), c.getIdProprietario(), c.getAno(),
                                  c.getModelo().getMarca().getNome(), c.getModelo().getNome());
        }
        throw new RuntimeException("Carro não encontrado com placa: " + placa);
    }
    
    public void update(CarroWriteDTO carroDTO) {
        validateAno(carroDTO.getAno());
        
        Optional<Carro> optionalCarro = carroRepository.findById(carroDTO.getPlaca());
        if (!optionalCarro.isPresent()) {
            throw new RuntimeException("Carro não encontrado com placa: " + carroDTO.getPlaca());
        }
        
        Optional<Modelo> modelo = modeloRepository.findById(carroDTO.getIdModelo());
        if (!modelo.isPresent()) {
            throw new RuntimeException("Modelo não encontrado com ID: " + carroDTO.getIdModelo());
        }
        
        Carro carro = optionalCarro.get();
        carro.setIdProprietario(carroDTO.getIdProprietario());
        carro.setAno(carroDTO.getAno());
        carro.setModelo(modelo.get());
        
        carroRepository.save(carro);
    }
    
    public void delete(String placa) {
        if (carroRepository.existsById(placa)) {
            carroRepository.deleteById(placa);
        } else {
            throw new RuntimeException("Carro não encontrado com placa: " + placa);
        }
    }
    
    public List<CarroReadDTO> consultarPorAnos(Integer anoInicial, Integer anoFinal) {
        List<Carro> carros = carroRepository.findByAnoBetween(anoInicial, anoFinal);
        return carros.stream()
                .map(c -> new CarroReadDTO(c.getPlaca(), c.getIdProprietario(), c.getAno(),
                                         c.getModelo().getMarca().getNome(), c.getModelo().getNome()))
                .collect(Collectors.toList());
    }
    
    private void validateAno(Integer ano) {
        int currentYear = LocalDate.now().getYear();
        if (ano <= 1900 || ano > currentYear + 1) {
            throw new RuntimeException("Ano deve ser maior que 1900 e menor ou igual ao ano atual mais 1");
        }
    }
}