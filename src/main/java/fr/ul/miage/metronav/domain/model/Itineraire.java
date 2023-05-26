package fr.ul.miage.metronav.domain.model;

import java.time.LocalTime;
import java.util.List;

public class Itineraire {

    private List<Trajet> trajetList;

    public Itineraire(List<Trajet> trajetList) {
        this.trajetList = trajetList;

    }

    public void ajoutTrajet(Trajet trajet){
        trajetList.add(trajet);
    }

    public int getTempsTotal(){
        int res = 0;
        for (Trajet t : trajetList) {
            res+=t.getDuree();
            res+=t.getStationArrivee().getTemps_arret();
        }
        return res;
    }

}