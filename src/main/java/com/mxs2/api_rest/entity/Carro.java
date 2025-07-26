package com.mxs2.api_rest.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CAR_CARROS")
public class Carro {
    
    @Id
    @Column(name = "CAR_PLACA", length = 8)
    private String placa;
    
    @Column(name = "CAR_ID_PROPRIETARIO", length = 14)
    private String idProprietario;
    
    @Column(name = "CAR_ANO", nullable = false)
    private Integer ano;
    
    @ManyToOne
    @JoinColumn(name = "MOD_ID", nullable = false)
    private Modelo modelo;
    
    // Construtores
    public Carro() {}
    
    public Carro(String placa, String idProprietario, Integer ano, Modelo modelo) {
        this.placa = placa;
        this.idProprietario = idProprietario;
        this.ano = ano;
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
    
    public Modelo getModelo() {
        return modelo;
    }
    
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}