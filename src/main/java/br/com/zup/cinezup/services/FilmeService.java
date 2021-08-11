package br.com.zup.cinezup.services;

import br.com.zup.cinezup.dtos.AtorDTO;
import br.com.zup.cinezup.dtos.FilmeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {
    @Autowired
    private AtorService atorService;
    private List<FilmeDTO> filmes = new ArrayList<>();

    public FilmeDTO cadastrarFilme(FilmeDTO filmeDTO){
        List<AtorDTO> elenco = filmeDTO.getElenco();
        List<AtorDTO> objetoAtores = new ArrayList<>();

        for (AtorDTO ator : elenco){
            AtorDTO objeto = atorService.buscarAtorPeloNome(ator.getNome());
            objetoAtores.add(objeto);
        }

        filmeDTO.setElenco(objetoAtores);
        filmes.add(filmeDTO);
        return filmeDTO;
    }
    /*

    Exemplo do metodo anterior utilizando o stream e o map

    public FilmeDTO cadastrarFilme(FilmeDTO filmeDTO){
        List<AtorDTO> objetoAtores = filmeDTO.getElenco().stream()
                .map(objeto -> atorService.buscarAtorPeloNome(objeto.getNome())).collect(Collectors.toList());

        filmeDTO.setElenco(objetoAtores);
        filmes.add(filmeDTO);
        return filmeDTO;
    }

     */
}
