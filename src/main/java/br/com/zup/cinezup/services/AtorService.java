package br.com.zup.cinezup.services;

import br.com.zup.cinezup.dtos.AtorDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtorService {
    private List<AtorDTO> atores = new ArrayList<>();

    public void adicionarAtorNaLista(AtorDTO atorDTO){
        atores.add(atorDTO);
    }

    public void verificarAtorDuplicado(String nome){
        for (AtorDTO ator : atores){
            if(ator.getNome().equals(nome)){
                throw new RuntimeException("Ator já cadastrado");
            }
        }
    }
}
