package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Itineraire;
import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.util.ScannerDouble;
import fr.ul.miage.metronav.util.ScannerInt;

import java.util.ArrayList;
import java.util.List;

public class GetMultipleDestinationPage extends Page{
        Position depart;
        Position arrivee;
    public GetMultipleDestinationPage(Position depart, Position arrivee, GetStations getStationsUC, GetItineraire getItiUC) {
        this.depart = depart;
        this.arrivee = arrivee;
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;
    }

    @Override
    public void display() {
        System.out.println("-----------------------");
        System.out.println("Itinéraire composé");
        System.out.println("-----------------------");

        List<Position> arrets= new ArrayList<>();
        arrets.add(depart);
        int nbArrets = getNbArretsFromUser();
        arrets.addAll(getDestinationsFromUser("Entrez la position de  l'arrêt n°", nbArrets));
        arrets.add(arrivee);

        List<Itineraire> res = getItiUC.getItineraireCompose(arrets);

        ItinerairePage itiPage = new ItinerairePage(getStationsUC, getItiUC);
        itiPage.setItineraireList(res);
        itiPage.setPreviousPage(this);
        itiPage.display();

    }

    private int getNbArretsFromUser() {
        System.out.println("Combien d'arrêts voulez vous faire (destination finale exclue) ?");
        ScannerInt sci = new ScannerInt();

        return sci.getValidIntInput("Nombre d'arrêts : ");
    }

    public List<Position> getDestinationsFromUser(String message, int nbArrets){
        List<Position> arrets= new ArrayList<>();
        for (int i = 0; i < nbArrets; i++) {
            System.out.println(message+(i+1)+":");
            ScannerDouble scd = new ScannerDouble();
            double latitude = scd.getValidDoubleInput("Latitude : ");
            double longitude = scd.getValidDoubleInput("Longitude : ");
            arrets.add(new Position(latitude, longitude));
        }
        return arrets;
    }
}
