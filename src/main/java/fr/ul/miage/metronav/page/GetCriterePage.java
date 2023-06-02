package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.util.ScannerChoix;

import java.util.*;
import java.util.List;

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

        this.choixCritere.put(1,"Rapide");
        this.choixCritere.put(2,"Simple");
        this.choixCritere.put(3,"Composé");
        this.choixCritere.put(4,"Retour");
    }

    @Override
    public void display() {
        System.out.println("-----------------------");
        System.out.println("Choix du critère");
        System.out.println("-----------------------");
        ScannerChoix scc = new ScannerChoix(choixCritere);
        int choixUser = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez : ");

        List<Itineraire> res = new ArrayList<>();

        switch(choixUser){
            case 1 :
                res = Collections.singletonList(getItiUC.getItineraireRapide(depart, arrivee));
                break;
            case 2 :
                res = Collections.singletonList(getItiUC.getItineraireSimple(depart , arrivee));
                break;
            case 3 :
                GetMultipleDestinationPage gmdp = new GetMultipleDestinationPage(depart, arrivee, getStationsUC, getItiUC);
                gmdp.setPreviousPage(this);
                gmdp.display();
            case 4 :
                goToPreviousPage();
        }

        ItinerairePage itiPage = new ItinerairePage(getStationsUC, getItiUC);
        itiPage.setItineraireList(res);
        itiPage.setPreviousPage(this);
        itiPage.display();
    }
}
