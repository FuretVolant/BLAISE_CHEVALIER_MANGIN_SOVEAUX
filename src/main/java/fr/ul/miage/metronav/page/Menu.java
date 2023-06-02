package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Ligne;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.domain.usecase.GetStationsImpl;
import fr.ul.miage.metronav.util.ScannerChoix;

import java.util.HashMap;
import java.util.List;

public class Menu extends Page {


    HashMap<Integer, String> choix;

    public Menu(GetStations getStationsUC, GetItineraire getItiUC) {
        super();
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;

        this.choix = new HashMap<>();

        this.choix.put(1,"Chercher un itinéraire");
        this.choix.put(2,"Voir toutes les stations");
        this.choix.put(3,"Voir les incidents en cours");
    }

    @Override
    public void display() {
        System.out.println("-----------------------");
        System.out.println("Bienvenue dans Metronav");
        System.out.println("-----------------------");
        ScannerChoix scc = new ScannerChoix(choix);

        int choixUser = scc.getValidIntInput("Veuillez choisir une action ci dessous : ");

        switch(choixUser){
            case 1 :
                GetPositionPage gpg = new GetPositionPage(getStationsUC, getItiUC);
                gpg.setPreviousPage(this);
                gpg.display();
                break;
            case 2 :
                List<Station> stationList = getStationsUC.getAllStations();
                for (Station s : stationList){
                    afficherStations(s);
                }
                display();
                break;
            case 3 :
                //TODO appel à la recherche d'itinéraire composé
                break;
        }


    }

    public void afficherStations(Station s){
        System.out.println("Station: " + s.getNom());
        System.out.println("Lignes: " + formatLignesStation(s.getLignes()));
        System.out.println("Temps d'arret à la station: " + s.getTemps_arret());
        if(!s.isSafe()){
            System.out.println("Incident: Oui");
            System.out.println("Nature de l'incident: " + s.getIncident());
        }else{
            System.out.println("Incident: Non");
        }

    }

    public String formatLignesStation(List<Ligne> lignes){
        StringBuilder res = new StringBuilder();
        for (Ligne l : lignes){
            res.append(l.getNumero()).append(" ");
        }
        return String.valueOf(res);
    }

}
