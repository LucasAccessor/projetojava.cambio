package br.espm.cambio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioResource {

    @Autowired
    private MoedaService moedaService;

    @GetMapping("/hello")
    public String helloWorld(){
        return "h e l l o   w o r l d  (:";
    }

    @GetMapping("/hmtl")
    public String html(){
        return "<h1> AAAAAA <h1>";
    }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda(){
        return moedaService.listaAll();
    }

    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda){
        moedaService.create(moeda);
    }

    
}
