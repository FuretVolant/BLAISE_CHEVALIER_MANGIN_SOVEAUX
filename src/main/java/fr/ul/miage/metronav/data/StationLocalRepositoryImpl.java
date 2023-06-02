package fr.ul.miage.metronav.data;

import fr.ul.miage.metronav.domain.model.Station;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de la classe StationRepository pour les données locale.
 * Cette classe gère la récupération des informations sur les stations.
 */
public class StationLocalRepositoryImpl implements StationRepository {



    private List<Station> stationList;

    @Override
    public List<Station> getAllStations() {
        return this.stationList;
    }

    /**
     * @return liste des stations avec des accidents
     */
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
