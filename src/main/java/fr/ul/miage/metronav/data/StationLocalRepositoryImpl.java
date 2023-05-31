package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

public class StationLocalRepositoryImpl implements StationRepository {



    private List<Station> stationList;

    @Override
    public List<Station> getAllStations() {
        return this.stationList;
    }

    @Override
    public List<Station> getAllStationsAccidents() {
        ArrayList<Station> res = new ArrayList<>();
        for (Station s : stationList) {
            if(!s.getIncident().isEmpty()){
                res.add(s);
            }
        }
        return res;
    }

    public void setStationList(List<Station> stationList) {
        this.stationList = stationList;
    }
}
