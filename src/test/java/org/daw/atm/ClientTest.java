package org.daw.atm;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class ClientTest {
    
    @Test
    void setDni_null_llencaExcepcio(){
        Client c= new Client();

        try {
            
            c.setDni(null);
            fail("s'esperava una IllegalArgumentException");  // aixo força l'error
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    @Test
    void setDni_incomplet_llencaExcepcio(){
        Client c= new Client();

        try {
            
            c.setDni("12");
            fail("s'esperava una IllegalArgumentException");  // aixo força l'error
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    @Test
    void setDni_lletres_llencaExcepcio(){
        Client c= new Client();

        try {
            
            c.setDni("HHH");
            fail("s'esperava una IllegalArgumentException");  // aixo força l'error
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    @Test
    void setPin_null_llencaExcepcio(){
        Client c= new Client();

        try {
            
            c.setPin(null);
            fail("s'esperava una IllegalArgumentException");  // aixo força l'error
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    @Test
    void setPin_incomplet_llencaExcepcio(){
        Client c= new Client();

        try {
            
            c.setPin("12");
            fail("s'esperava una IllegalArgumentException");  // aixo força l'error
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    @Test
    void setPin_lletres_llencaExcepcio(){
        Client c= new Client();

        try {
            
            c.setPin("HHH");
            fail("s'esperava una IllegalArgumentException");  // aixo força l'error
        } catch (IllegalArgumentException e) {
            //ok
        }
    }

    @Test
    void comprovaPin_clientbloquejat_llencaExcepcio(){
        Client c= new Client();
        c.setPin("3333");

        c.comprovarPin("4444");
        c.comprovarPin("5214");
        c.comprovarPin("7894");
        c.comprovarPin("3333");
        assertFalse(false);

    }

    @Test
    void comprovaPin_pinincorrecte_llencaExcepcio(){
        Client c= new Client();
        c.setPin("3333");

        
            
        assertFalse(c.comprovarPin("1234"));
           
    }

    @Test
    void comprovaPin_correcte(){
        Client c= new Client();
        c.setPin("3333");
        assertTrue(c.comprovarPin("3333"));

    }




}
