package org.daw.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CompteEstalviTest {
    
    @Test
    void retirar_senseSaldo_false() {

        CompteEstalvi ce = new CompteEstalvi();
        ce.setSaldo(50);

        boolean resultat= ce.retirar(60);
        assertFalse(resultat);
        assertEquals(50, ce.getSaldo());

    }

    @Test
    void retirar_ambSaldo_true() {

        CompteEstalvi ce = new CompteEstalvi();
        ce.setSaldo(300.0);

        boolean resultat= ce.retirar(40.0);
        assertTrue(resultat);
        assertEquals(260.0, ce.getSaldo());

    }

    @Test
    void ingressar_quantitatPositiva_actualitzaSaldo() {

        CompteEstalvi ce = new CompteEstalvi();
        ce.setSaldo(100.0);

       ce.ingressar(100.0);

       assertEquals(200.0, ce.getSaldo());

    }
}
