package fr.ul.miage.metronav.util;

import fr.ul.miage.metronav.domain.model.Ligne;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

public class MetroGraph {

    private final List<Station> stationList;

    public MetroGraph(){
        this.stationList = new ArrayList<>();
        addStation();
    }

    private void addStation(){

        // Station A
        List<Ligne> lignesA = new ArrayList<>();
        lignesA.add(new Ligne("Ligne 1"));
        lignesA.add(new Ligne("Ligne 3"));
        this.stationList.add(new Station("Station A", new Position(1.0, 2.0), 3, lignesA, ""));

        // Station B
        List<Ligne> lignesB = new ArrayList<>();
        lignesB.add(new Ligne("Ligne 1"));
        lignesB.add(new Ligne("Ligne 2"));
        this.stationList.add(new Station("Station B", new Position(3.0, 4.0), 2, lignesB, ""));

        // Station C
        List<Ligne> lignesC = new ArrayList<>();
        lignesC.add(new Ligne("Ligne 2"));
        this.stationList.add(new Station("Station C", new Position(5.0, 6.0), 3, lignesC, ""));

        // Station D
        List<Ligne> lignesD = new ArrayList<>();
        lignesD.add(new Ligne("Ligne 3"));
        this.stationList.add(new Station("Station D", new Position(7.0, 8.0), 4, lignesD, ""));

        // Station E
        List<Ligne> lignesE = new ArrayList<>();
        lignesE.add(new Ligne("Ligne 1"));
        lignesE.add(new Ligne("Ligne 2"));
        this.stationList.add(new Station("Station E", new Position(9.0, 10.0), 3, lignesE, ""));

        // Station F
        List<Ligne> lignesF = new ArrayList<>();
        lignesF.add(new Ligne("Ligne 1"));
        lignesF.add(new Ligne("Ligne 3"));
        this.stationList.add(new Station("Station F", new Position(11.0, 12.0), 4, lignesF, ""));

    }

    public List<Station> getStationList() {
        return stationList;
    }
}
