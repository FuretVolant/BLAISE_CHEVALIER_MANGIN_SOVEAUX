package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Position;
import fr.ul.miage.metronav.domain.model.Station;

import java.util.List;

public interface StationService {

    public Station trouverPlusProcheStation(Position position, List<Station> listeStation);

}
