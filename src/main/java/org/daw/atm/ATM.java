/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.daw.atm;

/**
 *
 * @author jpome
 */
public class ATM {

    public static void main(String[] args) {
       
        //System.out.println(Compte.comptador);
        //Compte.comptador++;
        //System.out.println(Compte.comptador);

        

        Compte c1 = new Compte();
        //c1.numero = "EI!!11111";
        //c1.setNumero("EI!!11111");
        System.out.println(c1.getNumero());
        c1.setSaldo(100);
        c1.setInteresAnual(10);
        //c1.saldo=100;

        c1.ingressar(100);
        c1.retirar(50);
        c1.calculaInteresAnual();
        System.out.println(c1.getSaldo());
        

        Compte c2 = new Compte();
        System.out.println(c2.getNumero());
        //c2.numero="EI!!22222";
        //c2.saldo=200;
        //c2.setNumero("EI!!22222");
        c2.setSaldo(200);

        Compte c3;
        c3=c1;
        //c3.saldo=0;

        Compte c4 = new Compte(300); // amb una sola linia podem donar el valor gracies al constructor que hem fet
    System.out.println(c4.getNumero());

    c1.transfarencia(c2, 10);
    System.out.println("saldo del compte 2: "+ c2.getSaldo());
    System.out.println("saldo del compte 1: "+c1.getSaldo());
    

    Client client1= new Client("39955738T", "Joan", "1534");
    Client client2= new Client("258741Y", "anna", "15487");

    try{
 client1.setPin("15344");
    }      
    catch(Exception e){

    }

    client2.comprovarPin("15489");
    client1.comprovarPin("3415");
    client2.comprovarPin("78945");
    client2.comprovarPin("879854");

    client1.setDni("8754962148"); //error
    client1.setDni("39955738T"); //correcte
    client1.setDni("39955738L");
    


}

}
   

    


