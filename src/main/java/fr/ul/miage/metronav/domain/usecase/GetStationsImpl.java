package fr.ul.miage.metronav.domain.usecase;

import fr.ul.miage.metronav.data.StationLocalRepositoryImpl;
import fr.ul.miage.metronav.domain.model.Station;

import java.util.List;

public class GetStationsImpl implements GetStations{

    StationLocalRepositoryImpl repoStations;

    public GetStationsImpl(StationLocalRepositoryImpl repoStations) {
        this.repoStations = repoStations;
    }

    @Override
    public List<Station> getAllStations() {
        return repoStations.getAllStation();
    }

    @Override
    public List<Station> getStationsIncident() {
        return null;
    }
}
