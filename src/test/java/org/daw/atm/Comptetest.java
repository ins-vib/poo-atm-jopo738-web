package org.daw.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class Comptetest {
    @Test
    void testRetirarCorrecte(){
        Compte compte = new Compte();
        compte.setSaldo(100);
        boolean resultat=compte.retirar(50);
        assertTrue(resultat);
        assertEquals(50, compte.getSaldo());


    }
    
}
