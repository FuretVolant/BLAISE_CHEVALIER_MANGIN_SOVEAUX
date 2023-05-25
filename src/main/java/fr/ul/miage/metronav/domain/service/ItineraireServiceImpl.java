package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.List;

public class ItineraireServiceImpl implements  ItineraireService{
    @Override
    public Itineraire calculerItineraireRapide(Station depart, Station arrive, List<Station> stationList, List<Trajet> trajetList) {
        return null;
    }

    @Override
    public Itineraire calculerItineraireSimple(Station depart, Station arrive, List<Station> stationList, List<Trajet> trajetList) {
        return null;
    }
}
