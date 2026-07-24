import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        User[] users = new User[100];
        Annonce[] annonces = new Annonce[100];

        int nbUsers = 0;
        int nbAnnonces = 0;

        User currentUser = null;

        // Admin par défaut
        users[nbUsers++] = new Admin("admin", "1234");


        while (true) {


            // ============================
            // MENU CONNEXION
            // ============================

            if (currentUser == null) {


                System.out.println("\n1. S'inscrire");
                System.out.println("2. Se connecter");
                System.out.println("3. Quitter");


                int choix = sc.nextInt();



                if (choix == 1) {


                    System.out.print("Username: ");
                    String username = sc.next();


                    System.out.print("Password: ");
                    String password = sc.next();


                    users[nbUsers++] = new User(username, password);


                    System.out.println("Inscription réussie !");



                } else if (choix == 2) {


                    System.out.print("Username: ");
                    String username = sc.next();


                    System.out.print("Password: ");
                    String password = sc.next();


                    boolean found = false;



                    for (int i = 0; i < nbUsers; i++) {


                        if (users[i] != null &&
                                users[i].username.equals(username) &&
                                users[i].password.equals(password)) {


                            currentUser = users[i];

                            found = true;


                            System.out.println("Connexion réussie !");

                            break;
                        }
                    }



                    if (!found) {

                        System.out.println("Identifiants incorrects !");
                    }




                } else if (choix == 3) {


                    break;

                }



            }



            // ============================
            // MENU UTILISATEUR / ADMIN
            // ============================

            else {


                System.out.println("\nConnecté en tant que : " + currentUser.username);



                if(currentUser instanceof Admin){


                    System.out.println("ROLE : ADMIN");


                    System.out.println("1. Voir les annonces");
                    System.out.println("2. Supprimer une annonce");
                    System.out.println("3. Supprimer un utilisateur");
                    System.out.println("4. Logout");



                    int choix = sc.nextInt();



                    // Voir annonces admin
                    if(choix == 1){


                        for(int i = 0; i < nbAnnonces; i++){

                            if(annonces[i] != null){

                                annonces[i].afficherAnnonce();

                            }

                        }


                    }



                    // Supprimer annonce
                    else if(choix == 2){


                        for(int i = 0; i < nbAnnonces; i++){


                            if(annonces[i] != null){

                                System.out.println("Annonce numéro : " + i);

                                annonces[i].afficherAnnonce();

                            }

                        }


                        System.out.print("Numéro annonce à supprimer : ");

                        int numero = sc.nextInt();


                        annonces[numero] = null;


                        System.out.println("Annonce supprimée !");

                    }




                    // Supprimer utilisateur
                    else if(choix == 3){



                        for(int i = 0; i < nbUsers; i++){


                            if(users[i] != null){

                                System.out.println(
                                        i + " : " + users[i].username
                                );

                            }

                        }



                        System.out.print("Utilisateur à supprimer : ");

                        int numero = sc.nextInt();



                        users[numero] = null;


                        System.out.println("Utilisateur supprimé !");

                    }



                    else if(choix == 4){


                        currentUser = null;

                        System.out.println("Déconnexion...");


                    }





                }


                // ============================
                // MENU UTILISATEUR NORMAL
                // ============================

                else {


                    System.out.println("1. Voir les annonces");
                    System.out.println("2. Ajouter une annonce");
                    System.out.println("3. Modifier une annonce");
                    System.out.println("4. Contacter un vendeur");
                    System.out.println("5. Logout");



                    int choix = sc.nextInt();




                    // Voir annonces

                    if (choix == 1) {


                        for (int i = 0; i < nbAnnonces; i++) {


                            if(annonces[i] != null){

                                annonces[i].afficherAnnonce();

                            }

                        }


                    }



                    // Ajouter annonce

                    else if (choix == 2) {


                        System.out.print("Marque: ");
                        String marque = sc.next();


                        System.out.print("Modele: ");
                        String modele = sc.next();


                        System.out.print("Prix: ");
                        int prix = sc.nextInt();


                        sc.nextLine();


                        System.out.print("Description: ");
                        String description = sc.nextLine();



                        Vehicle v =
                                new Vehicle(
                                        marque,
                                        modele,
                                        prix,
                                        currentUser
                                );


                        Annonce a =
                                new Annonce(
                                        v,
                                        description,
                                        currentUser
                                );



                        annonces[nbAnnonces++] = a;



                        System.out.println("Annonce ajoutée !");

                    }




                    // Modifier annonce

                    else if (choix == 3) {


                        int compteur = 0;



                        for(int i = 0; i < nbAnnonces; i++){


                            if(annonces[i] != null &&
                                    annonces[i].vendeur.username.equals(currentUser.username)){



                                System.out.println(
                                        "Annonce numéro : " + compteur
                                );


                                annonces[i].afficherAnnonce();


                                compteur++;

                            }

                        }




                        System.out.print("Choisir une annonce : ");

                        int choixAnnonce = sc.nextInt();



                        compteur = 0;



                        for(int i = 0; i < nbAnnonces; i++){


                            if(annonces[i] != null &&
                                    annonces[i].vendeur.username.equals(currentUser.username)){



                                if(compteur == choixAnnonce){



                                    System.out.print("Nouveau prix : ");

                                    int prix = sc.nextInt();


                                    sc.nextLine();


                                    System.out.print("Nouvelle description : ");

                                    String desc = sc.nextLine();



                                    annonces[i].modifierPrix(prix);

                                    annonces[i].modifierDescription(desc);



                                    System.out.println(
                                            "Annonce modifiée !"
                                    );


                                }


                                compteur++;

                            }

                        }


                    }




                    // Contacter vendeur

                    else if (choix == 4) {



                        for(int i = 0; i < nbAnnonces; i++){



                            if(annonces[i] != null){


                                System.out.println(
                                        "Annonce numéro : " + i
                                );


                                annonces[i].afficherAnnonce();

                            }


                        }



                        System.out.print(
                                "Choisir une annonce : "
                        );


                        int choixAnnonce = sc.nextInt();



                        if(annonces[choixAnnonce] != null){



                            System.out.println(
                                    "Vous contactez le vendeur : "
                                            +
                                            annonces[choixAnnonce].vendeur.username
                            );


                        }


                    }




                    // Logout

                    else if(choix == 5){


                        currentUser = null;


                        System.out.println(
                                "Déconnexion..."
                        );

                    }


                }


            }


        }


        sc.close();

    }

}