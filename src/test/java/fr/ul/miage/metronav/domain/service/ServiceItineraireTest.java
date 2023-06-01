package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.data.StationLocalRepositoryImpl;
import fr.ul.miage.metronav.data.TrajetLocalRepositoryImpl;
import fr.ul.miage.metronav.domain.model.*;
import fr.ul.miage.metronav.util.MetroGraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ServiceItineraireTest {


    @Test
    public void testcalculerItineraireRapide(){


        MetroGraph metroGraph = new MetroGraph();
        StationLocalRepositoryImpl stationRepository = new StationLocalRepositoryImpl();
        stationRepository.setStationList(metroGraph.getStationList());
        TrajetLocalRepositoryImpl trajetRepository = new TrajetLocalRepositoryImpl();
        trajetRepository.setTrajetList(metroGraph.getTrajetList());

        List<Station> stationList = stationRepository.getAllStations();
        List<Trajet> trajetList = trajetRepository.getAllTrajet();

        Station stationA_depart = stationList.get(0);
        Station stationH_arrivee = stationList.get(7);

        System.out.println(stationA_depart.getNom());
        System.out.println(stationH_arrivee.getNom());


        ServiceItineraireRapide serviceItineraire = new ServiceItineraireRapideImpl();
        Itineraire i = serviceItineraire.calculerItineraireRapide(stationA_depart, stationH_arrivee, stationList, trajetList);
        //assertEquals("[[Station A : 5 : Station D : 4], [Station D : 4 : Station E : 4], [Station E : 4 : Station F : 4], [Station C : 7 : Station F : 4], [Station G : 4 : Station C : 7], [Station G : 4 : Station H : 4]]", i.getTrajetList().toString());
    }

    @Test
    public void testcalculerItineraireSimple(){


        MetroGraph metroGraph = new MetroGraph();
        StationLocalRepositoryImpl stationRepository = new StationLocalRepositoryImpl();
        stationRepository.setStationList(metroGraph.getStationList());
        TrajetLocalRepositoryImpl trajetRepository = new TrajetLocalRepositoryImpl();
        trajetRepository.setTrajetList(metroGraph.getTrajetList());

        List<Station> stationList = stationRepository.getAllStations();
        List<Trajet> trajetList = trajetRepository.getAllTrajet();

        Station stationA_depart = stationList.get(0);
        Station stationH_arrivee = stationList.get(7);

        System.out.println(stationA_depart.getNom());
        System.out.println(stationH_arrivee.getNom());


        ServiceItineraireSimple serviceItineraire = new ServiceItineraireSimpleImpl();
        Itineraire i = serviceItineraire.calculerItineraireSimple(stationA_depart, stationH_arrivee, stationList, trajetList);
        //assertEquals("[[Station A : 5 : Station B : 4], [Station B : 4 : Station C : 7], [Station C : 7 : Station F : 4], [Station G : 4 : Station F : 4], [Station G : 4 : Station H : 4]]", i.getTrajetList().toString());
    }

    @Test
    public void testcalculerItineraireSimple2(){
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
        Trajet tragetAB = new Trajet(stationA,stationB, 100,lignesAB);

        List<Ligne> lignesBC = new ArrayList<>();
        lignesBC.add(new Ligne("Ligne 1"));
        lignesBC.add(new Ligne("Ligne 3"));
        Trajet tragetBC = new Trajet(stationB,stationC, 100,lignesBC);

        List<Ligne> lignesCD = new ArrayList<>();
        lignesCD.add(new Ligne("Ligne 3"));
        Trajet tragetCD = new Trajet(stationC,stationD, 100,lignesCD);

        List<Ligne> lignesAE = new ArrayList<>();
        lignesAE.add(new Ligne("Ligne 4"));
        Trajet tragetAE = new Trajet(stationA,stationE, 1,lignesAE);

        List<Ligne> lignesEF = new ArrayList<>();
        lignesEF.add(new Ligne("Ligne 2"));
        Trajet tragetEF = new Trajet(stationE,stationF, 1,lignesEF);

        List<Ligne> lignesCF = new ArrayList<>();
        lignesCF.add(new Ligne("Ligne 2"));
        Trajet tragetCF = new Trajet(stationC,stationF, 1,lignesCF);

        List<Ligne> lignesBF = new ArrayList<>();
        lignesBF.add(new Ligne("Ligne 5"));
        Trajet tragetBF = new Trajet(stationB,stationF, 1,lignesBF);

        List<Ligne> lignesFD = new ArrayList<>();
        lignesFD.add(new Ligne("Ligne 2"));
        Trajet tragetFD = new Trajet(stationD,stationF, 1,lignesFD);

        stationList.add(stationA);
        stationList.add(stationB);
        stationList.add(stationC);
        stationList.add(stationD);
        stationList.add(stationE);
        stationList.add(stationF);

        trajetList.add(tragetAB);
        trajetList.add(tragetBC);
        trajetList.add(tragetAE);
        trajetList.add(tragetBF);
        trajetList.add(tragetFD);
        trajetList.add(tragetEF);
        trajetList.add(tragetCF);
        trajetList.add(tragetCD);

        ServiceItineraireSimple serviceItineraire = new ServiceItineraireSimpleImpl();
        Itineraire i = serviceItineraire.calculerItineraireSimple(stationA, stationD, stationList, trajetList);
        //assertEquals("[[Station A : 5 : Station B : 4], [Station B : 4 : Station C : 7], [Station C : 7 : Station D : 4]]", i.getTrajetList().toString());

    }
    @Test
    public void testcalculerItineraprivateireRapide2(){
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
        Trajet tragetAB = new Trajet(stationA,stationB, 100,lignesAB);

        List<Ligne> lignesBC = new ArrayList<>();
        lignesBC.add(new Ligne("Ligne 1"));
        lignesBC.add(new Ligne("Ligne 3"));
        Trajet tragetBC = new Trajet(stationB,stationC, 100,lignesBC);

        List<Ligne> lignesCD = new ArrayList<>();
        lignesCD.add(new Ligne("Ligne 3"));
        Trajet tragetCD = new Trajet(stationC,stationD, 100,lignesCD);

        List<Ligne> lignesAE = new ArrayList<>();
        lignesAE.add(new Ligne("Ligne 4"));
        Trajet tragetAE = new Trajet(stationA,stationE, 1,lignesAE);

        List<Ligne> lignesEF = new ArrayList<>();
        lignesEF.add(new Ligne("Ligne 2"));
        Trajet tragetEF = new Trajet(stationE,stationF, 1,lignesEF);

        List<Ligne> lignesCF = new ArrayList<>();
        lignesCF.add(new Ligne("Ligne 2"));
        Trajet tragetCF = new Trajet(stationC,stationF, 1,lignesCF);

        List<Ligne> lignesBF = new ArrayList<>();
        lignesBF.add(new Ligne("Ligne 5"));
        Trajet tragetBF = new Trajet(stationB,stationF, 1,lignesBF);

        List<Ligne> lignesFD = new ArrayList<>();
        lignesFD.add(new Ligne("Ligne 2"));
        Trajet tragetFD = new Trajet(stationD,stationF, 1,lignesFD);

        stationList.add(stationA);
        stationList.add(stationB);
        stationList.add(stationC);
        stationList.add(stationD);
        stationList.add(stationE);
        stationList.add(stationF);

        trajetList.add(tragetAB);
        trajetList.add(tragetBC);
        trajetList.add(tragetAE);
        trajetList.add(tragetBF);
        trajetList.add(tragetFD);
        trajetList.add(tragetEF);
        trajetList.add(tragetCF);
        trajetList.add(tragetCD);

        ServiceItineraireRapide serviceItineraire = new ServiceItineraireRapideImpl();
        Itineraire i = serviceItineraire.calculerItineraireRapide(stationA, stationD, stationList, trajetList);
        //assertEquals("[[Station A : 5 : Station E : 4], [Station E : 4 : Station F : 4], [Station D : 4 : Station F : 4]]", i.getTrajetList().toString());
    }
}
