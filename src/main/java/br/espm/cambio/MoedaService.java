package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
§§§§§§§§§§§§§§§§§§§§ MICROSERVIÇO DE MOEDA §§§§§§§§§§§§§§§§§§§§
*/
@Component
public class MoedaService {
    
    @Autowired //Avisa o servidor que é um spring boot - procura o código e instancia automáticamente (SpringBoot)
    private MoedaRepository moedaRepository;

    public List<Moeda> listaAll(){
        return StreamSupport 
            //tranforma de Iterável para Lista
            .stream(moedaRepository.findAll().spliterator(), false)
            .collect(Collectors.toList())
            //transforma de Model para Objeto
            .stream().map(MoedaModel::to)
            .collect(Collectors.toList());
    }

    public Moeda create(Moeda vo){
        vo.setId(UUID.randomUUID());
        return moedaRepository.save(new MoedaModel(vo)).to();
    }

    public Moeda findBySimbolo(String simbolo){
        return moedaRepository.findBySimbolo(simbolo)
                              .map(MoedaModel::to)
                               .orElse(null);
    }

}
