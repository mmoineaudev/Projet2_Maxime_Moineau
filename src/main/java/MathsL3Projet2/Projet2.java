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

import java.util.HashMap;
import java.util.Random;

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

    private final int nb_types;
    private final int stock_initial;
    private HashMap<Beer, Double> beers;


    /**
     Première ligne :
     * les prix des bières, générés aléatoirement :
     *
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
        this.nb_types = nombreDeBieres;
        this.stock_initial = stockInitial;
        String CR = "";
        String journal = "";
        double depenseDeDepart = initSimulation();
        CR+=printPrices();
        CR+=printProbas();

        while(nombreIteration-->1) {
            journal+=printPrices();
            chooseABeer();
        }
        journal+=printPrices();

        CR+=printVentes();
        CR+=journal;
        CR+= printProfit(depenseDeDepart);
        System.out.println(CR);

    }

    private String printProfit(double depenseDeDepart) {
        double CA = depenseDeDepart;
        for(Beer b : beers.keySet())
            CA += b.getSommeDesVentes();
        return String.format("%.2f",CA) +" \n";
    }


    private String printPrices() {
        String str="";
        for(Beer b : beers.keySet())
            str+=String.format("%.2f",b.getPrice())+" ";
        str+="\n";
        return str;
    }

    private String printProbas() {
        String str="";
        for(Beer b : beers.keySet())
            str+=String.format("%.3f",beers.get(b))+" ";
        str+="\n";
        return str;
    }
    private String printVentes() {
        String str="";
        for(Beer b : beers.keySet())
            str+=b.getVentes()+" ";
        str+="\n";
        return str;
    }

    private double initSimulation() {
        beers = new HashMap<>();
        double cout = 0;
        for(int i = 0; i<nb_types; i++){
            double randomPrice = computeARandomPrice(nb_types, stock_initial);
            Beer beer = new Beer(randomPrice, stock_initial);
            beers.put(beer, 0.);
            cout-=beer.getPrice()*beer.getStock();//on deduit le prix des bieres de depart du profit de l'association
        }
        initProbas();
        return cout;
    }

    private void initProbas() {
        for(Beer beer : beers.keySet()) {
            beers.put(beer, computeProba(beer));//on recalcule les probas
        }
    }

    private Double computeProba(Beer beer) {
        //mes probas sont pas inversement proportionnelle
        double totalprice = 0.;
        for (Beer b : beers.keySet()) {
            totalprice += b.getPrice();
        }
        double computedProba = beer.getPrice()/totalprice;
        return (beer.getStock()==0)?0.: computedProba;

    }

    private void chooseABeer(){
       if(noMoreBeer()) return;
       else drinkCheapestBeer();
    }


    private void drinkCheapestBeer() {
        double minProb = 1.;
        Beer beer = null;
        for(Beer b : beers.keySet()){
            if(b.getStock()>0){
                if(beers.get(b)<=minProb) {
                    minProb=beers.get(b);
                    beer = b ;
                }
            }
        }
        if(beer!=null) {
            beer.drink(getPriceIncrement()+0.05);//vu qu'on a decrementé tout le monde
            for(Beer b2 : beers.keySet()) {
                b2.decrementPrice();
                beers.put(b2, computeProba(b2));
            }
        }
    }

    private boolean noMoreBeer() {
        for(Beer b : beers.keySet())
            if(b.getStock()>0) return false;
        return true;
    }

    private double getPriceIncrement() {
        double inc = 5.*(beers.size()-1);
        return inc/100.;
    }


    /**
     * compris entre (stockInitial×nombreDeBieres/20) euros et (stockInitial×nombreDeBieres/5)
     * Ils devront avoir 2 chiffres obligatoires derrière la virgule
     * être séparés par une espace.
     */
    private double computeARandomPrice(int nombreDeBieres, int stockInitial){

        int a = stockInitial*nombreDeBieres/20 * 100;
        int b = stockInitial*nombreDeBieres/5 * 100;
        Random r = new Random();
        int newval = r.nextInt(b);
        while(newval%5>0||newval<a||newval==0)
            newval=r.nextInt(b);
        return newval/100.;
    }
}