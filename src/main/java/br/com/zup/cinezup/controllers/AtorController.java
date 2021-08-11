package br.com.zup.cinezup.controllers;

import br.com.zup.cinezup.services.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/atores")
public class AtorController {
    @Autowired
    private AtorService atorService;


}
