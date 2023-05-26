package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.domain.model.Position;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class GetPositionPage {

    public List<Position> getPositionFromUser(){
        Scanner scanner = new Scanner(System.in);

        double currentLatitude = 0.0;
        double currentLongitude = 0.0;
        double destinationLatitude = 0.0;
        double destinationLongitude = 0.0;


        //demander la position actuelle et la destination tant que les valeurs ne sont pas valides
        boolean validInput = false;
        do {
            try {
                System.out.println("Entrez votre position actuelle :");
                System.out.print("Latitude : ");
                currentLatitude = scanner.nextDouble();
                System.out.print("Longitude : ");
                currentLongitude = scanner.nextDouble();

                System.out.println("\nEntrez la position de votre destination :");
                System.out.print("Latitude : ");
                destinationLatitude = scanner.nextDouble();
                System.out.print("Longitude : ");
                destinationLongitude = scanner.nextDouble();

                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Erreur : Entrée invalide. Veuillez saisir des valeurs numériques.");
                scanner.nextLine();
            }
        } while (!validInput);
        // Création des objets Position
        Position currentPosition = new Position(currentLongitude, currentLatitude);
        Position destinationPosition = new Position(destinationLongitude, destinationLatitude);

        System.out.println("\nPosition actuelle de l'utilisateur : " + currentPosition);
        System.out.println("Position de la destination : " + destinationPosition);

        return new ArrayList<Position>(List.of(currentPosition, destinationPosition));

    }
}
