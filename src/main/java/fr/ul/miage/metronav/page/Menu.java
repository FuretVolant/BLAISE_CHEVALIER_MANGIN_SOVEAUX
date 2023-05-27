package fr.ul.miage.metronav.page;

import fr.ul.miage.metronav.util.ScannerDouble;

public class Menu extends Page {

    @Override
    public void display() {
        System.out.println("Bienvenue dans Metronav");
        System.out.println("Veuillez entrer votre position ci dessous:");

        GetPositionPage gpg = new GetPositionPage();
        gpg.setPreviousPage(this);
        gpg.display();
    }

}
