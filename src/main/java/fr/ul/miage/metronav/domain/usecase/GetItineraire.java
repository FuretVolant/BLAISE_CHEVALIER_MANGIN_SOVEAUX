package fr.ul.miage.metronav.domain.usecase;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;

public interface  GetItineraire {

    Itineraire getItineraireRapide(Position depart, Position arrivee);

    Itineraire getItineraireSimple(Position depart, Position arrivee);





}
