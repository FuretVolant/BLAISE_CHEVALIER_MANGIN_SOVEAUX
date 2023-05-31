package fr.ul.miage.metronav.domain.usecase;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.List;

public interface  GetItineraire {

    Itineraire getItineraireRapide(Position depart, Position arrivee);

    Itineraire getItineraireSimple(Position depart, Position arrivee);

    List<Trajet> getAllTrajets();



}
