package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Ligne;
import fr.ul.miage.metronav.domain.model.Station;

import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic;

import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;


public class CustomHeuristic implements AStarAdmissibleHeuristic<Station> {
    private Graph<Station, DefaultWeightedEdge> graph;

    int tempsArret;

    List<Ligne> stationTraversee;

    public CustomHeuristic(Graph<Station, DefaultWeightedEdge> graph) {

        this.graph = graph;
        this.tempsArret = 0;
        this.stationTraversee = new ArrayList<>();

    }

    @Override
    public double getCostEstimate(Station stationSource, Station stationTarget) {
        if(isStationGenerer(stationSource)){

        for (Ligne ligne : stationSource.getLignes()) {
            if(vuePourLaPremierFois(ligne)){
                stationTraversee.add(ligne);
            }
        }
        }
        return poid();
    }

    private boolean isStationGenerer(Station station){
        return station.getNom().length() == 2;
    }

    private boolean vuePourLaPremierFois(Ligne ligne){
        return !stationTraversee.contains(ligne);
    }

    private int poid(){
        return -stationTraversee.size()*1000;
    }

}