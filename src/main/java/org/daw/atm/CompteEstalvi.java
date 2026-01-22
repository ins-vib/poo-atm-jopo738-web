package org.daw.atm;

public class CompteEstalvi extends Compte {

    private double saldoMinim;

    public CompteEstalvi() {
        saldoMinim=200;
    }

    public CompteEstalvi(double saldoMinim, double saldo) {
        super(saldo);
        this.saldoMinim = saldoMinim;
    }

    public double getSaldoMinim() {
        return saldoMinim;
    }

    public void setSaldoMinim(double saldoMinim) {
        this.saldoMinim = saldoMinim;
    }
    

     @Override
    public boolean retirar (double quantitat){

        if(quantitat<=0) return false;

        if(saldo-saldoMinim>=quantitat){ 
        
        Moviment moviment = new Moviment("S'ha fet una retirada", quantitat, "RETIRADA");
        moviments.add(moviment);
            saldo= saldo-quantitat;
        return true;
     }
     return false;
    }

     @Override
     public String toString() {
        return "CompteEstalvi [saldoMinim=" + saldoMinim + "]" + super.toString();
     }

    
}
