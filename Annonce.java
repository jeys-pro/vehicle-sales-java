public class Annonce {

    Vehicle vehicle;
    String description;
    User vendeur;

    public Annonce(Vehicle vehicle, String description, User vendeur) {
        this.vehicle = vehicle;
        this.description = description;
        this.vendeur = vendeur;
    }


    public void afficherAnnonce() {
        System.out.println(vehicle.marque + " " + vehicle.modele + " - " + vehicle.prix + "€");
        System.out.println("Description : " + description);
        System.out.println("Vendeur : " + vendeur.username);
        System.out.println("----------------------");
    }


    public void modifierPrix(int nouveauPrix) {
        vehicle.prix = nouveauPrix;
    }


    public void modifierDescription(String nouvelleDescription) {
        description = nouvelleDescription;
    }
}