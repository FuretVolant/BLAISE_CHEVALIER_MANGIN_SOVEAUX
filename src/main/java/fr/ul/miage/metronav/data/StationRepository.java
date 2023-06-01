package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Station;

import java.util.List;

public interface StationRepository {

    List<Station> getAllStations();
    List<Station> getAllStationsAccidents();


}
