package MathsL3Projet2;

//contexte
/**
 * b différents types de bières, même stock de départ
 * le prix des bières proposées varie
 * en fonction du nombre de bières déjà vendues,
 * à chaque fois qu’une bière est vendue, son prix augmente de 5 × (b − 1) centimes
 * (quel que soit le nombre de types de bières encore disponibles)
 * le prix de toutes les autres bières baisse de 5 centimes
 * une fois que le stock d’une bière est épuisé, son prix et sa
 * probabilité d’achat passent à 0.
 * toutes les bières seront vendues au cours de la soirée.
 * Enfin, tous les prix (en centimes), doivent être divisibles par 5
 */
//consigne
/**
 * modéliser les achats aléatoires des étudiants.
 * il n’y a qu’une seule personne à la fois qui peut vendre les bières
 * les étudiants choisissent la bière qu’ils vont acheter avec une probabilité inversement proportionnelle au prix de
 * cette bière.
 * répéter l’expérience de l’achat de la première bière,
 * stocker ses résultats (en comptant le nombre de fois où chaque bière aura été sélectionnée).
 * Ensuite, on simulera une soirée complète d’achat de bières, en ne renvoyant que les prix des bières,
 * mis à jour après chaque achat.
 * Enfin, on calculera, sur cette simulation, le profit de l’association.
 */
public class Projet2 {
    /**
     Première ligne :
     * les prix des bières, générés aléatoirement :
     * compris entre (stockInitial×nombreDeBieres/20) euros et (stockInitial×nombreDeBieres/5)
     * Ils devront avoir 2 chiffres obligatoires derrière la virgule
     * être séparés par une espace.
     Deuxième ligne
     * les arrondis des probabilités d’achat de chacune de ces bières
     * (dans le même ordre qu’au-dessus :
     * avec 3 chiffres obligatoires derrière la virgule
     * séparés par un espace.
     Troisième ligne
     * pour chaque bière, le nombre (entier) de fois elle aura été sélectionné
     * séparés par une espace
     * (et toujours dans le même ordre).
     Lignes suivantes
     * prix actuels des bières (ligne 4 : après 1 vente, ligne 5 : après deux ventes
     * toujours dans le même ordre,
     * 2 chiffres obligatoires derrière la virgule
     * séparés par une espace.
     Cette partie correspond à la simulation complète
     *des ventes d’une soirée, à partir des prix initiaux de la première ligne, chaque bière ayant
     *un stock stockInitial.
     En particulier, la ligne des prix après le dernier achat possible ne comportera
     *que des 0.00, vu que toutes les bières auront été vendues.
     Dernière ligne profit de l’association étudiante, avec 2 chiffres obligatoires derrière la virgule
     * un signe - devant si le profit est négatif, rien dans le cas contraire.
     * @param nombreDeBieres
     * @param stockInitial
     * @param nombreIteration
     */
    public Projet2(int nombreDeBieres, int stockInitial, int nombreIteration){

    }
}