package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.util.ScannerChoix;

import java.util.HashMap;

public class GetCriterePage extends Page{

    HashMap<Integer, String> choixCritere = new HashMap<>();
    Position depart;
    Position arrivee;
    private final GetStations getStationsUC;
    private final GetItineraire getItiUC;

    public GetCriterePage(Position depart, Position arrivee, GetStations getStationsUC, GetItineraire getItiUC) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;

        this.choixCritere.put(0,"Retour");
        this.choixCritere.put(1,"Rapide");
        this.choixCritere.put(2,"Simple");
        this.choixCritere.put(3,"Composé");
    }

    @Override
    public void display() {
        ScannerChoix scc = new ScannerChoix(choixCritere);
        int choixUser = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez : ");

        Itineraire res = new Itineraire();

        switch(choixUser){
            case 1 :
                res = getItiUC.getItineraireRapide(depart, arrivee);
                break;
            case 2 :
                res = getItiUC.getItineraireSimple(depart , arrivee);
                break;
            case 3 :
                //TODO appel à la recherche d'itinéraire composé
                break;
                //TODO case 0 : retour
        }

        System.out.println(res.getTrajetList().toString());
    }
}
