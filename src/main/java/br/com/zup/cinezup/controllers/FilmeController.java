package br.com.zup.cinezup.controllers;

import br.com.zup.cinezup.dtos.FilmeDTO;
import br.com.zup.cinezup.services.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeService filmeService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FilmeDTO cadastrarFilme(@RequestBody FilmeDTO filmeDTO){
        return filmeService.cadastrarFilme(filmeDTO);
    }
}
