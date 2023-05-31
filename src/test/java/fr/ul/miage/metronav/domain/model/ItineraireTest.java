package fr.ul.miage.metronav.domain.model;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ItineraireTest {

    @Test
    void testAjoutTrajet() {
        // Création d'un itinéraire vide
        List<Trajet> trajets = new ArrayList<>();
        Itineraire itineraire = new Itineraire(trajets);

        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale", new Position(-1.0, 20.0),5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord", new Position(10.0, -2.0),10, Arrays.asList(new Ligne("L1")), null);


        // Création d'un trajet
        List<Ligne> lignes = new ArrayList<>();
        lignes.add(new Ligne("Ligne 1"));
        lignes.add(new Ligne("Ligne 4"));
        Trajet trajet = new Trajet(stationDepart,stationArrivee,4,lignes);

        // Ajout du trajet à l'itinéraire
        itineraire.ajoutTrajet(trajet);

        // Vérification de l'ajout du trajet
        assertEquals(1, trajets.size());
        assertTrue(trajets.contains(trajet));
    }

    @Test
    void testGetTempsTotal() {

        // Création d'une station de départ
        Station stationDepart1 = new Station("Gare Centrale",new Position(1.0, 2.0), 5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee1 = new Station("Gare du Nord",new Position(3.0, 2.0), 20, Arrays.asList(new Ligne("L1")), null);


        List<Ligne> lignes = new ArrayList<>();
        lignes.add(new Ligne("Ligne 1"));
        lignes.add(new Ligne("Ligne 4"));
        // Création d'un trajet
        Trajet trajet1 = new Trajet(stationDepart1,stationArrivee1,4,lignes);

        // Création d'une station de départ
        Station stationDepart2 = new Station("Gare du Sud",new Position(4.0, 4.0), 7, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee2 = new Station("Gare de l'Est",new Position(8.0, 2.0), 10, Arrays.asList(new Ligne("L1")), null);


        // Création d'un trajet
        Trajet trajet2 = new Trajet(stationDepart2,stationArrivee2,4, lignes);



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
