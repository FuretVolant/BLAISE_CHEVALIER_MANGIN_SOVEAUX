package fr.ul.miage.metronav.util;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ScannerChoix extends ScannerBase {

    private static final Logger LOGGER = Logger.getLogger(ScannerChoix.class.getName());

    private final Map<Integer, String> choix;

    public ScannerChoix(Map<Integer, String> choix) {
        this.choix = choix;
        this.scanner = new Scanner(System.in);
    }

    public ScannerChoix(Map<Integer, String> choix, ByteArrayInputStream inputStream) {
        this.choix = choix;
        scanner = new Scanner(inputStream);
    }

    public int getValidIntInput(String prompt) {
        while (true) {
            try {
                displayChoices();
                LOGGER.log(Level.INFO, prompt);
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (isValidChoice(value)) {
                    return value;
                }
                LOGGER.log(Level.WARNING, "Erreur : Veuillez entrer un nombre parmi ceux donnés.");
            } catch (NumberFormatException e) {
                LOGGER.log(Level.WARNING, "Erreur : Veuillez entrer un nombre valide.");
            }
        }
    }

    private void displayChoices() {
        LOGGER.log(Level.INFO, "Choix disponibles :");
        for (Map.Entry<Integer, String> entry : choix.entrySet()) {
            LOGGER.log(Level.INFO, entry.getKey() + ". " + entry.getValue());
        }
    }

    private boolean isValidChoice(int value) {
        return choix.containsKey(value);
    }
}
