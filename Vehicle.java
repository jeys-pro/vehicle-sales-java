public class Vehicle {
    String marque;
    String modele;
    int prix;
    User vendeur;

    public Vehicle(String marque, String modele, int prix, User vendeur) {
        this.marque = marque;
        this.modele = modele;
        this.prix = prix;
        this.vendeur = vendeur;
    }
}