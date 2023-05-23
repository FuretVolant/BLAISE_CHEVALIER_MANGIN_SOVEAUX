package main.java.Objets;

import java.util.List;

public class Itineraire {

    private List<Trajet> trajets;

    private List<Ligne> lignes;

    public Itineraire(List<Trajet> trajets, List<Ligne> lignes) {
        this.trajets = trajets;
        this.lignes = lignes;
    }


}
