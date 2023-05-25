package fr.ul.miage.metronav.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerQuantite {
    private static final int QUANTITE_MAX = 300;
    private final Scanner scanner;
    public ScannerQuantite() {
        this.scanner = new Scanner(System.in);
    }

    public Integer make() {
        int res = 0;
        System.out.println("Votre Quantité :");
        try{res = this.scanner.nextInt();}
        catch (InputMismatchException e){
            System.out.println("Votre quantité doit etre un entier");
            return new ScannerQuantite().make();
        }
        if (res < 0){
            System.out.println("Une quantité ne peut pas être négative.");
            res = new ScannerQuantite().make();
        }else if (res > QUANTITE_MAX){
            System.out.println("Une quantité ne peut pas excéder un maximum de " + QUANTITE_MAX);
            res = new ScannerQuantite().make();
        }
        return res;
    }
}
