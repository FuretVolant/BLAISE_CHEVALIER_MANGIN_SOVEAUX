package fr.ul.miage.metronav.domain.model;

import java.util.List;
import java.util.Objects;

public class Ligne {

    private String numero;

    public Ligne(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligne ligne = (Ligne) o;
        return Objects.equals(numero, ligne.numero);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
