package fr.ul.miage.metronav.domain.usecase;

import fr.ul.miage.metronav.domain.model.Station;

import java.util.List;

public interface GetStations {

    List<Station> getAllStations();

    List<Station> getStationsIncident();

}
