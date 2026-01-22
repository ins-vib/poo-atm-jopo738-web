package org.daw.atm;

public class Client {
    private String dni;
    private String nom;
    private String pin;
    private int intentsFallits;
    private boolean bloquejat;

    public Client (){
        
    }

    public Client(String dni, String nom, String pin) {
        //this.dni = dni;
        this.nom = nom;
        //this.pin = pin;
        this.setPin(pin);
        this.setDni(dni);
        this.bloquejat=false;
        this.intentsFallits=0;
    }

    public String getDni() {
        return dni;
    }

    public String getNom() {
        return nom;
    }

    public String getPin() {
        return pin;
    }

    public int getIntentsFallits() {
        return intentsFallits;
    }

    public boolean isBloquejat() {
        return bloquejat;
    }

    public void setDni(String dni) {
        if (dni == null || dni.length() != 9){
            throw new IllegalArgumentException("El DNI ha de tenir 9 caràcters");
        }

      

        //"11111111A"
        //substring(0,8)  "11111111"
        String nums= dni.substring(0,8);
        char lletra = Character.toUpperCase(dni.charAt(8));
        //this.dni = dni;
        int numero;
        try {
          numero= Integer.parseInt(nums);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Els primers 8 caràcters han de ser números");
        }

        String lletres = "TRWAGMYPDXBNJZSQVHLCKE";
        //System.out.println(lletra);
          char lletraCalculada=lletres.charAt(numero%23);  
          //System.out.println(lletraCalculada);
          if(lletraCalculada!=lletra){
            throw new IllegalArgumentException("Lletra del DNI incorrecta");
          }

        this.dni= dni.toUpperCase();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPin(String pin) {
        //comprovar que PIN és correcte
        //número de 4 xiferes

        if(pin==null) throw new IllegalArgumentException("El pin ha de tenir un valor");

        if(pin.length()!=4) throw new IllegalArgumentException("Llargada pin incorrecte");

        try {
            
            int num=Integer.parseInt(pin); //agafa un String i el converteix a integer ("1234"--> 1234) o ("123A"-->genera exception)
            this.pin= pin;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Pin incorrecte");
        }
        
        //this.pin = pin;
    }
    public void resetIntents (){
        this.intentsFallits=0;
        this.bloquejat=false;
    }

    
    public boolean comprovarPin (String pinIntroduit){

        // si el client ja està bloquejat, no permetre validació
        if(this.bloquejat){
            return false;
        }

        //PIN correcte
        if(pinIntroduit.equals(this.pin)){
            resetIntents();   // reinici d'intents
            return true;
        }
        
        //PIN incorrecte
            this.intentsFallits++;
            if(this.intentsFallits>=3){    
                this.bloquejat=true;

            }
            return false;
        }

        
        
        
    }





    

