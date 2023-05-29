package fr.ul.miage.metronav.domain.usecase;

import fr.ul.miage.metronav.data.StationRepository;
import fr.ul.miage.metronav.data.TrajetRepository;
import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.service.ServiceItineraire;
import fr.ul.miage.metronav.domain.service.ServiceStation;

public class GetItineraireImpl implements GetItineraire{

    StationRepository stationRepository;
    TrajetRepository trajetRepository;
    ServiceStation serviceStation;
    ServiceItineraire serviceItineraire;


    public GetItineraireImpl(StationRepository stationRepository, TrajetRepository trajetRepository, ServiceStation serviceStation, ServiceItineraire serviceItineraire){
        this.stationRepository = stationRepository;
        this.trajetRepository = trajetRepository;
        this.serviceStation = serviceStation;
        this.serviceItineraire = serviceItineraire;
    }

    @Override
    public Itineraire getItineraireRapide(Position depart, Position arrivee) {

        Station stationDepart = serviceStation.trouverPlusProcheStation(depart, stationRepository.getAllStation());
        Station stationArrivee = serviceStation.trouverPlusProcheStation(arrivee, stationRepository.getAllStation());

        return serviceItineraire.calculerItineraireRapide(stationDepart,  stationArrivee,  stationRepository.getAllStation(), trajetRepository.getAllTrajet());
    }

    @Override
    public Itineraire getItineraireSimple(Position depart, Position arrivee) {
        Station stationDepart = serviceStation.trouverPlusProcheStation(depart, stationRepository.getAllStation());
        Station stationArrivee = serviceStation.trouverPlusProcheStation(arrivee, stationRepository.getAllStation());

        return serviceItineraire.calculerItineraireSimple(stationDepart,  stationArrivee,  stationRepository.getAllStation(), trajetRepository.getAllTrajet());
    }
}
