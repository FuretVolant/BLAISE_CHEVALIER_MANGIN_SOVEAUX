package fr.ul.miage.metronav.util;

import fr.ul.miage.metronav.domain.model.Ligne;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.ArrayList;
import java.util.List;

public class MetroGraph {

    private final List<Station> stationList;

    private final List<Trajet> trajetList;

    public MetroGraph(){
        this.trajetList = new ArrayList<>();
        this.stationList = new ArrayList<>();
        addStation();
    }

    private void addStation(){

        // Station A
        List<Ligne> lignesA = new ArrayList<>();
        lignesA.add(new Ligne("Ligne 2"));
        lignesA.add(new Ligne("Ligne 3"));
        Station stationA = new Station("Station A", new Position(1.0, 2.0), 5, lignesA, "");

        // Station B
        List<Ligne> lignesB = new ArrayList<>();
        lignesB.add(new Ligne("Ligne 1"));
        lignesB.add(new Ligne("Ligne 2"));
        Station stationB = new Station("Station B", new Position(3.0, 4.0), 4, lignesB, "");

        // Station C
        List<Ligne> lignesC = new ArrayList<>();
        lignesC.add(new Ligne("Ligne 1"));
        lignesC.add(new Ligne("Ligne 3"));
        Station stationC = new Station("Station C", new Position(5.0, 5.0), 7, lignesC, "");

        // Station D
        List<Ligne> lignesD = new ArrayList<>();
        lignesD.add(new Ligne("Ligne 3"));
        lignesD.add(new Ligne("Ligne 4"));
        Station stationD = new Station("Station D", new Position(6.0, 2.0), 4, lignesD, "");

        // Station E
        List<Ligne> lignesE = new ArrayList<>();
        lignesE.add(new Ligne("Ligne 4"));
        Station stationE = new Station("Station E", new Position(9.0, 4.0), 4, lignesE, "");

        // Station F
        List<Ligne> lignesF = new ArrayList<>();
        lignesF.add(new Ligne("Ligne 1"));
        lignesF.add(new Ligne("Ligne 4"));
        Station stationF = new Station("Station F", new Position(7.0, 8.0), 4, lignesF, "");

        // Station F
        List<Ligne> lignesG = new ArrayList<>();
        lignesF.add(new Ligne("Ligne 1"));
        lignesF.add(new Ligne("Ligne 4"));
        lignesF.add(new Ligne("Ligne 3"));
        Station stationG = new Station("Station G", new Position(2.0, 9.0), 4, lignesG, "");

        // Station F
        List<Ligne> lignesH = new ArrayList<>();
        lignesF.add(new Ligne("Ligne 2"));
        lignesF.add(new Ligne("Ligne 4"));
        Station stationH = new Station("Station H", new Position(1.0, 6.0), 4, lignesH, "");

        // Station F
        List<Ligne> lignesI = new ArrayList<>();
        lignesF.add(new Ligne("Ligne 2"));
        Station stationI = new Station("Station I", new Position(3.0, 6.0), 4, lignesI, "Incident Notable");


        Trajet tragetAB = new Trajet(stationA,stationB, 40);
        Trajet tragetBC = new Trajet(stationB,stationC, 30);
        Trajet tragetBI = new Trajet(stationA,stationI, 1);
        Trajet tragetAD = new Trajet(stationA,stationD, 17);
        Trajet tragetDE = new Trajet(stationD,stationE, 12);
        Trajet tragetEF = new Trajet(stationE,stationF, 13);
        Trajet tragetCF = new Trajet(stationC,stationF, 15);
        Trajet tragetGF = new Trajet(stationG,stationF, 40);
        Trajet tragetGH = new Trajet(stationG,stationH, 18);
        Trajet tragetHI = new Trajet(stationH,stationI, 1);
        Trajet tragetGC = new Trajet(stationG,stationC, 2);
        Trajet tragetCD = new Trajet(stationC,stationD, 2);//incident




    }





    public List<Station> getStationList() {
        return stationList;
    }
}
