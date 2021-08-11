package br.com.zup.cinezup.services;

import br.com.zup.cinezup.dtos.AtorDTO;
import br.com.zup.cinezup.dtos.FilmeDTO;
import br.com.zup.cinezup.dtos.ResumoFilmeDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public List<FilmeDTO> filtrarFilmesPorDistanciaDeData(int distnacia){
        int anoInicial = LocalDate.now().getYear() - distnacia;

        List<FilmeDTO> filmesFiltrada = new ArrayList<>();
        for (FilmeDTO filme : filmes){
            if(filme.getAnoDeLancamento().getYear() >= anoInicial){
                filmesFiltrada.add(filme);
            }
        }

        return filmesFiltrada;
    }

    public List<ResumoFilmeDTO> converterListaFilmeDTOparaListaResumoDTO(List<FilmeDTO> listaFilmes){
        List<ResumoFilmeDTO> resumoFilmes = new ArrayList<>();

        for(FilmeDTO filme : listaFilmes) {
            ResumoFilmeDTO resumoFilmeDTO = new ResumoFilmeDTO();
            BeanUtils.copyProperties(filme, resumoFilmeDTO);
            resumoFilmes.add(resumoFilmeDTO);

            /*
            Exemplo com problema de LocalDate
            resumoFilmes.add(objectMapper.convertValue(filme, ResumoFilmeDTO.class));
            */
        }
        return resumoFilmes;
    }
}
