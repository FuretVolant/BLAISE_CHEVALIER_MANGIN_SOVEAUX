package fr.ul.miage.metronav.domain.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TrajetTest {

    @Test
    public void testGetStationDepart() {
        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale",new Position(1.0, 2.0), 5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord",new Position(1.0, 2.0), 10, Arrays.asList(new Ligne("L1")), null);

        // Création d'un trajet avec cette station de départ
        Trajet trajet = new Trajet(stationDepart, stationArrivee, 3);

        // Vérification de la station de départ du trajet
        assertEquals(stationDepart, trajet.getStationDepart());
    }

    @Test
    public void testGetStationArrivee() {
        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale", new Position(1.0, 2.0),5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord", new Position(1.0, 2.0),10, Arrays.asList(new Ligne("L1")), null);

        // Création d'un trajet avec cette station de départ
        Trajet trajet = new Trajet(stationDepart, stationArrivee, 3);

        // Vérification de la station d'arrivée du trajet
        assertEquals(stationArrivee, trajet.getStationArrivee());
    }

    @Test
    public void testGetDuree() {
        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale", new Position(1.0, 2.0),5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord", new Position(1.0, 2.0),10, Arrays.asList(new Ligne("L1")), null);

        // Création d'un trajet avec cette station de départ
        Trajet trajet = new Trajet(stationDepart, stationArrivee, 3);

        int duree = 3;


        // Vérification de la durée du trajet
        assertEquals(duree, trajet.getDuree());
    }
}