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


        List<Ligne> lignesAB = new ArrayList<>();
        lignesAB.add(new Ligne("Ligne 2"));
        Trajet tragetAB = new Trajet(stationA,stationB, 40,lignesAB);

        List<Ligne> lignesBC = new ArrayList<>();
        lignesBC.add(new Ligne("Ligne 1"));
        Trajet tragetBC = new Trajet(stationB,stationC, 30,lignesBC);

        List<Ligne> lignesBI = new ArrayList<>();
        lignesBI.add(new Ligne("Ligne 2"));
        Trajet tragetBI = new Trajet(stationB,stationI, 1,lignesBI);

        List<Ligne> lignesAD = new ArrayList<>();
        lignesAD.add(new Ligne("Ligne 3"));
        Trajet tragetAD = new Trajet(stationA,stationD, 17,lignesAD);

        List<Ligne> lignesDE = new ArrayList<>();
        lignesDE.add(new Ligne("Ligne 4"));
        Trajet tragetDE = new Trajet(stationD,stationE, 12,lignesDE);

        List<Ligne> lignesEF = new ArrayList<>();
        lignesEF.add(new Ligne("Ligne 4"));
        Trajet tragetEF = new Trajet(stationE,stationF, 13,lignesEF);

        List<Ligne> lignesCF = new ArrayList<>();
        lignesCF.add(new Ligne("Ligne 1"));
        Trajet tragetCF = new Trajet(stationC,stationF, 15,lignesCF);

        List<Ligne> lignesGF = new ArrayList<>();
        lignesGF.add(new Ligne("Ligne 1"));
        lignesGF.add(new Ligne("Ligne 4"));
        Trajet tragetGF = new Trajet(stationG,stationF, 40,lignesGF);

        List<Ligne> lignesGH = new ArrayList<>();
        lignesGH.add(new Ligne("Ligne 2"));
        Trajet tragetGH = new Trajet(stationG,stationH, 18,lignesGH);

        List<Ligne> lignesHI = new ArrayList<>();
        lignesHI.add(new Ligne("Ligne 2"));
        Trajet tragetHI = new Trajet(stationH,stationI, 1,lignesHI);

        List<Ligne> lignesGC = new ArrayList<>();
        lignesGC.add(new Ligne("Ligne 3"));
        Trajet tragetGC = new Trajet(stationG,stationC, 2,lignesGC);

        List<Ligne> lignesCD = new ArrayList<>();
        lignesF.add(new Ligne("Ligne 2"));
        Trajet tragetCD = new Trajet(stationC,stationD, 2, "Trajet fermé pour travaux",lignesCD);//incident


        this.stationList.add(stationA);
        this.stationList.add(stationB);
        this.stationList.add(stationC);
        this.stationList.add(stationD);
        this.stationList.add(stationE);
        this.stationList.add(stationF);
        this.stationList.add(stationG);
        this.stationList.add(stationH);
        this.stationList.add(stationI);

        this.trajetList.add(tragetAB);
        this.trajetList.add(tragetBC);
        this.trajetList.add(tragetBI);
        this.trajetList.add(tragetAD);
        this.trajetList.add(tragetDE);
        this.trajetList.add(tragetEF);
        this.trajetList.add(tragetCF);
        this.trajetList.add(tragetGF);
        this.trajetList.add(tragetGH);
        this.trajetList.add(tragetHI);
        this.trajetList.add(tragetGC);
        this.trajetList.add(tragetCD);

    }


    public List<Station> getStationList() {
        return stationList;
    }

    public List<Trajet> getTrajetList(){
        return trajetList;
    }
}
