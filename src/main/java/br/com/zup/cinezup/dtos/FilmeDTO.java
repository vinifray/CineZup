package br.com.zup.cinezup.dtos;

import br.com.zup.cinezup.enums.Categoria;

import java.time.LocalDate;
import java.util.List;

public class FilmeDTO {
    private String nome;
    private String sinopse;
    private LocalDate anoDeLancamento;
    private List<AtorDTO> alenco;
    private Categoria categoria;

    public FilmeDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public LocalDate getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(LocalDate anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public List<AtorDTO> getAlenco() {
        return alenco;
    }

    public void setAlenco(List<AtorDTO> alenco) {
        this.alenco = alenco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
