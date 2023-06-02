package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetStations;

import java.util.ArrayList;
import java.util.List;

public class ItinerairePage extends Page {

    protected List<Itineraire> itineraireList;


    public ItinerairePage(GetStations getStationsUC, GetItineraire getItiUC) {
        super();
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
                System.out.println(i.getTrajetList().toString());
            }
        }else if(itineraireList.size()==1){
            System.out.println(itineraireList.get(0).getTrajetList().toString());
        }
    }

}
