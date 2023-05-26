package fr.ul.miage.metronav.domain.model;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ItineraireTest {

    @Test
    public void testAjoutTrajet() {
        // Création d'un itinéraire vide
        List<Trajet> trajets = new ArrayList<>();
        Itineraire itineraire = new Itineraire(trajets);

        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale", 5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord", 10, Arrays.asList(new Ligne("L1")), null);


        // Création d'un trajet
        Trajet trajet = new Trajet(stationDepart,stationArrivee,4);

        // Ajout du trajet à l'itinéraire
        itineraire.ajoutTrajet(trajet);

        // Vérification de l'ajout du trajet
        assertEquals(1, trajets.size());
        assertTrue(trajets.contains(trajet));
    }

    @Test
    public void testGetTempsTotal() {

        // Création d'une station de départ
        Station stationDepart1 = new Station("Gare Centrale", 5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee1 = new Station("Gare du Nord", 20, Arrays.asList(new Ligne("L1")), null);


        // Création d'un trajet
        Trajet trajet1 = new Trajet(stationDepart1,stationArrivee1,4);

        // Création d'une station de départ
        Station stationDepart2 = new Station("Gare du Sud", 7, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee2 = new Station("Gare de l'Est", 10, Arrays.asList(new Ligne("L1")), null);


        // Création d'un trajet
        Trajet trajet2 = new Trajet(stationDepart2,stationArrivee2,4);



        // Création d'un itinéraire avec des trajets
        List<Trajet> trajets = new ArrayList<>();
        trajets.add(trajet1);
        trajets.add(trajet2);
        Itineraire itineraire = new Itineraire(trajets);

        // Calcul du temps total
        int tempsTotal = itineraire.getTempsTotal();

        int expectedTempsTotal = 38;

        // Vérification du temps total
        assertEquals(expectedTempsTotal, tempsTotal); // Remplacez expectedTempsTotal par la valeur attendue
    }
}
