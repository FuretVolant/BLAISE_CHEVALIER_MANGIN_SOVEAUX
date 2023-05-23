package main.java.Objets;

import java.util.List;

public class Ligne {

    private String numero;

    private List<Station> stations;

    public Ligne(String numero, List<Station> stations) {
        this.numero = numero;
        this.stations = stations;
    }
}
