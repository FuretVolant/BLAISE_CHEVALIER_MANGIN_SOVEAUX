package fr.ul.miage.metronav.util;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class ScannerInt extends ScannerBase{

    public ScannerInt() {
        scanner = new Scanner(System.in);
    }

    public ScannerInt(ByteArrayInputStream inputStream) {
        scanner = new Scanner(inputStream);
    }
    public int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                String input = scanner.nextLine();
                int val = Integer.parseInt(input);
                if(val > 0){
                    return val;
                }else{
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un nombre entier valide.");
            }
        }
    }
}
