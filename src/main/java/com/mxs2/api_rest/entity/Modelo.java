package com.mxs2.api_rest.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "MOD_MODELOS")
public class Modelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOD_ID")
    private Integer id;
    
    @Column(name = "MOD_NOME", length = 50, nullable = false)
    private String nome;
    
    @Column(name = "MOD_DT_INICIO_LINHA", nullable = false)
    private LocalDate dataInicioLinha;
    
    @Column(name = "MOD_DT_FIM_LINHA")
    private LocalDate dataFimLinha;
    
    @ManyToOne
    @JoinColumn(name = "MAR_ID", nullable = false)
    private Marca marca;
    
    @OneToMany(mappedBy = "modelo", cascade = CascadeType.ALL)
    private List<Carro> carros;
    
    // Construtores
    public Modelo() {}
    
    public Modelo(String nome, LocalDate dataInicioLinha, LocalDate dataFimLinha, Marca marca) {
        this.nome = nome;
        this.dataInicioLinha = dataInicioLinha;
        this.dataFimLinha = dataFimLinha;
        this.marca = marca;
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
    
    public LocalDate getDataInicioLinha() {
        return dataInicioLinha;
    }
    
    public void setDataInicioLinha(LocalDate dataInicioLinha) {
        this.dataInicioLinha = dataInicioLinha;
    }
    
    public LocalDate getDataFimLinha() {
        return dataFimLinha;
    }
    
    public void setDataFimLinha(LocalDate dataFimLinha) {
        this.dataFimLinha = dataFimLinha;
    }
    
    public Marca getMarca() {
        return marca;
    }
    
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    public List<Carro> getCarros() {
        return carros;
    }
    
    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
}