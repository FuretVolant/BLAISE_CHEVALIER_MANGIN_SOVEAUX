package fr.ul.miage.metronav.util;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ScannerDouble extends ScannerBase{

    public ScannerDouble() {
        scanner = new Scanner(System.in);
    }

    public ScannerDouble(ByteArrayInputStream inputStream) {
        scanner = new Scanner(inputStream);
    }
    public double getValidDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                double value = Double.parseDouble(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un nombre décimal valide.");
            }
        }
    }
}
