package fr.ul.miage.metronav.domain.service;

import fr.ul.miage.metronav.domain.model.*;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;

public class ServiceItineraireRapideImpl extends PathFinder implements ServiceItineraireRapide {

    /**
     * Calculer l'itinéraire le plus rapide entre une station de départ et une station d'arrivée.
     *
     * @param depart      La station de départ.
     * @param arrivee     La station d'arrivée.
     * @param stationList La liste des stations disponibles.
     * @param trajetList  La liste des trajets possibles.
     * @return L'itinéraire le plus rapide.
     */
    @Override
    public Itineraire calculerItineraireRapide(Station depart, Station arrivee, List<Station> stationList, List<Trajet> trajetList) {
        // Création du graphe
        Graph<Station, DefaultWeightedEdge> metroGraph = generateGraph(stationList, trajetList);

        // Création de l'algorithme Dijkstra
        ShortestPathAlgorithm<Station, DefaultWeightedEdge> shortestPathAlgorithm = new DijkstraShortestPath<>(metroGraph);

        // Recherche de l'itinéraire optimal
        GraphPath<Station, DefaultWeightedEdge> shortestPath = shortestPathAlgorithm.getPath(depart, arrivee);

        return generateItineraire(shortestPath, trajetList);
    }

    /**
     * Génère l'itinéraire à partir du plus court chemin et de la liste des trajets.
     *
     * @param shortestPath Le plus court chemin.
     * @param trajetList   La liste des trajets.
     * @return L'itinéraire généré.
     */
    private Itineraire generateItineraire(GraphPath<Station, DefaultWeightedEdge> shortestPath, List<Trajet> trajetList) {
        List<Station> stationList = new ArrayList<>();
        List<Trajet> trajetListItineraire = new ArrayList<>();

        // Parcourir les stations du plus court chemin et ajouter les stations de correspondance à la liste
        for (Station s : shortestPath.getVertexList()) {
            if (isArealStation(s)) {
                stationList.add(s);
            }
        }

        return stationListToItineraire(stationList, trajetList);
    }

    /**
     * Vérifie si une station est une station de correspondance.
     *
     * @param s La station à vérifier.
     * @return Vrai si la station est une station de correspondance, sinon faux.
     */
    private boolean isArealStation(Station s) {
        return s.getNom().length() != 2;
    }

    /**
     * Récupère l'identifiant d'une station.
     *
     * @param station La station.
     * @return L'identifiant de la station.
     */
    private String getStationID(Station station) {
        return station.getNom().substring(8);
    }

    /**
     * Génère le graphe des stations à partir de la liste des stations et des trajets.
     *
     * @param stationList La liste des stations.
     * @param trajetList  La liste des trajets.
     * @return Le graphe des stations.
     */
    private Graph<Station, DefaultWeightedEdge> generateGraph(List<Station> stationList, List<Trajet> trajetList) {
        // Création du graphe
        Graph<Station, DefaultWeightedEdge> metroGraph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Ajouter toutes les stations comme des sommets du graphe
        for (Station station : stationList) {
            metroGraph.addVertex(station);
        }

        // Parcourir tous les trajets
        for (Trajet trajet : trajetList) {
            Station stationArrivee = trajet.getStationArrivee();
            Station stationDepart = trajet.getStationDepart();

            // Vérifier si le trajet est sûr et les stations de départ et d'arrivée sont sûres
            if (stationArrivee.isSafe() && stationDepart.isSafe() && trajet.isSafe()) {
                String nom_depart_poid = getStationID(stationArrivee) + getStationID(stationDepart);
                String nom_arrivee_poid = getStationID(stationDepart) + getStationID(stationArrivee);

                // Création des stations de poids pour l'arrivée et le départ
                Station station_poid_arrivee = new Station(nom_depart_poid, stationArrivee.getPosition(), stationArrivee.getTemps_arret() / 2, trajet.getLignes(), stationArrivee.getIncident());
                Station station_poid_depart = new Station(nom_arrivee_poid, stationDepart.getPosition(), stationDepart.getTemps_arret() / 2, trajet.getLignes(), stationDepart.getIncident());

                // Ajouter les stations de poids comme des sommets du graphe
                metroGraph.addVertex(station_poid_arrivee);
                metroGraph.addVertex(station_poid_depart);

                // Création des arêtes entre les stations de poids et les stations d'arrivée et de départ
                DefaultWeightedEdge edge_poid_arrivee = metroGraph.addEdge(station_poid_arrivee, stationArrivee);
                metroGraph.setEdgeWeight(edge_poid_arrivee, station_poid_arrivee.getTemps_arret());

                DefaultWeightedEdge edge_poid_depart = metroGraph.addEdge(station_poid_depart, stationDepart);
                metroGraph.setEdgeWeight(edge_poid_depart, station_poid_arrivee.getTemps_arret());

                // Création de l'arête entre les stations de poids
                DefaultWeightedEdge edge = metroGraph.addEdge(station_poid_depart, station_poid_arrivee);
                metroGraph.setEdgeWeight(edge, trajet.getDuree());
            }
        }

        return metroGraph;
    }
}