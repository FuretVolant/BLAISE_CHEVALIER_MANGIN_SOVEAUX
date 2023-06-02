package fr.ul.miage.metronav.util;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

/**
 * Classe utilitaire pour la saisie d'un nombre décimal.
 */
public class ScannerDouble extends ScannerBase{

    /**
     * Constructeur de ScannerDouble.
     * Initialise le scanner avec l'entrée standard.
     */
    public ScannerDouble() {
        scanner = new Scanner(System.in);
    }

    /**
     * Constructeur de ScannerDouble avec un flux d'entrée personnalisé.
     * Initialise le scanner avec le flux d'entrée fourni.
     *
     * @param inputStream Le flux d'entrée personnalisé.
     */
    public ScannerDouble(ByteArrayInputStream inputStream) {
        scanner = new Scanner(inputStream);
    }
    /**
     * Récupère un nombre décimal valide saisi par l'utilisateur.
     *
     * @param prompt Le message de saisie.
     * @return Le nombre décimal valide saisi par l'utilisateur.
     */
    public double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un nombre décimal valide.");
            }
        }
    }
}
