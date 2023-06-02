package fr.ul.miage.metronav;

import fr.ul.miage.metronav.data.StationLocalRepositoryImpl;
import fr.ul.miage.metronav.data.TrajetLocalRepositoryImpl;
import fr.ul.miage.metronav.domain.service.*;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetItineraireImpl;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.domain.usecase.GetStationsImpl;
import fr.ul.miage.metronav.page.Menu;
import fr.ul.miage.metronav.util.MetroGraph;

public class Main {
    public static void main(String[] args) {
        MetroGraph metroGraph = new MetroGraph();
        StationLocalRepositoryImpl stationRepository = new StationLocalRepositoryImpl();
        stationRepository.setStationList(metroGraph.getStationList());
        TrajetLocalRepositoryImpl trajetRepository = new TrajetLocalRepositoryImpl();
        trajetRepository.setTrajetList(metroGraph.getTrajetList());

        ServiceItineraireRapide serviceItineraireRapide = new ServiceItineraireRapideImpl();

        ServiceItineraireSimple serviceItineraireSimple = new ServiceItineraireSimpleImpl();

        ServiceStation serviceStation = new ServiceStationImpl();

        GetStations getStations = new GetStationsImpl(stationRepository);

        GetItineraire getItineraireUseCase = new GetItineraireImpl(stationRepository, trajetRepository, serviceStation, serviceItineraireSimple, serviceItineraireRapide);

        Menu menu = new Menu(getStations, getItineraireUseCase);
        menu.display();
    }
}