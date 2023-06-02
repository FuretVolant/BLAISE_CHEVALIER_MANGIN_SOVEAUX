package fr.ul.miage.metronav.domain.model;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrajetTest {

    @Test
    void testGetStationDepart() {
        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale",new Position(1.0, 2.0), 5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord",new Position(1.0, 2.0), 10, Arrays.asList(new Ligne("L1")), null);

        // Création d'un trajet avec cette station de départ
        List<Ligne> lignes = new ArrayList<>();
        lignes.add(new Ligne("Ligne 1"));
        lignes.add(new Ligne("Ligne 4"));
        Trajet trajet = new Trajet(stationDepart, stationArrivee, 3,lignes);

        // Vérification de la station de départ du trajet
        assertEquals(stationDepart, trajet.getStationDepart());
    }

    @Test
    void testGetStationArrivee() {
        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale", new Position(1.0, 2.0),5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord", new Position(1.0, 2.0),10, Arrays.asList(new Ligne("L1")), null);

        // Création d'un trajet avec cette station de départ
        List<Ligne> lignes = new ArrayList<>();
        lignes.add(new Ligne("Ligne 1"));
        lignes.add(new Ligne("Ligne 4"));
        Trajet trajet = new Trajet(stationDepart, stationArrivee, 3, lignes);

        // Vérification de la station d'arrivée du trajet
        assertEquals(stationArrivee, trajet.getStationArrivee());
    }

    @Test
    void testGetDuree() {
        // Création d'une station de départ
        Station stationDepart = new Station("Gare Centrale", new Position(1.0, 2.0),5, Arrays.asList(new Ligne("L1")), null);
        // Création d'une station d'arrrivée
        Station stationArrivee = new Station("Gare du Nord", new Position(1.0, 2.0),10, Arrays.asList(new Ligne("L1")), null);

        // Création d'un trajet avec cette station de départ
        List<Ligne> lignes = new ArrayList<>();
        lignes.add(new Ligne("Ligne 1"));
        lignes.add(new Ligne("Ligne 4"));
        Trajet trajet = new Trajet(stationDepart, stationArrivee, 3,lignes);

        int duree = 3;


        // Vérification de la durée du trajet
        assertEquals(duree, trajet.getDuree());
    }
}