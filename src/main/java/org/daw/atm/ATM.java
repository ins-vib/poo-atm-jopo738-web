/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.daw.atm;

import java.util.Scanner;

/**
 *
 * @author jpome
 */
public class ATM {

    public static void main(String[] args) {

        

        Scanner teclat= new Scanner(System.in);
        Caixer caixer = new Caixer();
        String dni,PIN;
        
        System.out.println("entra el teu DNI: ");
        dni= teclat.next();
        System.out.println("Entra el teu PIN: ");
        PIN= teclat.next();
        
        boolean correcte = caixer.login(dni, PIN);
        //Fins que no sigui correcte demanar dades

        while(correcte==false){
            System.out.println("entra el teu DNI: ");
            dni= teclat.nextLine();
            System.out.println("Entra el teu PIN: ");
            PIN= teclat.nextLine();
            correcte = caixer.login(dni, PIN);
        }
        //menu opcions disponibles...

        int opcio=0;
        Banc bancActual = caixer.getBanc();
                while(opcio != 6){
                    System.out.println("MENU PRINCIPAL: ");
                    System.out.println("1. veure els meus comptes");
                    System.out.println("2. consultar saldo");
                    System.out.println("3. ingressar diners");
                    System.out.println("4. retirar diners");
                    System.out.println("5. fer una transferència");
                    System.out.println("6. sortir");
                    System.out.println("selecciona una opció: ");

                    try {
        String entrada = teclat.nextLine(); 
        if (entrada.isEmpty()) continue;   
        opcio = Integer.parseInt(entrada);  
    } catch (NumberFormatException e) {
        System.out.println("ERROR: Has d'escriure un NÚMERO (1-6)");
        continue; 
    }

                    switch(opcio){
                        case 1:
                            bancActual.mostrarComptesClient(caixer.getClientConnectat().getDni());
                            break;
                        case 2: 
                            System.out.println("entra el numero del compte: ");
                            String n2= teclat.nextLine();
                            Compte c2=bancActual.cercarCompte(n2);
                            if(c2 != null){
                                System.out.println("saldo actual: "+ c2.getSaldo());
                            }else{
                                System.out.println("compte no trobat");
                            }
                            break;
                        case 3:
                            System.out.println("numero de compte: ");
                            String c3= teclat.nextLine();
                            System.out.println("quantitat a ingressar: ");
                            double q4= Double.parseDouble(teclat.nextLine());
                            if(bancActual.ingressarCompte(c3, q4)){
                                System.out.println("ingres realitzat");

                            }else{
                                System.out.println("error");
                            }
                            break;
                        case 4:
                            System.out.println("numero de compte: ");
                            String c4= teclat.nextLine();
                            System.out.println("entra DNI: ");
                            String dni2= teclat.nextLine();
                            System.out.println("quantitat a retirar: ");
                            double q5= Double.parseDouble(teclat.nextLine());
                            if(bancActual.retirarCompte(c4, q5,dni2)){
                                System.out.println("retirada realitzada amb èxit");
                            }else{
                                System.out.println("saldo insuficient o limit superat ");
                            }
                            break;
                        case 5:
                            System.out.println("compte origen:");
                            String co= teclat.nextLine();
                            System.out.println("compte desti:");
                            String cd= teclat.nextLine();
                            System.out.println("import: ");
                            double q6= Double.parseDouble(teclat.nextLine());
                            
                            if(bancActual.transfarenciaCompte(co, q6, caixer.getClientConnectat().getDni(), cd)){
                                System.out.println("Transfarència realitzada");
                            }else{
                                System.out.println("error a la transfarència");
                            }
                            break;
                        case 6:
                            caixer.logout();
                            System.out.println("Sessió tancada");
                            break;
                        default:
                            System.out.println("Opció no vàlida");


                    }
                }
          


        

    //     int opcio = 0;
    // String numeroCompte = "ES100-1111-1"; // Idealmente esto vendría de una lista del cliente

    // while (opcio != 4) {
    //     System.out.println("\n--- MENÚ PRINCIPAL ---");
    //     System.out.println("1. Veure els meus comptes");
    //     System.out.println("1. Ingressar diners");
    //     System.out.println("2. Retirar diners");
    //     System.out.println("3. Consultar saldo");
    //     System.out.println("4. Sortir");
    //     System.out.print("Selecciona una opció: ");
        
    //     opcio = teclat.nextInt();

    //     switch (opcio) {

    //         case 1:
                
    //             System.out.println("\n--- ELS TEUS COMPTES ---");
    //             //this.banc.mostrarComptesClient;
    //             break;

    //         case 2:
    //             System.out.print("Entra la quantitat a ingressar: ");
    //             double qIngres = teclat.nextDouble();
    //             caixer.ingresar(numeroCompte, qIngres);
    //             System.out.println("Ingrés realitzat correctament.");
    //             break;

    //         case 3:
    //             System.out.print("Entra la quantitat a retirar: ");
    //             double qRetirada = teclat.nextDouble();
    //             caixer.retirar(numeroCompte, qRetirada);
    //             break;

    //         case 4:
                
    //             System.out.println("Consulta de saldo seleccionada.");
    //             // falta 
    //             break;

    //         case 5:
    //             System.out.println("Gràcies per fer servir el caixer. Adeu!");
    //             break;

    //         default:
    //             System.out.println("Opció no vàlida.");
    //             break;
    //     }
    // }
    // teclat.close();





        //pregunta per teclat
        //double quantitat=100;
        //String numero= "ES100-1111-1";
        //caixer.ingresar(numero, quantitat);

        //caixer.ingresar(numero, quantitat);

        //caixer.retirar(numero, quantitat); // implementar
        // només es pot retirar d'un compte que pertanyi al client!!
        
        







        // CompteCorrent cc = new CompteCorrent();   // al no tenir cap constructor hereda el del seu pare, si tingues constructor faria servir el seu
        // System.out.println(cc.getNumero());
        // cc.ingressar(400);       // aixo es el polimorfisme
        // //cc.setLimitDescobert(100);
        // cc.retirar(450);
        // System.out.println(cc.getSaldo());
        // System.out.println(cc); // això és el toString 
        


        // CompteCorrent cc2 = new CompteCorrent(100,500);   // al no tenir cap constructor hereda el del seu pare, si tingues constructor faria servir el seu
        // System.out.println(cc2.getNumero());
        // cc2.ingressar(400);       // aixo es el polimorfisme
        // //cc.setLimitDescobert(100);
        // cc.retirar(1001); // NO PUC!!
        // System.out.println(cc2.getSaldo());
        // System.out.println(cc2);
       
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
    

    
// Client client1 = new Client("11111111L","Joan","1111");
// Client client2 = new Client("22222222Z","Jack","2222");

// Compte compte1 = new Compte();
// compte1.setTitular(client1);

// System.out.println(compte1.getNumero());
// System.out.println(compte1.getTitular().getNom());


// Compte compte2 = new Compte(1000);
// compte2.setTitular(client2);

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

//Banc banc= new Banc("Banc DAW");
// Client cli= banc.validar("33333333D", "3333");
// if(cli!=null){
//     System.out.println("Client validat!!!");
//     System.out.println(cli.getNom());
// }

//banc.mostrarComptes();



}
}





   

    


