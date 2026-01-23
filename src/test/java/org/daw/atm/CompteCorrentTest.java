package org.daw.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CompteCorrentTest {
    
    @Test
    void retirar_dinsLimitDescobert_funciona(){

        CompteCorrent cc= new CompteCorrent(50.0,100.0);

        boolean resultat= cc.retirar(130);
        assertTrue(resultat);
        assertEquals(-30, cc.getSaldo());

       

    }

    @Test
    void retirar_superaLimitDescobert_fals(){

        CompteCorrent cc= new CompteCorrent(50.0,100.0);

        boolean resultat= cc.retirar(160);
        assertFalse(resultat);
        assertEquals(100.0, cc.getSaldo());
        
    }

    @Test
    void setLimitDescobert_negatiu_llencaExcepcio(){

        CompteCorrent cc= new CompteCorrent();

        try {

            cc.setLimitDescobert(-10.0);
            
        } catch (IllegalArgumentException e) {
            //ok
        }

        
        
    }


    
}
