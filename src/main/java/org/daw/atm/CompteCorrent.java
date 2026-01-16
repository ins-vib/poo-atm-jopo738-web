package org.daw.atm;

public class CompteCorrent extends Compte{

    private double limitDescobert;  // per iniciar aquesta variable fem un constructor

    public CompteCorrent() {   // aixo és el constructor

        limitDescobert=100;
    }

    public CompteCorrent(double limitDescobert, double saldo) {  // amb aquet constructor el que ens permet és donar valor a saldo que no és d'aquesta classe sinó de la classe pare
        super(saldo);  // el super es perque crida al seu superior que és el seu pare, SEMPRE VA ADALT DE TOT
        this.limitDescobert = limitDescobert;
    }





    public double getLimitDescobert() {
        return limitDescobert;
    }

    public void setLimitDescobert(double limitDescobert) {
        this.limitDescobert = limitDescobert;
    }

    @Override
    public boolean retirar(double quantitat){   // sobreescrivim sobre el metode que te el seu pare

        if(quantitat<=0) return false;

        if(saldo + limitDescobert>=quantitat){    // al saldo ens surt error perque al pare te el saldo private, per aixo posem el "getSaldo()", al posar protected si volem el podem treure com he fet
        saldo= saldo-quantitat;
        return true;
     }
     return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompteCorrent{");
        sb.append("limitDescobert=").append(limitDescobert);
        sb.append('}');
        sb.append(super.toString());  // amb aixo accedim al toString del seu pare gràcies al seu pare "SUPER" PER ACONSEGUIR COSSES DEL PARE
        return sb.toString();
    }


    
}
