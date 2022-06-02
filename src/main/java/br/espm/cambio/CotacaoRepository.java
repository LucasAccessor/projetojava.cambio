package br.espm.cambio;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {
    
    @Override
    Iterable<CotacaoModel> findAll();

    @Override
    Optional<CotacaoModel> findById(String id);

    @Query("SELECT m FROM CotacaoModel m WHERE idMoedaC = (SELECT idMoeda FROM MoedaModel WHERE UPPER(txSimbolo) = UPPER(:simbolo))") //JQL
    List<CotacaoModel> findBySimbol(@Param("simbolo") String simbolo);
    //SELECT c from CotacaoModel c WHERE idMoeda = (SELECT idMoeda from MoedaModel WHERE UPPER(txSimbolo) = UPPER(:simbolo))

}
