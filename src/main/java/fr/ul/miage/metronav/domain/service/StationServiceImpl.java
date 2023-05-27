package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;

import java.util.List;

public class StationServiceImpl implements StationService{

    @Override
    public Station trouverPlusProcheStation(Position position, List<Station> listeStation) {
        Station plusProcheStation = null;
        double distanceMin = Double.MAX_VALUE;

        for (Station station : listeStation) {
            double distance = calculerDistance(position, station.getPosition());
            if (distance < distanceMin) {
                distanceMin = distance;
                plusProcheStation = station;
            }
        }

        return plusProcheStation;
    }

    private double calculerDistance(Position position1, Position position2) {
        double lat1 = position1.getLatitude();
        double lon1 = position1.getLongitude();
        double lat2 = position2.getLatitude();
        double lon2 = position2.getLongitude();

        // Formule de calcul de distance entre deux points géographiques (Haversine)
        double earthRadius = 6371; // Rayon moyen de la Terre en kilomètres
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }
}
