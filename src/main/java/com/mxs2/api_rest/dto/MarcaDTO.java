package com.mxs2.api_rest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class MarcaDTO {
    
    private Integer id;
    
    @NotBlank(message = "Nome deve ser preenchido")
    @Size(max = 50, message = "Nome deve ter no máximo 50 caracteres")
    private String nome;
    
    @NotNull(message = "Data da fundação deve ser preenchida")
    @PastOrPresent(message = "Data da fundação deve ser menor ou igual à data atual")
    private LocalDate dataFundacao;
    
    // Construtores
    public MarcaDTO() {}
    
    public MarcaDTO(Integer id, String nome, LocalDate dataFundacao) {
        this.id = id;
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
}