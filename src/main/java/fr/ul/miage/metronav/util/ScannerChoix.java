package fr.ul.miage.metronav.util;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Scanner;

public class ScannerChoix extends ScannerBase {

    private Map<Integer, String> choix;

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

    private void displayChoices() {
        System.out.println("Choix disponibles :");
        for (Map.Entry<Integer, String> entry : choix.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
    }

    private boolean isValidChoice(int value) {
        return choix.containsKey(value);
    }
}