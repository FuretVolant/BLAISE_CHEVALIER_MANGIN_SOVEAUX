package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetItineraireImpl;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.domain.usecase.GetStationsImpl;
import fr.ul.miage.metronav.util.ScannerChoix;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu extends Page {


    private GetStations getStationsUC;
    private GetItineraire getItiUC;

    HashMap<Integer, String> choix;

    public Menu(GetStations getStationsUC, GetItineraire getItiUC) {
        super();
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;
        //Nathan sale fdp
        //les attributs faut les inititialiser
        //gros chien
        //jte deteste
        this.choix = new HashMap<>();
        //enculé


        this.choix.put(1,"Chercher un itinéraire");
        this.choix.put(2,"Voir toutes les stations");
        this.choix.put(3,"Voir les incidents en cours");
    }

    @Override
    public void display() {
        System.out.println("Bienvenue dans Metronav");
        System.out.println("-----------------------");
        ScannerChoix scc = new ScannerChoix(choix);

        int choixUser = scc.getValidIntInput("Veuillez choisir une action ci dessous : ");

        switch(choixUser){
            case 1 :
                GetPositionPage gpg = new GetPositionPage(getStationsUC, getItiUC);
                gpg.setPreviousPage(this);
                gpg.display();                break;
            case 2 :
                //TODO appel voir toutes les stations
                break;
            case 3 :
                //TODO appel à la recherche d'itinéraire composé
                break;

        }


    }

}
