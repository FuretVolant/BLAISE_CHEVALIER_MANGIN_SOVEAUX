package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Station;

import java.util.List;

public class StationLocalRepositoryImpl implements StationRepository {



    private List<Station> stationList;

    @Override
    public List<Station> getAllStation() {
        return stationList;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }
}
