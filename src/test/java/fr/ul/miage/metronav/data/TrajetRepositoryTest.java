package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Ligne;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrajetRepositoryTest {

    @Test
    void testgetAlltraget(){

        TrajetLocalRepositoryImpl trajetRepository = new TrajetLocalRepositoryImpl();

        List<Trajet> trajetList = new ArrayList<>();

        Station stationA = new Station("Station A", new Position(1.0, 2.0), 5, new ArrayList<>(), "");
        Station stationB = new Station("Station B", new Position(3.0, 4.0), 4, new ArrayList<>(), "");
        Station stationC = new Station("Station C", new Position(5.0, 5.0), 7, new ArrayList<>(), "");

        Trajet tragetAB = new Trajet(stationA,stationB, 100,new ArrayList<>());
        Trajet tragetBC = new Trajet(stationB,stationC, 100,new ArrayList<>());


        trajetRepository.setTrajetList(trajetList);

        trajetList.add(tragetAB);
        trajetList.add(tragetBC);

        assertEquals(trajetList, trajetRepository.getAllTrajet());

    }
}
