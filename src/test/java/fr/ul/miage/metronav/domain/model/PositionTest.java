package fr.ul.miage.metronav.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PositionTest {

    @Test
    public void testGetLongitude() {
        // Création d'une position avec une longitude spécifique
        double longitude = 2.345;
        double latitude = 48.789;
        Position position = new Position(longitude, latitude);

        // Vérification de la longitude de la position
        assertEquals(longitude, position.getLongitude(), 0.0001);
    }

    @Test
    public void testSetLongitude() {
        // Création d'une position
        Position position = new Position(0.0, 0.0);

        // Modification de la longitude
        double newLongitude = 1.234;
        position.setLongitude(newLongitude);

        // Vérification de la nouvelle longitude
        assertEquals(newLongitude, position.getLongitude(), 0.0001);
    }

    @Test
    public void testGetLatitude() {
        // Création d'une position avec une latitude spécifique
        double longitude = 2.345;
        double latitude = 48.789;
        Position position = new Position(longitude, latitude);

        // Vérification de la latitude de la position
        assertEquals(latitude, position.getLatitude(), 0.0001);
    }

    @Test
    public void testSetLatitude() {
        // Création d'une position
        Position position = new Position(0.0, 0.0);

        // Modification de la latitude
        double newLatitude = 45.678;
        position.setLatitude(newLatitude);

        // Vérification de la nouvelle latitude
        assertEquals(newLatitude, position.getLatitude(), 0.0001);
    }

    @Test
    public void testToString() {
        // Création d'une position
        double longitude = 2.345;
        double latitude = 48.789;
        Position position = new Position(longitude, latitude);

        // Vérification de la représentation en chaîne de caractères
        String expectedString = "(" + longitude + ", " + latitude + ")";
        assertEquals(expectedString, position.toString());
    }
}
