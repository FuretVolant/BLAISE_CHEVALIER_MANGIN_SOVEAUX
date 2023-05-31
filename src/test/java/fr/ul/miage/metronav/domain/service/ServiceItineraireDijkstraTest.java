package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.data.StationLocalRepositoryImpl;
import fr.ul.miage.metronav.data.TrajetLocalRepositoryImpl;
import fr.ul.miage.metronav.domain.model.*;
import fr.ul.miage.metronav.util.MetroGraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceItineraireDijkstraTest {
    @Test
    public void testcalculerItineraireSimple() {
        MetroGraph metroGraph = new MetroGraph();
        StationLocalRepositoryImpl stationRepository = new StationLocalRepositoryImpl();
        stationRepository.setStationList(metroGraph.getStationList());
        TrajetLocalRepositoryImpl trajetRepository = new TrajetLocalRepositoryImpl();
        trajetRepository.setTrajetList(metroGraph.getTrajetList());

        List<Station> stationList = stationRepository.getAllStation();
        List<Trajet> trajetList = trajetRepository.getAllTrajet();

        Station stationA_depart = stationList.get(0);
        Station stationH_arrivee = stationList.get(7);

        System.out.println(stationA_depart.getNom());
        System.out.println(stationH_arrivee.getNom());

        System.out.println(stationList);
        System.out.println(trajetList);


        ServiceItineraire serviceItineraire = new ServiceItineraireDijkstra();
        Itineraire i = serviceItineraire.calculerItineraireSimple(stationA_depart, stationH_arrivee, stationList, trajetList);
        //assertEquals("[[Station A : 5 : Station B : 4], [Station B : 4 : Station C : 7], [Station C : 7 : Station F : 4], [Station G : 4 : Station F : 4], [Station G : 4 : Station H : 4]]", i.getTrajetList().toString());
    }

    @Test
    public void testcalculerItineraireSimple2() {
        List<Station> stationList = new ArrayList<>();

        List<Trajet> trajetList = new ArrayList<>();


        List<Ligne> lignesA = new ArrayList<>();
        lignesA.add(new Ligne("Ligne 4"));
        lignesA.add(new Ligne("Ligne 3"));
        Station stationA = new Station("Station A", new Position(1.0, 2.0), 5, lignesA, "");

        // Station B
        List<Ligne> lignesB = new ArrayList<>();
        lignesB.add(new Ligne("Ligne 1"));
        lignesB.add(new Ligne("Ligne 3"));
        Station stationB = new Station("Station B", new Position(3.0, 4.0), 4, lignesB, "");

        // Station C
        List<Ligne> lignesC = new ArrayList<>();
        lignesC.add(new Ligne("Ligne 1"));
        lignesC.add(new Ligne("Ligne 3"));
        lignesC.add(new Ligne("Ligne 2"));
        Station stationC = new Station("Station C", new Position(5.0, 5.0), 7, lignesC, "");

        // Station D
        List<Ligne> lignesD = new ArrayList<>();
        lignesD.add(new Ligne("Ligne 3"));
        lignesD.add(new Ligne("Ligne 5"));
        lignesD.add(new Ligne("Ligne 2"));
        Station stationD = new Station("Station D", new Position(6.0, 2.0), 4, lignesD, "");

        // Station E
        List<Ligne> lignesE = new ArrayList<>();
        lignesE.add(new Ligne("Ligne 4"));
        lignesE.add(new Ligne("Ligne 2"));
        Station stationE = new Station("Station E", new Position(9.0, 4.0), 4, lignesE, "");

        // Station F
        List<Ligne> lignesF = new ArrayList<>();
        lignesF.add(new Ligne("Ligne 2"));
        lignesF.add(new Ligne("Ligne 5"));
        Station stationF = new Station("Station F", new Position(7.0, 8.0), 4, lignesF, "");

        List<Ligne> lignesAB = new ArrayList<>();
        lignesAB.add(new Ligne("Ligne 3"));
        Trajet trajetAB = new Trajet(stationA, stationB, 100, lignesAB);

        List<Ligne> lignesBC = new ArrayList<>();
        lignesBC.add(new Ligne("Ligne 1"));
        lignesBC.add(new Ligne("Ligne 3"));
        Trajet trajetBC = new Trajet(stationB, stationC, 100, lignesBC);

        List<Ligne> lignesCD = new ArrayList<>();
        lignesCD.add(new Ligne("Ligne 3"));
        Trajet trajetCD = new Trajet(stationC, stationD, 100, lignesCD);

        List<Ligne> lignesAE = new ArrayList<>();
        lignesAE.add(new Ligne("Ligne 4"));
        Trajet trajetAE = new Trajet(stationA, stationE, 1, lignesAE);

        List<Ligne> lignesEF = new ArrayList<>();
        lignesEF.add(new Ligne("Ligne 2"));
        Trajet trajetEF = new Trajet(stationE, stationF, 1, lignesEF);

        List<Ligne> lignesCF = new ArrayList<>();
        lignesCF.add(new Ligne("Ligne 2"));
        Trajet trajetCF = new Trajet(stationC, stationF, 1, lignesCF);

        List<Ligne> lignesBF = new ArrayList<>();
        lignesBF.add(new Ligne("Ligne 5"));
        Trajet trajetBF = new Trajet(stationB, stationF, 1, lignesBF);

        List<Ligne> lignesFD = new ArrayList<>();
        lignesFD.add(new Ligne("Ligne 2"));
        Trajet trajetFD = new Trajet(stationD, stationF, 1, lignesFD);

        stationList.add(stationA);
        stationList.add(stationB);
        stationList.add(stationC);
        stationList.add(stationD);
        stationList.add(stationE);
        stationList.add(stationF);

        trajetList.add(trajetAB);
        trajetList.add(trajetBC);
        trajetList.add(trajetAE);
        trajetList.add(trajetBF);
        trajetList.add(trajetFD);
        trajetList.add(trajetEF);
        trajetList.add(trajetCF);
        trajetList.add(trajetCD);

        ServiceItineraire serviceItineraire = new ServiceItineraireDijkstra();
        Itineraire i = serviceItineraire.calculerItineraireSimple(stationA, stationD, stationList, trajetList);
        //assertEquals("[[Station A : 5 : Station B : 4], [Station B : 4 : Station C : 7], [Station C : 7 : Station D : 4]]", i.getTrajetList().toString());

    }


    @Test
    void testSameLine(){
        ServiceItineraireDijkstra serviceItineraire = new ServiceItineraireDijkstra();

        List<Ligne> lignesA = new ArrayList<>();
        lignesA.add(new Ligne("Ligne 4"));
        lignesA.add(new Ligne("Ligne 3"));
        Station stationA = new Station("Station A", new Position(1.0, 2.0), 5, lignesA, "");

        // Station B
        List<Ligne> lignesB = new ArrayList<>();
        lignesB.add(new Ligne("Ligne 1"));
        lignesB.add(new Ligne("Ligne 3"));
        Station stationB = new Station("Station B", new Position(3.0, 4.0), 4, lignesB, "");

        // Station C
        List<Ligne> lignesC = new ArrayList<>();
        lignesC.add(new Ligne("Ligne 1"));
        lignesC.add(new Ligne("Ligne 3"));
        lignesC.add(new Ligne("Ligne 2"));
        Station stationC = new Station("Station C", new Position(5.0, 5.0), 7, lignesC, "");

        List<Ligne> lignesAB = new ArrayList<>();
        lignesAB.add(new Ligne("Ligne 3"));
        Trajet trajetAB = new Trajet(stationA, stationB, 100, lignesAB);

        List<Ligne> lignesBC = new ArrayList<>();
        //lignesBC.add(new Ligne("Ligne 1"));
        lignesBC.add(new Ligne("Ligne 3"));
        Trajet trajetBC = new Trajet(stationB, stationC, 100, lignesBC);

        assert(serviceItineraire.sameLine(trajetAB,trajetBC));


    }
}
