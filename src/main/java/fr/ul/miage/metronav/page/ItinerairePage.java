package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Trajet;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetStations;

import java.util.ArrayList;
import java.util.List;

public class ItinerairePage extends Page {

    protected List<Itineraire> itineraireList;


    public ItinerairePage(GetStations getStationsUC, GetItineraire getItiUC) {
        super();
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;
        this.itineraireList = new ArrayList<>();
    }

    protected void setItineraireList(List<Itineraire> itis){
        this.itineraireList = itis;
    }

    @Override
    public void display() {
        if (itineraireList.size()>1){
            for (Itineraire i : itineraireList) {
                System.out.println("Itinéraire n°"+itineraireList.indexOf(i));
                afficherTrajets(i.getTrajetList());
            }
        }else if (!itineraireList.isEmpty()){
            System.out.println("Itinéraire :");
            afficherTrajets(itineraireList.get(0).getTrajetList());
        }
    }

    private void afficherTrajets(List<Trajet> trajetList) {
        for (Trajet trajet : trajetList){
            System.out.println("-"+trajet.toString());
        }
    }

}
