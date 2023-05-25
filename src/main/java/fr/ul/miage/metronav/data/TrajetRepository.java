package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Station;
import fr.ul.miage.metronav.domain.model.Trajet;

import java.util.List;

public interface TrajetRepository {
    public List<Trajet> getAllTrajet();
}
