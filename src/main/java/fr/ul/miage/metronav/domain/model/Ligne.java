package fr.ul.miage.metronav.domain.model;

import java.util.List;

public class Ligne {

    private String numero;

    public Ligne(String numero, List<Station> stations) {
        this.numero = numero;
    }
}
