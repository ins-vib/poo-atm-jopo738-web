package org.daw.atm;

public class Client {
    private String dni;
    private String nom;
    private String pin;
    private int intentsFallits;
    private boolean bloquejat;

    public Client(String dni, String nom, String pin) {
        this.dni = dni;
        this.nom = nom;
        this.pin = pin;
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
        char lletra = dni.charAt(8);
        //this.dni = dni;

        try {
          int numero= Integer.parseInt(nums);
          String lletres = "TRWAGMYPDXBNJZSQVHLCKE";
          char lletraCalculada=lletres.charAt(numero%23);  
          if(lletraCalculada!=lletra){
            throw new IllegalArgumentException("Lletra del DNI incorrecta");
          }

          this.dni=dni;

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Els primers 8 caràcters han de ser números");
        }
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPin(String pin) throws Exception {
        //comprovar que PIN és correcte
        //número de 4 xiferes
        try {
            if(pin.length()!=4) throw new Exception("Llargada pin incorrecta");
            int num=Integer.parseInt(pin); //agafa un String i el converteix a integer ("1234"--> 1234) o ("123A"-->genera exception)
            
            this.pin= pin;
        } catch (Exception e) {
            throw new Exception("Pin incorrecte");
        }
        
        this.pin = pin;
    }
    public void resetIntents (){
        this.intentsFallits=0;
        this.bloquejat=false;
    }

    
    public boolean comprovarPin (String pinIntroduit){
        if(this.bloquejat){
            return false;
        }
        if(pinIntroduit.equals(this.pin)){
            resetIntents();
            return true;
        }else{
            intentsFallits++;
            if(intentsFallits==3){
                this.bloquejat=true;

            }
            return false;
        }
        
        
    }





    
}
