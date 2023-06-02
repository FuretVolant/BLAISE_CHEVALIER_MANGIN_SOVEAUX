package fr.ul.miage.metronav.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * Représente une ligne de métro.
 */
public class Ligne {

    private String numero;

    public Ligne(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    /**
     * Vérifie si la ligne est égale à un autre objet.
     *
     * @param o L'objet à comparer.
     * @return true si les lignes sont égales, false sinon.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ligne ligne = (Ligne) o;
        return Objects.equals(numero, ligne.numero);
    }

    /**
     * Calcule le code de hachage de la ligne.
     *
     * @return Le code de hachage de la ligne.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numero);
    }
}
