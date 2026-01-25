package org.daw.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
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

    @Test
    void testRetirarCorrecte2(){
        Compte compte = new Compte();
        compte.setSaldo(100);
        boolean resultat=compte.retirar(100);
        assertTrue(resultat);
        assertEquals(0, compte.getSaldo());


    }

    @Test
    void testRetirarQuantitatIncorrecte(){
        Compte compte = new Compte();
        compte.setSaldo(100);
        boolean resultat=compte.retirar(-50);
        assertFalse(resultat);
        assertEquals(100, compte.getSaldo());

        assertEquals(0,compte.getMoviments().size());
        // assertEquals(50,compte.getMoviments().get(0).getQuantitat());
        // assertEquals(TipusMoviment.RETIRADA, compte.getMoviments().get(0).getTipus());

        


    }

    @Test
    void testRetirarQuantitatIncorrecte2(){
        Compte compte = new Compte();
        compte.setSaldo(100);
        boolean resultat=compte.retirar(101);
        assertFalse(resultat);
        assertEquals(100.0, compte.getSaldo());


    }

    

    

    @Test
    void testTransfarenciaCorrecte(){
        Compte origen = new Compte();
        Compte desti = new Compte();
        origen.setSaldo(100);
        desti.setSaldo(50);
        
        
        boolean resultat = origen.transferencia(desti, 30);
        
        assertTrue(resultat);
        assertEquals(70, origen.getSaldo());
        assertEquals(80, desti.getSaldo());
        

    }

    @Test
    void testCalculaInteresAnual() {
        Compte compte = new Compte();
        compte.setSaldo(1000);
        compte.setInteresAnual(5); 
        
        
        double resultat = compte.calculaInteresAnual();
        
        assertEquals(1050, resultat);
        assertEquals(1050, compte.getSaldo());
    }

    @Test
    void testIngressarMoviment() {
        Compte compte = new Compte();
        compte.setSaldo(100);
        
        
        compte.ingressar(50);
        
        assertEquals(150, compte.getSaldo());
        
        assertEquals(1, compte.getMoviments().size());
        assertEquals(TipusMoviment.INGRES, compte.getMoviments().get(0).getTipus());
    }
    
}
