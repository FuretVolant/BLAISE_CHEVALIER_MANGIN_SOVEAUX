package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.service.ServiceStationImpl;
import fr.ul.miage.metronav.domain.usecase.GetItineraire;
import fr.ul.miage.metronav.domain.usecase.GetItineraireImpl;
import fr.ul.miage.metronav.domain.usecase.GetStations;
import fr.ul.miage.metronav.domain.usecase.GetStationsImpl;
import fr.ul.miage.metronav.util.ScannerDouble;

import java.util.ArrayList;

public class GetDestinationPage extends Page{
    private Position positionUtilisateur;
    private GetStations getStationsUC;
    private GetItineraire getItiUC;

    public GetDestinationPage(Position positionUtilisateur, GetStations getStationsUC, GetItineraire getItiUC) {
        this.positionUtilisateur = positionUtilisateur;
        this.getStationsUC = getStationsUC;
        this.getItiUC = getItiUC;
    }

    public Position getDestinationFromUser(String message){
        System.out.println(message);
        ScannerDouble scd = new ScannerDouble();
        double latitude = scd.getValidDoubleInput("Latitude : ");
        double longitude = scd.getValidDoubleInput("Longitude : ");

        return new Position(longitude, latitude);
    }

    @Override
    public void display() {

        Position destinationPos = getDestinationFromUser("Veuillez indiquer les coordonnées de votre destination :");

        GetCriterePage gcp = new GetCriterePage(positionUtilisateur, destinationPos, getStationsUC, getItiUC);
        gcp.setPreviousPage(this);
        gcp.display();
    }
}
