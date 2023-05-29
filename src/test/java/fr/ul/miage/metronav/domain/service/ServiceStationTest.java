package fr.ul.miage.metronav.domain.service;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceStationTest {

    @Test
    public void testTrouverPlusProcheStationVide() {
        // Position de référence pour les tests
        Position position = new Position(0.0, 0.0);
        // Test lorsque la liste des stations est vide
        List<Station> listeStationsVide = new ArrayList<>();
        Station stationPlusProcheVide = new ServiceStationImpl().trouverPlusProcheStation(position, listeStationsVide);
        Assertions.assertNull(stationPlusProcheVide);
    }

    @Test
    public void testTrouverPlusProcheStationUnique() {
        // Position de référence pour les tests
        Position position = new Position(0.0, 0.0);

        List<Station> listeStationsUnique = new ArrayList<>();
        // Test avec une seule station dans la liste
        Station stationUnique = new Station("Station Unique", new Position(10.0, 10.0), 5, new ArrayList<>(), "");
        listeStationsUnique.add(stationUnique);
        Station stationPlusProcheUnique = new ServiceStationImpl().trouverPlusProcheStation(position, listeStationsUnique);
        Assertions.assertEquals(stationUnique, stationPlusProcheUnique);
    }

    @Test
    public void testTrouverPlusProcheStationList() {
        // Création de quelques stations pour les tests
        Station stationA = new Station("Station A", new Position(-1.0, 2.0), 3, new ArrayList<>(), "");
        Station stationB = new Station("Station B", new Position(3.0, 4.0), 2, new ArrayList<>(), "");
        Station stationC = new Station("Station C", new Position(-5.0, 6.0), 3, new ArrayList<>(), "");
        Station stationD = new Station("Station D", new Position(7.0, 8.0), 4, new ArrayList<>(), "");

        List<Station> listeStations = new ArrayList<>();
        listeStations.add(stationA);
        listeStations.add(stationB);
        listeStations.add(stationC);
        listeStations.add(stationD);

        // Position de référence pour les tests
        Position position = new Position(0.0, 0.0);

        // Test avec plusieurs stations dans la liste
        Station stationPlusProche = new ServiceStationImpl().trouverPlusProcheStation(position, listeStations);
        Assertions.assertEquals(stationA, stationPlusProche);

    }
}
