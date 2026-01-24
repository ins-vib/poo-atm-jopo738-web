package org.daw.atm;

import java.util.ArrayList;

public class Compte {
    
    // Atributs    // si no hi ha res escrit es "public"
    protected String numero;  // el protected el que fa es que son privats per a tothom menys per els fills
    protected double saldo;
    protected Client titular;
    protected double interesAnual;
    protected ArrayList<Moviment> moviments = new ArrayList<>();  // el moviments que hi ha entre <> és el de la classe, el moviments del costat és el nom
    
    // perque sigui un atribut que comparteixen tots els objectes que siguin de la classe ("compte" en aquest cas) hem de posar static
    private static int comptador=1;
    private static final String prefix="ES100-1111-"; // es posa el "final" perque aquest valor que li he posat inicialment ja no es pugui canviar i sempre tingui el mateix valor

    
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
        Moviment moviment = new Moviment("S'ha fet un ingrés", quantitat, TipusMoviment.INGRES);
        moviments.add(moviment);
        saldo=saldo+quantitat;
    }
     
    }

    public boolean retirar (double quantitat){ // posem un boolean per poder dir si la retirada es pot fer o no es pot fer
     if(saldo>=quantitat && quantitat>0){
        Moviment moviment = new Moviment("S'ha fet una retirada", quantitat, TipusMoviment.RETIRADA);
        moviments.add(moviment);
        saldo=saldo-quantitat;
        return true;
     }
     return false;
     
    }
    // public boolean transfarencia (Compte c,double quantitat){
    //     if(saldo>=quantitat && quantitat>0){
    //         this.retirar(quantitat);
    //         c.ingressar(quantitat);
    //     }
    //     if (quantitat<=0){
    //         return false;
    //     }
    //     if(this.retirar(quantitat)){
    //         c.ingressar(quantitat);
    //         return true;
    //     }
    //     return false;
    // }

    public boolean transferencia (Compte desti, double quantitat){
        if(quantitat<=0){
            return false;
        }
        if(this.retirar(quantitat)){
            desti.ingressar(quantitat);
            return true;
        }
        return false;
    }

    public Client getTitular() {
        return titular;
    }

    public void setTitular(Client titular) {
        this.titular = titular;
    }



    @Override  // serveix per sobreescriure i ens indica que està sobreescrivint
    public String toString() {  // en aquest cas com no te cap pare el que sobreescriu és el object que és la classe que es la major (es crea sempre)
        return "Compte [numero=" + numero + ", saldo=" + saldo + ", titular=" + titular + ", interesAnual="
                + interesAnual + "]";
    }


    public void mostrarMoviments(){
        for(Moviment s: moviments){
            System.out.println(s);
        }
    }

    public ArrayList<Moviment> getMoviments() {
        return moviments;
    }

    public static void resetContador(){
        comptador=1;
    }



    

    


    



    

    
}
