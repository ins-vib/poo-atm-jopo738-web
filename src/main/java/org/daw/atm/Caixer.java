package org.daw.atm;

import java.util.Scanner;

public class Caixer {

    private Banc banc;
    private Client clientConnectat;

    public Caixer() {
        banc = new Banc("Banc DAW1"); // es crea un objecte tipus banc, relacionat amb el metode banc
        clientConnectat=null;  // el posem null, pertnat no tenim ningu connectat
    }

    public boolean login(String dni, String PIN){

        if(clientConnectat!=null)return false; // si el clientconnectat no es null es que ja hi ha un usuari amb un login pertant retornem false

        clientConnectat=banc.validar(dni, PIN);    // ara ja tenim la persona connectada amb dni i pin
        if(clientConnectat==null)return false;  // si el client és null es que ha fet el login malament i pertant retornem false
        return true;
        
    }

    public boolean ingresar (String numero, double quantitat){   // aixo ho fem per cridar el metode ingressar del banc


        if(clientConnectat==null)return false;
        return banc.ingressarCompte(numero, quantitat);

    }

    public boolean retirar (String numero, double quantitat){   // aixo ho fem per cridar el metode retirar del banc
        


        if(clientConnectat==null)return false;
        return banc.retirarCompte(numero, quantitat);

    }



    public void iniciar(){    
        Scanner teclat=new Scanner(System.in);
        while(true){
            if(clientConnectat==null){
                System.out.println("ATM BANC");
                System.out.println("DNI: ");
                String dni= teclat.nextLine();
                System.out.println("PIN: ");
                String pin= teclat.nextLine();

                Client c= banc.validar(dni, pin);

                if(c != null){
                    clientConnectat=c;
                    System.out.println("BENVINGUT: "+ clientConnectat.getNom());
                }else{
                    System.out.println("ERROR el dni o pin incorrecte o compte bloquejat");
                }
                
            }else{
                int opcio=0;
                while(opcio != 6 && clientConnectat!=null){
                    System.out.println("MENU PRINCIPAL: ");
                    System.out.println("1. veure els meus comptes");
                    System.out.println("2. consultar saldo");
                    System.out.println("3. ingressar diners");
                    System.out.println("4. retirar diners");
                    System.out.println("5. fer una transferència");
                    System.out.println("6. sortir");
                    System.out.println("selecciona una opció: ");

                    opcio= Integer.parseInt(teclat.nextLine());

                    switch(opcio){
                        case 1:
                            banc.mostrarComptesClient(clientConnectat.getDni());
                            break;
                        case 2: 
                            System.out.println("entra el numero del compte: ");
                            String n2= teclat.nextLine();
                            Compte c2=banc.cercarCompte(n2);
                            if(c2 != null){
                                System.out.println("saldo actual: "+ c2.getSaldo()+" €");
                            }else{
                                System.out.println("compte no trobat");
                            }
                            break;
                        case 3:
                            System.out.println("numero de compte: ");
                            String c3= teclat.nextLine();
                            System.out.println("quantitat a ingressar: ");
                            double q4= Double.parseDouble(teclat.nextLine());
                            if(banc.ingressarCompte(c3, q4)){
                                System.out.println("ingres realitzat");

                            }else{
                                System.out.println("error");
                            }
                            break;
                        case 4:
                            System.out.println("numero de compte: ");
                            String c4= teclat.nextLine();
                            System.out.println("quantitat a retirar: ");
                            double q5= Double.parseDouble(teclat.nextLine());
                            if(banc.retirarCompte(c4, q5)){
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
                            System.out.println("confirma PIN: ");
                            String pinc= teclat.nextLine();
                            if(banc.transfarenciaCompte(co, q6, clientConnectat.getDni(), pinc, cd)){
                                System.out.println("Transfarència realitzada");
                            }else{
                                System.out.println("error a la transfarència");
                            }
                            break;
                        case 6:
                            clientConnectat=null;
                            System.out.println("Sessió tancada");
                            break;
                        default:
                            System.out.println("Opció no vàlida");


                    }
                }
            }
        }
    }

    public Banc getBanc(){
        return this.banc;
    }

    public Client getClientConnectat(){
        return this.clientConnectat;
    }

    public void logout(){
        this.clientConnectat= null;
    }




}