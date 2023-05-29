package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.List;

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
