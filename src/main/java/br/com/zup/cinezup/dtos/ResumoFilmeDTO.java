package br.com.zup.cinezup.dtos;

import java.time.LocalDate;

public class ResumoFilmeDTO {
    private String nome;
    private LocalDate anoDeLancamento;

    public ResumoFilmeDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(LocalDate anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }
}
