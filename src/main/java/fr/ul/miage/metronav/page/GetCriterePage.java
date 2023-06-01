package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.service.ServiceItineraireRapide;
import fr.ul.miage.metronav.domain.service.ServiceItineraireRapideImpl;
import fr.ul.miage.metronav.domain.service.ServiceItineraireSimple;
import fr.ul.miage.metronav.domain.service.ServiceItineraireSimpleImpl;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetItineraireImpl;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.domain.usecase.GetStationsImpl;
import fr.ul.miage.metronav.util.ScannerChoix;
import java.util.HashMap;

public class GetCriterePage extends Page{

    HashMap<Integer, String> choixCritere = new HashMap<>();
    Station depart;
    Station arrivee;
    private final GetStations getStationsUC;
    private final GetItineraire getItiUC;

    public GetCriterePage(Station depart, Station arrivee, GetStations getStationsUC, GetItineraire getItiUC) {
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

        ServiceItineraireRapide serviceItineraireRapide = new ServiceItineraireRapideImpl();
        ServiceItineraireSimple serviceItineraireSimple = new ServiceItineraireSimpleImpl();

        
        Itineraire res = new Itineraire();

        switch(choixUser){
            case 1 :
                res = serviceItineraireRapide.calculerItineraireRapide(depart, arrivee, getStationsUC.getAllStations(), getItiUC.getAllTrajets());
                break;
            case 2 :
                res = serviceItineraireSimple.calculerItineraireSimple(depart , arrivee, getStationsUC.getAllStations(), getItiUC.getAllTrajets());
                break;
            case 3 :
                //TODO appel à la recherche d'itinéraire composé
                break;
                //TODO case 0 : retour
        }

        System.out.println(res.getTrajetList().toString());
    }
}
