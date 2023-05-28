package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.util.ScannerChoix;

import java.util.HashMap;

public class GetCriterePage extends Page{

    HashMap<Integer, String> choixCritere = new HashMap<>();

    public GetCriterePage() {
        this.choixCritere.put(1,"Normal");
        this.choixCritere.put(2,"Simple");
        this.choixCritere.put(3,"Composé");
    }

    @Override
    public void display() {
        ScannerChoix scc = new ScannerChoix(choixCritere);
        int choixUser = scc.getValidIntInput("Choisissez quel type d'itinéraire vous souhaitez : ");
        switch(choixUser){
            case 1 :
                //TODO appel à la recherche d'itinéraire lambda
                break;
            case 2 :
                //TODO appel à la recherche d'itinéraire simple
                break;
            case 3 :
                //TODO appel à la recherche d'itinéraire composé
                break;

        }
    }
}
