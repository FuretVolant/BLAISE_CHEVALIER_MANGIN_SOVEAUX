# BLAISE_CHEVALIER_MANGIN_SOVEAUX

## Projet de Génie Logiciel 

## Résumé du projet 

Le projet a plusieurs objectifs principaux complémentaires sur le sujet d'un métro.
Le but du projet au niveau de la programmation est d'écrire un code capable de donner à un utilisateur un itinéraire de métro pour aller d'un point A à un point B.
En ce qui concerne la gestion des activités à réaliser, il faut mettre en place un calendrier grâce au logiciel Trello de plusieurs sprints Backlog successifs montrant la progression des users stories et des user stories techniques.

## Dépendances requises 
- org.assertj
- org.junit.jupiter
- org.jgrapht

Exemple de graphe de métro avec un trajet trouvable grâce au code :


## Spécifications réalisées 
- itinéraire le plus rapide en durée
- itinéraire avec le moins de changements de lignes
- itinéraire qui passe par certains points donnés par l'utilisateur
- problème à une station
- problème sur une voie
- modélisation des lignes de métro et des stations
- modélisation à chaque fragment de ligne d'un temps de parcours associé et d'un indicateur permettant de savoir s'il y a ou non un incident
- modélisation à chaque station d'un temps d'arrêt associé et d'un indicateur permettant de savoir s'il y a ou non un incident
- trouver la (ou les) station(s) la(es) plus proche(s) et proposer un itinéraire en fonction de la station d'arrivée, des préférences de l'utilisateur et des incidents potentiels sur la ligne ou les stations

## User Stories 

- Indiquer ma position
- Indiquer ma destination
- Obtenir un itinéraire rapide
- Obtenir un itinéraire simple
- Obtenir un itinéraire composé
- Eviter les stations avec des incidents
- Eviter les voies avec des incidents
- Obtenir mon heure d'arrivée
- Savoir si un incident a lieu sur une voie de ligne
- Savoir si un incident a lieu sur une station
- Obtenir le temps de parcours d'un trajet entre deux stations
- Obtenir le temps d'arrêt d'une station
- Sélectionner mon critère de génération d'itinéraire
- Sélectionner une station à insérer dans un itinéraire composé

## Glossaire
##### Partie liée au sujet :
- **réseau** du métro : Il s’agit du graphe du métro dans lequel les stations constituent les sommets/nœuds du réseau et les voies sont les arêtes.
- **trajet** : terme générique indiquant le passage d’une station A à une station B sans contrainte ou propriété particulière.
- **station** : C’est une gare. Elle est un sommet sur le réseau du métro.
- **voie** : C’est un trajet qui fait la liaison directe entre deux stations. C’est une arête sur le réseau du métro.
- **position** : station dans laquelle se trouve le voyageur au moment T. Cela permet de le situer dans le réseau du métro afvsin d’effectuer les calculs de distance pour arriver à une autre station par la suite.
- **destination** : Il s’agit de la station dans laquelle le voyageur souhaite s’arrêter.
- **ligne** : ensemble de stations qui sont traversées par un métro.
- **point de passage** : Les points de passage sont les stations dans lesquelles le voyageur souhaite se rendre avant d’arriver à sa destination.
- **itinéraire** : suite de trajets qui vont de la position jusqu’à la destination. Les modalités dépendent du choix des itinéraires ci-dessous.
- **itinéraire rapide** : L’itinéraire rapide désigne l'itinéraire le plus rapide pour un voyageur.
- **itinéraire simple** : L’itinéraire simple désigne l'itinéraire qui possède le moins de changement de ligne.
- **itinéraire composé** : L’itinéraire composé est un itinéraire qui contient des points de passage choisis par le voyageur qui sont obligatoires dans son itinéraire entre sa position et sa destination. Le voyageur choisit après avoir fait son parcours s'il souhaite avoir le temps le plus court ou le moins de changement de ligne pour son itinéraire.
- **incident** : empêchement sur une voie ou une station qui bloque les trajets qui y passent. Si l’incident concerne une voie, seule la voie est concernée, et elle est considérée comme non-existante pour la durée de l’incident. Si l’incident concerne une station, alors toutes les voies en lien avec cette station sont considérées comme non-existantes.
- **sous-itinéraire** : itinéraire entre deux points de passage demandés par le voyageur dans le cas d’un itinéraire composé. L’itinéraire est soit le plus rapide, soit avec le moins de changement de lignes en fonction de ce que le voyageur a demandé pour son itinéraire.
- **recherche d’itinéraire** : C’est l’algorithme que l’on utilise en tant que développeur pour trouver le meilleur itinéraire en fonction du choix du type d’itinéraire du voyageur.




