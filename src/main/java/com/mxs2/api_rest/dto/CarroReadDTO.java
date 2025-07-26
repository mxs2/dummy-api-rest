package com.mxs2.api_rest.dto;

public class CarroReadDTO {
    
    private String placa;
    private String idProprietario;
    private Integer ano;
    private String marca;
    private String modelo;
    
    // Construtores
    public CarroReadDTO() {}
    
    public CarroReadDTO(String placa, String idProprietario, Integer ano, String marca, String modelo) {
        this.placa = placa;
        this.idProprietario = idProprietario;
        this.ano = ano;
        this.marca = marca;
        this.modelo = modelo;
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
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}