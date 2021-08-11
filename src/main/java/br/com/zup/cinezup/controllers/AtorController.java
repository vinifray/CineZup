package br.com.zup.cinezup.controllers;

import br.com.zup.cinezup.dtos.AtorDTO;
import br.com.zup.cinezup.services.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atores")
public class AtorController {
    @Autowired
    private AtorService atorService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarAtor(@RequestBody AtorDTO atorDTO){
        atorService.adicionarAtorNaLista(atorDTO);
    }
}
