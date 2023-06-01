package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.List;

public interface ServiceItineraireSimple {

    public Itineraire calculerItineraireSimple(Station depart, Station arrive, List<Station> stationList, List<Trajet> trajetList);

}
