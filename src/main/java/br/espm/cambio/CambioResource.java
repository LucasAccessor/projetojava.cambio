package br.espm.cambio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.print.DocFlavor.STRING;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioResource {

    @Autowired
    private MoedaService moedaService;
    @Autowired
    private CotacaoService cotacaoService;

    /*@GetMapping("/hello")
    public String helloWorld(){
        return "h e l l o   w o r l d  (:";
    } */

    @GetMapping("/hmtl")
    public String html(){
        return "<h1> AAAAAA <h1>";
    }

    @GetMapping("/moeda")
    public List<Moeda> listMoeda(){
        return moedaService.listaAll();
    }

    @GetMapping("/moeda/{simbolo:[A-Z]{3,}}") //bUsCa PoR sImBoLo path:[A-Z]
    public Moeda findMoedaBySimbolo(@PathVariable String simbolo){
        return moedaService.findBySimbolo(simbolo);
    }

    @GetMapping("/moeda/{id:[a-f0-9]{8}(?:-[a-f0-9]{4}){4}[a-f0-9]{8}}") //bUsCa PoR iD
    public Moeda findMoedaById(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        return moedaService.findById(uuid);
    }
    
    @DeleteMapping("/moeda/delete/{id}") //dElEtA PoR iD
    public void deleteById(@PathVariable String id){
        UUID uuid = UUID.fromString(id);
        moedaService.deleteById(uuid);
    }

// spring boot endpoint regex -> buscar 
    @PostMapping("/moeda")
    public void save(@RequestBody Moeda moeda){
        moedaService.create(moeda);
    }

    @GetMapping("/cotacao/{simbolo}") //bUsCa PoR sImBoLo path:[A-Z]
    public List<Cotacao> findCotacaoBySimbolo(@PathVariable String simbolo){
        return cotacaoService.listCotacao(simbolo);
    }

    @PostMapping("/cotacao/{simbolo}/{ano}/{mes}/{dia}")
    public void save(@PathVariable String simbolo, @PathVariable String ano, @PathVariable String mes, @PathVariable String dia, @RequestBody Cotacao cotacao) throws ParseException{
        SimpleDateFormat dtf = new SimpleDateFormat("yyyyMMdd");
        String dataString = ano + mes + dia;
        UUID idMoeda = moedaService.findBySimbolo(simbolo).getId();
            Date dtDate = dtf.parse(dataString);
        cotacao.setIdMoeda(idMoeda);
        cotacao.setDtData(dtDate);
            cotacaoService.create(cotacao);
    }
    
}
