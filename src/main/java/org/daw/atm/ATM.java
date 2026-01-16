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

        
        CompteCorrent cc = new CompteCorrent();   // al no tenir cap constructor hereda el del seu pare, si tingues constructor faria servir el seu
        System.out.println(cc.getNumero());
        cc.ingressar(400);       // aixo es el polimorfisme
        //cc.setLimitDescobert(100);
        cc.retirar(450);
        System.out.println(cc.getSaldo());
        System.out.println(cc); // això és el toString 


        CompteCorrent cc2 = new CompteCorrent(100,500);   // al no tenir cap constructor hereda el del seu pare, si tingues constructor faria servir el seu
        System.out.println(cc2.getNumero());
        cc2.ingressar(400);       // aixo es el polimorfisme
        //cc.setLimitDescobert(100);
        cc.retirar(1001); // NO PUC!!
        System.out.println(cc2.getSaldo());
        System.out.println(cc2);
       
        //System.out.println(Compte.comptador);
        //Compte.comptador++;
        //System.out.println(Compte.comptador);

        

//         Compte c1 = new Compte();
//         //c1.numero = "EI!!11111";
//         //c1.setNumero("EI!!11111");
//         System.out.println(c1.getNumero());
//         c1.setSaldo(100);
//         c1.setInteresAnual(10);
//         //c1.saldo=100;

//         c1.ingressar(100);
//         c1.retirar(50);
//         c1.calculaInteresAnual();
//         System.out.println(c1.getSaldo());
        

//         Compte c2 = new Compte();
//         System.out.println(c2.getNumero());
//         //c2.numero="EI!!22222";
//         //c2.saldo=200;
//         //c2.setNumero("EI!!22222");
//         c2.setSaldo(200);

//         Compte c3;
//         c3=c1;
//         //c3.saldo=0;

//         Compte c4 = new Compte(300); // amb una sola linia podem donar el valor gracies al constructor que hem fet
//     System.out.println(c4.getNumero());

//     c1.transfarencia(c2, 10);
//     System.out.println("saldo del compte 2: "+ c2.getSaldo());
//     System.out.println("saldo del compte 1: "+c1.getSaldo());
    

//     Client client11= new Client("39955738T", "Joan", "1534");
//     Client client2= new Client("258741Y", "anna", "15487");

//     try{
//   Client client1= new Client("11111111A", "Joan", "1534");       
//  client1.setPin("15344");
//     }      
// catch(Exception e){
//         System.out.println(e.getMessage());

//     }


//     client2.comprovarPin("15489");
//     client11.comprovarPin("3415");
//     client2.comprovarPin("78945");
//     client2.comprovarPin("879854");

//     client11.setDni("8754962148"); //error
//     client11.setDni("39955738T"); //correcte
//     client11.setDni("39955738L"); //error
//     client11.setDni("3995A7387"); //error
    

    
Client client1 = new Client("11111111L","Joan","1111");
Client client2 = new Client("22222222Z","Jack","2222");

Compte compte1 = new Compte();
compte1.setTitular(client1);

System.out.println(compte1.getNumero());
System.out.println(compte1.getTitular().getNom());


Compte compte2 = new Compte(1000);
compte2.setTitular(client2);

// Client[] clients=new Client[5];
// clients[0]=new Client("33333333D","Anna","3333");
// clients[1]=new Client("44444444A","Josep","4444");
// clients[2]=new Client("55555555E","Jordi","5555");
// clients[3]=new Client("66666666V","Jaume","6666");
// clients[4]=new Client("77777777N","Nemo","7777");

// Compte[] comptes=new Compte[10];
// comptes[0]= new Compte(100);
// comptes[0].setTitular(clients[0]);
// comptes[1]=new Compte(100);
// comptes[1].setTitular(clients[0]);

// comptes[2]=new Compte(100);
// comptes[2].setTitular(clients[1]);
// comptes[3]=new Compte(100);
// comptes[3].setTitular(clients[1]);

// comptes[4]=new Compte(100);
// comptes[4].setTitular(clients[2]);
// comptes[5]=new Compte(100);
// comptes[5].setTitular(clients[2]);

// comptes[6]=new Compte(100);
// comptes[6].setTitular(clients[3]);
// comptes[7]=new Compte(100);
// comptes[7].setTitular(clients[3]);

// comptes[8]=new Compte(100);
// comptes[8].setTitular(clients[4]);
// comptes[9]=new Compte(100);
// comptes[9].setTitular(clients[4]);

// for(Client cli: clients){
//     System.out.println(cli.getNom());
// }

// for(Compte c: comptes){
//     System.out.println(c.getNumero()+" "+c.getTitular().getDni());
// }

Banc banc= new Banc("Banc DAW");
Client cli= banc.validar("33333333D", "3333");
if(cli!=null){
    System.out.println("Client validat!!!");
    System.out.println(cli.getNom());
}



}



}
   

    


