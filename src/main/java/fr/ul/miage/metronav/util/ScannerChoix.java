package fr.ul.miage.metronav.util;

import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ScannerChoix extends ScannerBase {
    private HashMap<Integer, String> choix;
    public ScannerChoix(HashMap<Integer, String> choix) {
        this.choix = choix;
        this.scanner = new Scanner(System.in);
    }

    public ScannerChoix(HashMap<Integer, String> choix, ByteArrayInputStream inputStream) {
        this.choix = choix;
        scanner = new Scanner(inputStream);
    }

    public int getValidIntInput(String prompt) {
        while (true) {
            try {
                System.out.println(prompt);
                for (Integer key : choix.keySet()) {
                    System.out.println(key + ". " + choix.get(key));
                }
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if(value<1){
                    System.out.println("Bien essayé ^^");
                    throw new NumberFormatException();
                }
                if(!choix.containsKey(value)){
                    throw new ArrayIndexOutOfBoundsException();
                }
                return value;
            } catch (Exception e) {
                String className = e.getClass().getName();
                if(className.equals(NumberFormatException.class.getName())){
                    System.out.println("Erreur : Veuillez entrer un nombre valide.");
                    return -1;
                }
                if(className.equals(ArrayIndexOutOfBoundsException.class.getName())){
                    System.out.println("Erreur : Veuillez entrer un nombre parmi ceux donnés.");
                    return -1;
                }
            }
        }
    }
}
