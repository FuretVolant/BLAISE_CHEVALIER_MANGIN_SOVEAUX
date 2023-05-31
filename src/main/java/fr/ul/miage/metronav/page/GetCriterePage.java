package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;
import fr.ul.miage.metronav.domain.service.ServiceItineraireImpl;
import fr.ul.miage.metronav.domain.usecase.GetItineraireImpl;
import fr.ul.miage.metronav.domain.usecase.GetStationsImpl;
import fr.ul.miage.metronav.util.ScannerChoix;

import java.security.Provider;
import java.util.HashMap;
import java.util.List;

public class GetCriterePage extends Page{

    HashMap<Integer, String> choixCritere = new HashMap<>();
    Station depart;
    Station arrivee;
    private GetStationsImpl getStationsUC;
    private GetItineraireImpl getItiUC;

    public GetCriterePage(Station depart, Station arrivee, GetStationsImpl getStationsUC, GetItineraireImpl getItiUC) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;
        this.choixCritere.put(1,"Rapide");
        this.choixCritere.put(2,"Simple");
        this.choixCritere.put(3,"Composé");
    }

    @Override
    public void display() {
        ScannerChoix scc = new ScannerChoix(choixCritere);
        int choixUser = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez : ");

        ServiceItineraireImpl servIti = new ServiceItineraireImpl();
        
        Itineraire res = new Itineraire();

        switch(choixUser){
            case 1 :
                res = servIti.calculerItineraireRapide(depart, arrivee, getStationsUC.getAllStations(), getItiUC.getAllTrajets());
                break;
            case 2 :
                res = servIti.calculerItineraireSimple(depart , arrivee, getStationsUC.getAllStations(), getItiUC.getAllTrajets());
                break;
            case 3 :
                //TODO appel à la recherche d'itinéraire composé
                break;

        }

        System.out.println(res.getTrajetList().toString());
    }
}
