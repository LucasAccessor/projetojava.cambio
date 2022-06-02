package br.espm.cambio;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cotacao")
public class CotacaoModel {
    
    @Id
    @Column(name = "id_cotacao")
    private String idCotacao;
    
    @Column(name = "id_moeda")
    private String idMoedaC;

    @Column(name = "dt_data")
    @Temporal(TemporalType.DATE)
    private Date dtData;
    
    @Column(name = "vr_valor")
    private Double vrValor;

    public CotacaoModel(){}

    public CotacaoModel(Cotacao cotacao){
        this.idCotacao = cotacao.getId().toString();
        this.idMoedaC = cotacao.getIdMoeda().toString();
        this.dtData = cotacao.getDtData();
        this.vrValor = cotacao.getVrValor();
    }

    public Cotacao to(){
        Cotacao cotacao = new Cotacao();
        cotacao.setId(UUID.fromString(this.idCotacao));
        cotacao.setIdMoeda(UUID.fromString(this.idMoedaC));
        cotacao.setDtData(this.dtData);
        cotacao.setVrValor(this.vrValor);
        return cotacao;
    }
    
}
