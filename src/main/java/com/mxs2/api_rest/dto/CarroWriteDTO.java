package com.mxs2.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CarroWriteDTO {
    
    @NotBlank(message = "Placa deve ser preenchida")
    @Pattern(regexp = "^[A-Z]{3}[0-9]{4}$|^[A-Z]{3}[0-9][A-Z][0-9]{2}$", 
             message = "Placa deve ter o formato AAANNNN ou AAANANN")
    private String placa;
    
    @Size(min = 11, max = 14, message = "ID do proprietário deve ter 11 ou 14 caracteres")
    private String idProprietario;
    
    @NotNull(message = "Ano deve ser preenchido")
    private Integer ano;
    
    @NotNull(message = "ID da marca deve ser preenchido")
    private Integer idMarca;
    
    @NotNull(message = "ID do modelo deve ser preenchido")
    private Integer idModelo;
    
    // Construtores
    public CarroWriteDTO() {}
    
    public CarroWriteDTO(String placa, String idProprietario, Integer ano, Integer idMarca, Integer idModelo) {
        this.placa = placa;
        this.idProprietario = idProprietario;
        this.ano = ano;
        this.idMarca = idMarca;
        this.idModelo = idModelo;
    }
    
    // Getters e Setters
    public String getPlaca() {
        return placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getIdProprietario() {
        return idProprietario;
    }
    
    public void setIdProprietario(String idProprietario) {
        this.idProprietario = idProprietario;
    }
    
    public Integer getAno() {
        return ano;
    }
    
    public void setAno(Integer ano) {
        this.ano = ano;
    }
    
    public Integer getIdMarca() {
        return idMarca;
    }
    
    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }
    
    public Integer getIdModelo() {
        return idModelo;
    }
    
    public void setIdModelo(Integer idModelo) {
        this.idModelo = idModelo;
    }
}