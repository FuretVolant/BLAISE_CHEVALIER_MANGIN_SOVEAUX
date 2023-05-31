package fr.ul.miage.metronav.domain.usecase;

import fr.ul.miage.metronav.data.StationRepository;
import fr.ul.miage.metronav.data.TrajetRepository;
import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.List;

public class GetItineraireImpl implements GetItineraire{

    StationRepository stationRepository;
    TrajetRepository trajetRepository;

    public GetItineraireImpl(StationRepository stationRepository, TrajetRepository trajetRepository){
        this.stationRepository = stationRepository;
        this.trajetRepository = trajetRepository;
    }

    @Override
    public Itineraire getItineraireRapide(Position depart, Position arrivee) {
        return null;
    }

    @Override
    public Itineraire getItineraireSimple(Position depart, Position arrivee) {
        return null;
    }

    @Override
    public List<Trajet> getAllTrajets() {
        return trajetRepository.getAllTrajet();
    }
}
