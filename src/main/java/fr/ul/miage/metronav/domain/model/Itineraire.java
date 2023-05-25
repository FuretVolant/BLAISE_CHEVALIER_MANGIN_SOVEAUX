package fr.ul.miage.metronav.domain.model;

import java.util.List;

public class Itineraire {

    private List<Station> stations;

    public Itineraire(List<Station> stations) {
        this.stations = stations;

    }
}