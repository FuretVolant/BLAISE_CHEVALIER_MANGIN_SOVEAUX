package fr.ul.miage.metronav.util;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Scanner;
/**
 * Classe utilitaire pour la saisie d'un choix parmi une liste donnée.
 */
public class ScannerChoix extends ScannerBase {

    private final Map<Integer, String> choix;

    /**
     * Constructeur de ScannerChoix.
     * Initialise le scanner et la liste des choix.
     *
     * @param choix La map contenant les choix possibles avec leur valeur numérique.
     */
    public ScannerChoix(Map<Integer, String> choix) {
        this.choix = choix;
        scanner = new Scanner(System.in);
    }

    /**
     * Constructeur de ScannerChoix avec un flux d'entrée personnalisé.
     * Initialise le scanner avec le flux d'entrée fourni et la liste des choix.
     *
     * @param choix         La map contenant les choix possibles avec leur valeur numérique.
     * @param inputStream  Le flux d'entrée personnalisé.
     */
    public ScannerChoix(Map<Integer, String> choix, ByteArrayInputStream inputStream) {
        this.choix = choix;
        scanner = new Scanner(inputStream);
    }

    /**
     * Récupère un entier valide saisi par l'utilisateur.
     * Affiche les choix disponibles avant de demander la saisie.
     *
     * @param prompt Le message de saisie.
     * @return L'entier valide saisi par l'utilisateur.
     */
    public int getValidIntInput(String prompt) {
        while (true) {
            try {
                displayChoices();
                System.out.println(prompt);
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (isValidChoice(value)) {
                    return value;
                }
                System.out.println("Erreur : Veuillez entrer un nombre parmi ceux donnés.");
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
            }
        }
    }

    /**
     * Affiche les choix disponibles.
     */
    private void displayChoices() {
        System.out.println("Choix disponibles :");
        for (Map.Entry<Integer, String> entry : choix.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    /**
     * Vérifie si le choix est valide.
     *
     * @param value La valeur numérique du choix.
     * @return true si le choix est valide, false sinon.
     */
    private boolean isValidChoice(int value) {
        return choix.containsKey(value);
    }
}