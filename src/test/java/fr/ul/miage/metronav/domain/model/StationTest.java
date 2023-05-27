package fr.ul.miage.metronav.domain.model;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
public class StationTest {

    @Test
    public void testGetNom() {
        // Création d'une station
        Station station = new Station("Gare Centrale", new Position(1.0, 2.0),5, Arrays.asList(new Ligne("L1")), null);

        // Vérification du nom de la station
        assertEquals("Gare Centrale", station.getNom());
    }

    @Test
    public void testGetTempsArret() {
        // Création d'une station
        Station station = new Station("Gare Centrale", new Position(1.0, 2.0),5, Arrays.asList(new Ligne("L1")), null);

        // Vérification du temps d'arrêt de la station
        assertEquals(5, station.getTemps_arret());
    }

    @Test
    public void testGetLignes() {
        // Création d'une station
        Ligne ligne1 = new Ligne("L1");
        Ligne ligne2 = new Ligne("L2");
        List<Ligne> lignes = Arrays.asList(ligne1, ligne2);
        Station station = new Station("Gare Centrale", new Position(1.0, 2.0),5, lignes, null);

        // Vérification des lignes de la station
        assertEquals(lignes, station.getLignes());
    }

    @Test
    public void testGetIncident() {
        // Création d'une station sans incident
        Station stationSansIncident = new Station("Gare Centrale", new Position(1.0, 2.0),5, Arrays.asList(new Ligne("L1")), null);

        // Vérification de l'absence d'incident
        assertNull(stationSansIncident.getIncident());

        // Création d'une station avec incident
        Station stationAvecIncident = new Station("Gare Centrale",new Position(1.0, 2.0), 5, Arrays.asList(new Ligne("L1")), "Problème technique");

        // Vérification de l'incident
        assertEquals("Problème technique", stationAvecIncident.getIncident());
    }
}