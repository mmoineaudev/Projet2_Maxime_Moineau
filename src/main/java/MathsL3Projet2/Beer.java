package MathsL3Projet2;

public class Beer {
    //https://www.youtube.com/watch?v=e7kJRGPgvRQ
    private double price;
    private int stock;
    private int ventes = 0;
    private final double checksum;


    private double sommeDesVentes;

    public Beer(double price, int stock) {
        this.price = price;
        this.stock = stock;
        this.checksum = Math.random();
    }

    public int getStock() {
        return stock;
    }

    public int getVentes() {
        return ventes;
    }

    public double getSommeDesVentes() {
        return sommeDesVentes;
    }
    /**
     * chaque fois qu’une bière est vendue, son prix augmente de 5 × (b − 1) centimes
     * (quel que soit le nombre de types de bières encore disponibles)
     * @param priceIncrement
     */
    public void drink(double priceIncrement){
        if(stock>0) {
            stock--;
            ventes++;
            sommeDesVentes +=price;
            price += priceIncrement;
        }
    }

    public double getPrice(){
        return this.stock>0 ? price:0;
    }

    public void decrementPrice(){
        if(this.price>=0.05) this.price -= 0.05;
    }


    public boolean equals(Beer o) {
        return this.checksum==o.checksum;
    }
}
