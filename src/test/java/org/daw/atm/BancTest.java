package org.daw.atm;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BancTest {

     @Test
    void Banc_validarCorrecte(){
         Compte.resetContador();  // posem el contador a 1 perqué sinó el contador va augmentant

        Banc banc= new Banc("Test Banc");

        Client resultat= banc.validar("33333333D", "3333");
        assertNotNull(resultat);
        assertEquals("Anna", resultat.getNom());
         
    }

    @Test
    void validar_pinIncorrecte_retornaNull(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        Client resultat= banc.validar("33333333D", "3344");
        assertNull(resultat);
        
         
    }

    @Test
    void validar_dniInexistent_retornaNull(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        Client resultat= banc.validar("35741298D", "3333");
        assertNull(resultat);
        
         
    }

    @Test
    void validar_pinidniIncorrecte_retornaNull(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        Client resultat= banc.validar("35741298D", "3344");
        assertNull(resultat);
        
         
    }

    @Test
    void ingressarCompte_numeroExistent_actualitzaSaldoIRetornaTrue(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.ingressarCompte("ES100-1111-1", 200.0);  // el compte inicial té 100 i li fem un ingrés de 200
        assertTrue(resultat);
        assertEquals(300.0, banc.cercarCompte("ES100-1111-1").getSaldo());
        
         
    }

    @Test
    void ingressarCompte_numeroInexistent_retornaFalse(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.ingressarCompte("ES100-1122-1", 200);  // el compte inicial té 100 i li fem un ingrés de 200
        assertFalse(resultat);
        
        
         
    }


    @Test
    void retirarCompte_dniCorrecteISaldoSuficient_actualitzaSaldoIRetornaTrue(){

        Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.retirarCompte("ES100-1111-1", 50.0, "33333333D");
        assertTrue(resultat);
        assertEquals(50.0, banc.cercarCompte("ES100-1111-1").getSaldo());
     
    }

    @Test
    void retirarCompte_dniIncorrecte_retornaFalse(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.retirarCompte("ES100-1111-1", 50.0, "33333444D");
        assertFalse(resultat);
       
    }


    @Test
    void retirarCompte_saldoInsuficient_retornaFalse(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.retirarCompte("ES100-1111-1", 1150, "33333333D");
        assertFalse(resultat);
       
    }

    @Test
    void retirarCompte_Comptenotrobat_retornaFalse(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.retirarCompte("ES100-1333-1", 1150, "33333333D");
        assertFalse(resultat);
   
    }


    @Test
    void transferenciaCompte_dadesCorrectes_mouDinersEntreComptes(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.transfarenciaCompte("ES100-1111-1", 50.0, "33333333D", "ES100-1111-2");
        //numero= origen= saldo inicial=100
        //numero2= desti= saldo inicial=1000
        assertTrue(resultat);
        assertEquals(350.0, banc.cercarCompte("ES100-1111-2").getSaldo());
        assertEquals(50.0, banc.cercarCompte("ES100-1111-1").getSaldo());
        
    }

    @Test
    void transferenciaCompte_numeroinicialincorrecte_NomouDinersEntreComptes(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.transfarenciaCompte("ES100-1122-1", 50.0, "33333333D", "ES100-1111-2");
        assertFalse(resultat);
        assertEquals(100.0, banc.cercarCompte("ES100-1111-1").getSaldo()); // no es retiren els diners
         
    }

    @Test
    void transferenciaCompte_quantitatincorrecte_NomouDinersEntreComptes(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.transfarenciaCompte("ES100-1111-1", 1550.0, "33333333D", "ES100-1111-2");
        assertFalse(resultat);
        assertEquals(100.0, banc.cercarCompte("ES100-1111-1").getSaldo()); // no es retiren els diners
      
    }

    @Test
    void transferenciaCompte_dniincorrecte_NomouDinersEntreComptes(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.transfarenciaCompte("ES100-1111-1", 50.0, "33335555D", "ES100-1111-2");
        assertFalse(resultat);
        assertEquals(100.0, banc.cercarCompte("ES100-1111-1").getSaldo()); // no es retiren els diners
        
    }

    @Test
    void transferenciaCompte_segonnumeroincorrecte_NomouDinersEntreComptes(){
         Compte.resetContador();

        Banc banc= new Banc("Test Banc");

        boolean resultat= banc.transfarenciaCompte("ES100-1111-1", 50.0, "33333333D", "ES100-1888-2");
        assertFalse(resultat);
        assertEquals(100.0, banc.cercarCompte("ES100-1111-1").getSaldo()); // no es retiren els diners
        
        
        
        
         
    }   
}
