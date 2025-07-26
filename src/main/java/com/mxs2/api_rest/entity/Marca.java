package com.mxs2.api_rest.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MAR_MARCAS")
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAR_ID")
    private Integer id;
    
    @Column(name = "MAR_NOME", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "MAR_DT_FUNDACAO", nullable = false)
    private LocalDate dataFundacao;
    
    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<Modelo> modelos;
    
    // Construtores
    public Marca() {}
    
    public Marca(String nome, LocalDate dataFundacao) {
        this.nome = nome;
        this.dataFundacao = dataFundacao;
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public LocalDate getDataFundacao() {
        return dataFundacao;
    }
    
    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
    
    public List<Modelo> getModelos() {
        return modelos;
    }
    
    public void setModelos(List<Modelo> modelos) {
        this.modelos = modelos;
    }
}