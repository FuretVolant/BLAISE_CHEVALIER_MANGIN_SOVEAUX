package fr.ul.miage.metronav.domain.model;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

class LigneTest {

    @Test
    void testGetNumero() {
        // Création d'une ligne avec un numéro spécifique
        String numero = "L1";
        Ligne ligne = new Ligne(numero);

        // Vérification du numéro de la ligne
        assertEquals(numero, ligne.getNumero());
    }
}