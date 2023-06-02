package fr.ul.miage.metronav.domain.usecase;
import fr.ul.miage.metronav.data.StationLocalRepositoryImpl;
import fr.ul.miage.metronav.data.TrajetLocalRepositoryImpl;
import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;

import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;
import fr.ul.miage.metronav.domain.service.*;
import fr.ul.miage.metronav.util.MetroGraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class GetItineraireImplTest {

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

        GetItineraire getItineraireUseCase = new GetItineraireImpl(stationRepository, trajetRepository, serviceStation,serviceItineraireSimple, serviceItineraireRapide);

        Position depart = new Position(0.0, 0.0);
        Position arrivee = new Position(0.0, 6.0);

        Station stationA = new Station("Station A", new Position(1.0, 2.0), 5, new ArrayList<>(), "");
        Station stationD = new Station("Station D", new Position(7.0, 8.0), 4, new ArrayList<>(), "");
        Station stationE = new Station("Station E", new Position(9.0, 10.0), 4, new ArrayList<>(), "");
        Station stationF = new Station("Station F", new Position(11.0, 12.0), 4, new ArrayList<>(), "");
        Station stationC = new Station("Station C", new Position(5.0, 6.0), 7, new ArrayList<>(), "");
        Station stationG = new Station("Station G", new Position(13.0, 14.0), 4, new ArrayList<>(), "");
        Station stationH = new Station("Station H", new Position(15.0, 16.0), 4, new ArrayList<>(), "");

        Trajet trajet1 = new Trajet(stationA, stationD, 4, new ArrayList<>());
        Trajet trajet2 = new Trajet(stationD, stationE, 4, new ArrayList<>());
        Trajet trajet3 = new Trajet(stationE, stationF, 4, new ArrayList<>());
        Trajet trajet4 = new Trajet(stationC, stationF, 7, new ArrayList<>());
        Trajet trajet5 = new Trajet(stationG, stationC, 7, new ArrayList<>());
        Trajet trajet6 = new Trajet(stationG, stationH, 4, new ArrayList<>());

        List<Trajet> trajetList = new ArrayList<>();
        trajetList.add(trajet1);
        trajetList.add(trajet2);
        trajetList.add(trajet3);
        trajetList.add(trajet4);
        trajetList.add(trajet5);
        trajetList.add(trajet6);


        Itineraire i = getItineraireUseCase.getItineraireRapide(depart, arrivee);
        assertEquals(trajetList, i.getTrajetList());
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

        Station stationA = new Station("Station A", new Position(1.0, 2.0), 5, new ArrayList<>(), "");
        Station stationB = new Station("Station B", new Position(3.0, 4.0), 4, new ArrayList<>(), "");
        Station stationC = new Station("Station C", new Position(5.0, 6.0), 7, new ArrayList<>(), "");
        Station stationF = new Station("Station F", new Position(11.0, 12.0), 4, new ArrayList<>(), "");
        Station stationG = new Station("Station G", new Position(13.0, 14.0), 4, new ArrayList<>(), "");
        Station stationH = new Station("Station H", new Position(15.0, 16.0), 4, new ArrayList<>(), "");

        Trajet trajet1 = new Trajet(stationA, stationB, 4, new ArrayList<>());
        Trajet trajet2 = new Trajet(stationB, stationC, 7, new ArrayList<>());
        Trajet trajet3 = new Trajet(stationC, stationF, 4, new ArrayList<>());
        Trajet trajet4 = new Trajet(stationG, stationF, 4, new ArrayList<>());
        Trajet trajet5 = new Trajet(stationG, stationH, 4, new ArrayList<>());

        List<Trajet> trajets = new ArrayList<>();
        trajets.add(trajet1);
        trajets.add(trajet2);
        trajets.add(trajet3);
        trajets.add(trajet4);
        trajets.add(trajet5);
        assertEquals( trajets, i.getTrajetList());
    }
}
