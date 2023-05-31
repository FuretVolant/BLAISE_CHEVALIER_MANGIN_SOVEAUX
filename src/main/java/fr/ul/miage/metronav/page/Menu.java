package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.usecase.GetItineraireImpl;
import fr.ul.miage.metronav.domain.usecase.GetStationsImpl;

public class Menu extends Page {


    private GetStationsImpl getStationsUC;
    private GetItineraireImpl getItiUC;

    public Menu(GetStationsImpl getStationsUC, GetItineraireImpl getItiUC) {
        super();
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;
    }

    @Override
    public void display() {
        System.out.println("Bienvenue dans Metronav");
        System.out.println("Veuillez entrer votre position ci dessous:");

        GetPositionPage gpg = new GetPositionPage(getStationsUC, getItiUC);
        gpg.setPreviousPage(this);
        gpg.display();
    }

}
