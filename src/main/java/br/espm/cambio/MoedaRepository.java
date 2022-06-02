package br.espm.cambio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MoedaRepository extends CrudRepository<MoedaModel, String>{

    @Override
    Iterable<MoedaModel> findAll();

    @Override
    Optional<MoedaModel> findById(String id);

    @Query("SELECT m FROM MoedaModel m WHERE UPPER(m.txSimbolo) = UPPER(:simbolo)") //JQL
    Optional<MoedaModel> findBySimbolo(@Param("simbolo") String simbolo);

    @Query("SELECT m FROM MoedaModel m WHERE UPPER(m.idMoeda) = UPPER(:id)") //JQL
    Optional<MoedaModel> findByIdM(@Param("id") UUID id);

    @Query("DELETE FROM MoedaModel m WHERE UPPER(m.idMoeda) = UPPER(:id)")
    void deleteById(@Param("id") UUID id);
    
}
