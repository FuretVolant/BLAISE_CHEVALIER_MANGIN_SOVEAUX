package fr.ul.miage.metronav.domain.usecase;
import fr.ul.miage.metronav.data.StationLocalRepositoryImpl;
import fr.ul.miage.metronav.data.TrajetLocalRepositoryImpl;
import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;

import fr.ul.miage.metronav.domain.service.*;
import fr.ul.miage.metronav.util.MetroGraph;
import org.junit.jupiter.api.Test;



public class GetItineraireImplTest {

    @Test
    void getRapideItinéraireTest(){

        MetroGraph metroGraph = new MetroGraph();
        StationLocalRepositoryImpl stationRepository = new StationLocalRepositoryImpl();
        stationRepository.setStationList(metroGraph.getStationList());
        TrajetLocalRepositoryImpl trajetRepository = new TrajetLocalRepositoryImpl();
        trajetRepository.setTrajetList(metroGraph.getTrajetList());

        ServiceItineraireRapide serviceItineraireRapide = new ServiceItineraireRapideImpl();

        ServiceItineraireSimple serviceItineraireSimple = new ServiceItineraireSimpleImpl();



        ServiceStation serviceStation = new ServiceStationImpl();

        GetItineraire getItineraireUseCase = new GetItineraireImpl(stationRepository, trajetRepository, serviceStation, serviceItineraireSimple, serviceItineraireRapide);

        Position depart = new Position(0.0, 0.0);
        Position arrivee = new Position(0.0, 6.0);


        Itineraire i = getItineraireUseCase.getItineraireRapide(depart, arrivee);
        //assertEquals("[[Station A : 5 : Station D : 4], [Station D : 4 : Station E : 4], [Station E : 4 : Station F : 4], [Station C : 7 : Station F : 4], [Station G : 4 : Station C : 7], [Station G : 4 : Station H : 4]]", i.getTrajetList().toString());
    }

    @Test
    void getSimpleItinéraireTest(){

        MetroGraph metroGraph = new MetroGraph();
        StationLocalRepositoryImpl stationRepository = new StationLocalRepositoryImpl();
        stationRepository.setStationList(metroGraph.getStationList());
        TrajetLocalRepositoryImpl trajetRepository = new TrajetLocalRepositoryImpl();
        trajetRepository.setTrajetList(metroGraph.getTrajetList());

        ServiceItineraireRapide serviceItineraireRapide = new ServiceItineraireRapideImpl();

        ServiceItineraireSimple serviceItineraireSimple = new ServiceItineraireSimpleImpl();


        ServiceStation serviceStation = new ServiceStationImpl();

        GetItineraire getItineraireUseCase = new GetItineraireImpl(stationRepository, trajetRepository, serviceStation, serviceItineraireSimple, serviceItineraireRapide);

        Position depart = new Position(0.0, 0.0);
        Position arrivee = new Position(0.0, 6.0);


        Itineraire i = getItineraireUseCase.getItineraireSimple(depart, arrivee);
        //assertEquals("[[Station A : 5 : Station B : 4], [Station B : 4 : Station C : 7], [Station C : 7 : Station F : 4], [Station G : 4 : Station F : 4], [Station G : 4 : Station H : 4]]", i.getTrajetList().toString());
    }
}
