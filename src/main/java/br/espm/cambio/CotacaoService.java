package br.espm.cambio;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CotacaoService {
    
    @Autowired
    private CotacaoRepository cotacaoRepository;

    /*public Cotacao findBySimbol(UUID idMoeda){
        return cotacaoRepository.findByIdMoeda(idMoeda)
                        .map(CotacaoModel::to)
                        .orElse(null);
    }*/

    public Cotacao create(Cotacao vo){
        vo.setId(UUID.randomUUID());
        return cotacaoRepository.save(new CotacaoModel(vo)).to();
    }
    
    public List<Cotacao> listCotacao(String simbolo){
        return StreamSupport 
            //tranforma de Iterável para Lista
            .stream(cotacaoRepository.findBySimbol(simbolo).spliterator(), false)
            .collect(Collectors.toList())
            //transforma de Model para Objeto
            .stream().map(CotacaoModel::to)
            .collect(Collectors.toList());
    }
}
