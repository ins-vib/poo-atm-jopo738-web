package org.daw.atm;

public class Banc {
    
    private String nom;
    private Client[] clients;  // posem el [] perque pot teneir un o mes clients  // aixo crea una taula clients que no te res assignat valor nul
    private Compte[] comptes;

    public Banc(String nom) {
        this.nom = nom;

        clients=new Client[5]; //clients tenia un valor nul, pero ara li hem assignat un array de 5

        clients[0]=new Client("33333333D","Anna","3333");  // dins array de clients li assignem un client amb les seves dades
        clients[1]=new Client("44444444A","Josep","4444");
        clients[2]=new Client("55555555E","Jordi","5555");
        clients[3]=new Client("66666666V","Jaume","6666");
        clients[4]=new Client("77777777N","Nemo","7777");

        comptes=new Compte[10];
        comptes[0]= new CompteCorrent(200,100); // ens permet ficar "new CompteCorrent" perque és fill sinó no ens deixaria
        comptes[0].setTitular(clients[0]);

        comptes[1]= new CompteEstalvi(1000,300);
        comptes[1].setTitular(clients[0]);

        comptes[2]=new CompteCorrent(200,100);
        comptes[2].setTitular(clients[1]);

        comptes[3]=new CompteEstalvi(1000,300);
        comptes[3].setTitular(clients[1]);

        comptes[4]=new CompteCorrent(200,100);
        comptes[4].setTitular(clients[2]);

        comptes[5]=new CompteEstalvi(1000,300);
        comptes[5].setTitular(clients[2]);

        comptes[6]=new CompteCorrent(200,100);
        comptes[6].setTitular(clients[3]);

        comptes[7]=new CompteEstalvi(1000,300);
        comptes[7].setTitular(clients[3]);

        comptes[8]=new CompteCorrent(200,100);
        comptes[8].setTitular(clients[4]);

        comptes[9]=new Compte();
        comptes[9].setTitular(clients[4]);
    }

    public String getNom() {
        return nom;
    }

    

    public Client validar(String dni, String pin){

        for(Client cli: this.clients){

            if(cli.getDni().equals(dni)){

                if(cli.comprovarPin(pin)){
                    return cli;
                }
                return null;
        }
        }
        return null;
    }

    public void mostrarComptes(){
        for(Compte c: this.comptes){
            //c.set   // si intentem entrar a setsaldominim no ens deix ja que aquest atribut només es troba a comptes estalvi, pertnat no ho podem fer de manera directa, però si de manera indirecta
            System.out.println(c);
        }
    }

    public void IncrementarSaldoMinimComptesEstalvi(){   // aquesta és la manera de fer, de manera indirecta  (aixo ho fem servir per metodes exclusius)
        for(Compte c: this.comptes){
            if(c instanceof CompteEstalvi){ // pregunta a c si el tipus es de CompteEstalvi amb el instanceof amb el "instanceof" podem veure quin tipude variable és
                CompteEstalvi ce = (CompteEstalvi)c;    // li estem dient que aquest ompte amb la (c) és un CompteEstalvi li diem perque hem posat CompteEstalvi i al costat del parentesi la "c"
                ce.setSaldoMinim(ce.getSaldoMinim()+1000);

            }
        }
    }

    public boolean ingressarCompte(String numero, double quantitat){


        for(Compte c: comptes) {   // si no troba compte retorna false
            if(c.numero.equals(numero)){
                c.ingressar(quantitat); // reutilitzem el ingressar
                return true;

            }
        }
        return false;
    }

    public boolean retirarCompte(String numero, double quantitat){


        for(Compte c: comptes) {   // si no troba compte retorna false
            if(c.numero.equals(numero)){
                c.retirar(quantitat); // reutilitzem el retirar
                return true;

            }
        }
        return false;
    }

    public boolean transfarenciaCompte (String numero, double quantitat, String dni, String PIN, String numero2){
        if(validar(dni, PIN)==null)return false;
        Compte origen = cercarCompte(numero);
        Compte desti = cercarCompte(numero2);
        if(origen != null && desti != null)return origen.transferencia(desti, quantitat);
        return false;
    }

    public void mostrarComptesClient(String dni){
        boolean teComptes = false;
        for(Compte c: this.comptes){
            if(c != null && c.getTitular() != null){
                if(c.getTitular().getDni().equals(dni))
                System.out.println(c.toString());
                teComptes = true;
            }
        }
        if(!teComptes){
            System.out.println("Aquest client no té comptes!!");
        }

        
    }

    public Compte cercarCompte(String num){
        for(Compte c: comptes){
            if(c != null && c.getNumero().equals(num)) return c;

        }
        return null;
    }

  

   


}
