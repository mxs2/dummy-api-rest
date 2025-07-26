package com.mxs2.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class ModeloDTO {
    
    private Integer id;
    
    @NotBlank(message = "Nome deve ser preenchido")
    @Size(max = 50, message = "Nome deve ter no máximo 50 caracteres")
    private String nome;
    
    @NotNull(message = "Data de início de linha deve ser preenchida")
    private LocalDate dataInicioLinha;
    
    private LocalDate dataFimLinha;
    
    @NotNull(message = "ID da marca deve ser preenchido")
    private Integer idMarca;
    
    // Construtores
    public ModeloDTO() {}
    
    public ModeloDTO(Integer id, String nome, LocalDate dataInicioLinha, LocalDate dataFimLinha, Integer idMarca) {
        this.id = id;
        this.nome = nome;
        this.dataInicioLinha = dataInicioLinha;
        this.dataFimLinha = dataFimLinha;
        this.idMarca = idMarca;
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
    
    public Integer getIdMarca() {
        return idMarca;
    }
    
    public void setIdMarca(Integer idMarca) {
        this.idMarca = idMarca;
    }
}