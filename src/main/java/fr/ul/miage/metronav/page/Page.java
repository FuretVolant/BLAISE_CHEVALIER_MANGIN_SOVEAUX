package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetStations;

public abstract class Page {
    protected Page previousPage;

    protected GetStations getStationsUC;
    protected GetItineraire getItiUC;

    public void setPreviousPage(Page previousPage) {
        this.previousPage = previousPage;
    }

    public abstract void display();

    public void goToPreviousPage() {
        if (previousPage != null) {
            previousPage.display();
        } else {
            System.out.println("Il n'y a pas de page précédente.");
        }
    }
}
