package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.List;

/**
 * Implémentation de la classe TrajetRepository.
 * Cette classe gère la récupération des informations sur les trajets entre les stations.
 */
public class TrajetLocalRepositoryImpl implements TrajetRepository{

    private List<Trajet> trajetList;

    @Override
    public List<Trajet> getAllTrajet() {
        return this.trajetList;
    }

    public void setTrajetList(List<Trajet> trajetList){
        this.trajetList = trajetList;
    }
}
