package org.daw.atm;

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


}