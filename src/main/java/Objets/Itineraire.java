package main.java.Objets;

import java.time.LocalTime;
import java.util.List;

public class Itineraire {

    private List<Trajet> trajets;

    private List<Ligne> lignes;

    public Itineraire(List<Trajet> trajets, List<Ligne> lignes) {
        this.trajets = trajets;
        this.lignes = lignes;
    }
    public void ajoutTrajet(Trajet trajet){
        trajets.add(trajet);
    }

    public void ajoutLigne(Ligne ligne){
        lignes.add(ligne);
    }

    public int getTempsTotal(){
        int res = 0;
        for (Trajet t : trajets) {
            res+=t.getDuree();
            res+=t.getStationArrivee().getTemps_arret();
        }
        return res;
    }

    public void afficherHeureArrivee(){
        System.out.println(LocalTime.now().plusMinutes(getTempsTotal()));
    }
}
