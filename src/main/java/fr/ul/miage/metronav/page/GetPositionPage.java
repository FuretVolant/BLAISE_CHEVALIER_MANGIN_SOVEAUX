package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.service.ServiceStationImpl;
import fr.ul.miage.metronav.util.ScannerDouble;

import java.util.ArrayList;
import java.util.List;

public class GetPositionPage extends Page {

    public List<Position> getPositionListFromUser(){

        Position currentPosition = getPositionFromUser("Entrez votre position actuelle : ");
        Position destinationPosition = getPositionFromUser("Entrez la position de votre destination : ");

        System.out.println("Position actuelle de l'utilisateur : " + currentPosition);
        System.out.println("Position de la destination : " + destinationPosition);

        return new ArrayList<>(List.of(currentPosition, destinationPosition));

    }

    public Position getPositionFromUser(String message){
        System.out.println(message);
        ScannerDouble scd = new ScannerDouble();
        double latitude = scd.getValidDoubleInput("Latitude : ");
        double longitude = scd.getValidDoubleInput("Longitude : ");

        return new Position(longitude, latitude);
    }

    @Override
    public void display() {
        Position userPos = getPositionFromUser("Entrez votre position actuelle : ");

        ServiceStationImpl serviceStation = new ServiceStationImpl();

        Station closest = serviceStation.trouverPlusProcheStation(userPos, new ArrayList<>());

        GetCriterePage gcp = new GetCriterePage();
        gcp.setPreviousPage(this);
        gcp.display();


    }
}
