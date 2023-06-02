package fr.ul.miage.metronav.domain.usecase;

import fr.ul.miage.metronav.data.StationRepository;
import fr.ul.miage.metronav.data.TrajetRepository;
import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;

import fr.ul.miage.metronav.domain.model.Trajet;
import fr.ul.miage.metronav.domain.service.ServiceItineraireRapide;
import fr.ul.miage.metronav.domain.service.ServiceItineraireSimple;
import fr.ul.miage.metronav.domain.service.ServiceStation;

import java.util.ArrayList;
import java.util.List;

public class GetItineraireImpl implements GetItineraire{

    StationRepository stationRepository;
    TrajetRepository trajetRepository;
    ServiceStation serviceStation;
    ServiceItineraireSimple serviceItineraireSimple;
    ServiceItineraireRapide serviceItineraireRapide;


    public GetItineraireImpl(StationRepository stationRepository, TrajetRepository trajetRepository, ServiceStation serviceStation, ServiceItineraireSimple serviceItineraireSimple, ServiceItineraireRapide serviceItineraireRapide){
        this.stationRepository = stationRepository;
        this.trajetRepository = trajetRepository;
        this.serviceStation = serviceStation;
        this.serviceItineraireSimple = serviceItineraireSimple;
        this.serviceItineraireRapide = serviceItineraireRapide;
    }

    @Override
    public Itineraire getItineraireRapide(Position depart, Position arrivee) {

        Station stationDepart = serviceStation.trouverPlusProcheStation(depart, stationRepository.getAllStations());
        Station stationArrivee = serviceStation.trouverPlusProcheStation(arrivee, stationRepository.getAllStations());

        return serviceItineraireRapide.calculerItineraireRapide(stationDepart,  stationArrivee,  stationRepository.getAllStations(), trajetRepository.getAllTrajet());
    }

    @Override
    public Itineraire getItineraireSimple(Position depart, Position arrivee) {
        Station stationDepart = serviceStation.trouverPlusProcheStation(depart, stationRepository.getAllStations());
        Station stationArrivee = serviceStation.trouverPlusProcheStation(arrivee, stationRepository.getAllStations());

        return serviceItineraireSimple.calculerItineraireSimple(stationDepart,  stationArrivee,  stationRepository.getAllStations(), trajetRepository.getAllTrajet());
    }
    @Override
    public List<Itineraire> getItineraireCompose(List<Position> positions){
        List<Itineraire> itineraires = new ArrayList<>();
        for (int i =0; i < positions.size()-2; i++){
            Station stationDepart = serviceStation.trouverPlusProcheStation(positions.get(i), stationRepository.getAllStations());
            Station stationArrivee = serviceStation.trouverPlusProcheStation(positions.get(i+1), stationRepository.getAllStations());
        itineraires.add(serviceItineraireRapide.calculerItineraireRapide(stationDepart,stationArrivee,  stationRepository.getAllStations(), trajetRepository.getAllTrajet()));
        }

        return itineraires;
    }

    @Override
    public List<Trajet> getAllTrajets() {
        return trajetRepository.getAllTrajet();
    }
}
