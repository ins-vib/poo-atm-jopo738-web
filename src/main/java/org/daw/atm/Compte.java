package org.daw.atm;

public class Compte {
    
    // Atributs    // si no hi ha res escrit es "public"
    private String numero;
    private double saldo;
    private String titular;
    private double interesAnual;
    
    // perque sigui un atribut que comparteixen tots els objectes que siguin de la classe ("compte" en aquest cas) hem de posar static
    private static int comptador=1;
    private static final String prefix="ES100-1111-"; // es posa el final perque aquest valor que li he posat inicialment ja no es pugui canviar i sempre tingui el mateix valor


    // el constructor s'ha de dir igual que el public class
    public Compte() {
        //numero = "ES100-1111-"+comptador; //per convertir un numero  a un string posem el (""+)
        numero = prefix+comptador;   // en aquest cas el "" es substitueix pel prefix definit previament
        comptador++;
        //System.out.println("Compte creat");
    }

    

    public Compte( double saldo) {
        //this.numero = numero;
        numero = prefix+comptador; //per convertir un numero  a un string posem el (""+)
        comptador++;
        this.saldo = saldo;
    }



    // podem treure el get i el set perque siguin mes privats
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {   //el set dona valor atribut
        this.numero = numero;     // el "numero" del this fa referència al d'adalt i el que hi ha despres del "=" fa referencia al del "String"
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }
    public double getInteresAnual() {
        return interesAnual;
    }
    public void setInteresAnual(double interesAnual) {
        this.interesAnual = interesAnual;
    }

    public double calculaInteresAnual(){
     //double interes= ((saldo*interesAnual)/100);
     //saldo=interes;

     this.saldo= this.saldo +this.interesAnual/100*this.saldo;
     return this.saldo;
    }

    

    public void ingressar (double quantitat){
     if(quantitat>0){
        saldo=saldo+quantitat;
    }
     
    }

    public boolean retirar (double quantitat){ // posem un boolean per poder dir si la retirada es pot fer o no es pot fer
     if(saldo>=quantitat && quantitat>0){
        saldo=saldo-quantitat;
        return true;
     }
     return false;
     
    }
    public boolean transfarencia (Compte c,double quantitat){
        if(saldo>=quantitat && quantitat>0){
            this.retirar(quantitat);
            c.ingressar(quantitat);
        }
        if (quantitat<=0){
            return false;
        }
        if(this.retirar(quantitat)){
            c.ingressar(quantitat);
            return true;
        }
        return false;
    }

    


    



    

    
}
