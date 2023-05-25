package fr.ul.miage.metronav.util;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ScannerChoix {
    private Scanner scanner;
    private int choix;
    public ScannerChoix(int choix) {
        this.choix = choix;
        this.scanner = new Scanner(System.in);
    }

    public Integer make() {
        int res = 0;
        System.out.println("Votre Choix :");
        try{res = this.scanner.nextInt();}
        catch (InputMismatchException e){
            System.out.println("Votre choix doit etre un entier");
            return new ScannerChoix(this.choix).make();
        }
        if (res<=0 || res>choix ){
            System.out.println("La valeur entrer ne correspond a aucun choix.");
            res = new ScannerChoix(this.choix).make();
        }
        return res;
    }
}
