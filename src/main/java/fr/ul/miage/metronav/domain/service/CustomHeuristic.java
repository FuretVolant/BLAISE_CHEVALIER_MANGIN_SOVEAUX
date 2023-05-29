package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.Ligne;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.AStarAdmissibleHeuristic;

import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CustomHeuristic<Station> implements AStarAdmissibleHeuristic<Station> {
    private Graph<Station, DefaultWeightedEdge> graph;

    int tempsArret;

    List<Ligne> stationTraversee;

    public CustomHeuristic(Graph<Station, DefaultWeightedEdge> graph) {

        this.graph = graph;
        this.tempsArret = 0;
        this.stationTraversee = new ArrayList<>();

    }

    @Override
    public double getCostEstimate(Station station_source, Station station_target) {
        if(((fr.ul.miage.metronav.domain.model.Station)station_source).getNom().length() == 2){
        for (Ligne l : ((fr.ul.miage.metronav.domain.model.Station)station_source).getLignes()) {
            if(!stationTraversee.contains(l)){
                stationTraversee.add(l);
            }
        }
        }
        return -stationTraversee.size()*1000;
    }


}