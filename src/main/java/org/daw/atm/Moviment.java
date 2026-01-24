package org.daw.atm;

import java.time.LocalDateTime;

public class Moviment {
    private LocalDateTime datahora;
    private TipusMoviment tipus;   // posem el TipusMoviment ja que aixi nomes accepta els valors que tenim al arxiu tipus moviment
    private String descripcio;
    private double quantitat;

    public Moviment(String descripcio, double quantitat, TipusMoviment tipus) {
        this.datahora = LocalDateTime.now();   // aixi fem que sigui automàtic
        this.descripcio = descripcio;
        this.quantitat = quantitat;
        this.tipus = tipus;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moviment{");
        sb.append("datahora=").append(datahora);
        sb.append(", tipus=").append(tipus);
        sb.append(", descripcio=").append(descripcio);
        sb.append(", quantitat=").append(quantitat);
        sb.append('}');
        return sb.toString();
    }

    

    public LocalDateTime getDatahora() {
        return datahora;
    }



    public TipusMoviment getTipus() {
        return tipus;
    }



    public String getDescripcio() {
        return descripcio;
    }



    public double getQuantitat() {
        return quantitat;
    }
}