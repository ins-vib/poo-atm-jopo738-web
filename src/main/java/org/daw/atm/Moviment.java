package org.daw.atm;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Moviment {
    private LocalDateTime datahora;
    private String tipus;
    private String descripcio;
    private double quantitat;

    public Moviment(String descripcio, double quantitat, String tipus) {
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

    public enum tipus {
    INGRES,
    RETIRADA,
    TRANSFERENCIA
}

public class Compte {
    public double saldo;
    public ArrayList<Moviment> moviments = new ArrayList<>();

    
}






}
