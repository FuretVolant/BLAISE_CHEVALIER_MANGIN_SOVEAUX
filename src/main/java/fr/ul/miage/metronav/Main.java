package fr.ul.miage.metronav;

import fr.ul.miage.metronav.data.StationLocalRepositoryImpl;
import fr.ul.miage.metronav.data.TrajetLocalRepositoryImpl;
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

        GetStationsImpl getStationsUC = new GetStationsImpl(stationRepository);
        GetItineraireImpl getItiUC = new GetItineraireImpl(stationRepository, trajetRepository);

        Menu menu = new Menu(getStationsUC, getItiUC);
        menu.display();
    }
}