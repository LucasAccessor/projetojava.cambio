package br.espm.cambio;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.UUID;

public class Cotacao {
    
    private UUID id;
    private UUID idMoeda;
    private Date dtData;
    private double vrValor;

    
    //gEtTeRs & sEtTeEs
    public UUID getId() {
        return id;
    }
    public Date getDtData() {
        return dtData;
    }
    public void setDtData(Date dtData) {
        this.dtData = dtData;
    }
    public double getVrValor() {
        return vrValor;
    }
    public UUID getIdMoeda() {
        return idMoeda;
    }

    public void setVrValor(double vrValor) {
        this.vrValor = vrValor;
    }
    public void setIdMoeda(UUID idMoeda) {
        this.idMoeda = idMoeda;
    }
    public void setId(UUID id) {
        this.id = id;
    }
}
