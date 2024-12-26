import java.util.Scanner;  //controle de saisie
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Spectacle[] Spec = new Spectacle[100];
        Monument[] monument = new Monument[100];
        Client[] clients = new Client[100];
        int nbs = 0; //nombre de spectacles courant
        int nbmonument = 0; //nombre de monuments courant
        int nbclients = 0; //nombre de clients courant
        System.out.println("Bienvenue dans notre Application de Gestion de Spectacles! Vous trouverez ci-dessus le menu ");
        Scanner x = new Scanner(System.in);
        int choixP;
        do {
            System.out.println("************** Menu Gestion des Spectacles **************\n\n");
            System.out.println("1.Gérer les Spectacles");
            System.out.println("2.Gérer les Monuments");
            System.out.println("3.Gérer les Clients");
            System.out.println("4. Quitter");
            System.out.print("Entrez votre choix : ");
            choixP = x.nextInt();
            switch (choixP) {
                case 1:
                    boolean retourS = false;
                    while (!retourS) {
                        System.out.println("\n\n\n==>Sous-menu:Gestion Spectacles<==");
                        System.out.println("1. Ajouter un Spectacle");
                        System.out.println("2. Modifier un Spectacle");
                        System.out.println("3. Supprimer un Spectacle");
                        System.out.println("4. Afficher les Spectacles");
                        System.out.println("5. Retour au menu principal");
                        System.out.print("Votre choix : ");
                        int choixS = x.nextInt();
                        switch (choixS) {
                            case 1:
                                System.out.println("Veuillez spécifier le type du Spectacle : ");
                                System.out.println("1->Concert");
                                System.out.println("2->Pièce théâtrale");
                                int type = x.nextInt();
                                switch (type) {
                                    case 1:
                                        System.out.print("Veuillez saisir le nom du concert: ");
                                        String n = x.next();
                                        System.out.print("Veuillez saisir la date du concert: ");
                                        String d = x.next();
                                        System.out.println("Saisie de l'heure du concert: ");
                                        // Prompt the user for the hour
                                        int hour;
                                        do {
                                            System.out.print("=> Veuillez saisir l'heure (0-23): ");
                                            hour = x.nextInt();
                                        } while ((hour < 0) || (hour > 23));
                                        int minute;
                                        do {
                                            System.out.print("=> Veuillez saisir les minutes (0-59): ");
                                            minute = x.nextInt();
                                        } while ((minute < 0) || (minute > 23));
                                        LocalTime h = LocalTime.of(hour, minute);
                                        System.out.print("Veuillez saisir l'ID du concert: ");
                                        int num = x.nextInt();
                                        int dur;
                                        do {
                                            System.out.print("Veuillez saisir la durée du concert: ");
                                            dur = x.nextInt();
                                        } while (dur < 30);
                                        System.out.print("Veuillez saisir le nom de la Tournée du concert: ");
                                        String nt = x.next();
                                        System.out.print("Veuillez saisir le genre du concert: ");
                                        String g = x.next();
                                        Spectacle C = new Concert(n, d, h, num, dur, g, nt);
                                        int na;
                                        do {
                                            System.out.println("Combien d'artistes participent à ce concert ?");
                                            na = x.nextInt();
                                        } while (na <= 0);
                                        x.nextLine(); // Nettoyage du buffer après nextInt()
                                        for (int i = 0; i < na; i++) {
                                            System.out.println("Veuillez saisir le nom de l'artiste N°" + (i + 1) + ": ");
                                            String noma = x.nextLine(); // Lecture du nom de l'artiste

                                            System.out.println("Veuillez saisir le domaine de l'artiste N°" + (i + 1) + ": ");
                                            String da = x.nextLine(); // Lecture du domaine de l'artiste
                                            // Création et ajout de l'artiste
                                            Artiste a = new Artiste(noma, C, da);
                                            C.AjouterArtiste(a);
                                        }
                                        System.out.print("Veuillez saisir le nom du monument: ");
                                        String mon = x.nextLine();
                                        boolean monumentExiste = false; // Pour vérifier si le monument existe déjà
                                        // Recherche du monument dans le tableau
                                        for (int o = 0; o < nbmonument; o++) {
                                            if (monument[o].getNom().equalsIgnoreCase(mon)) {
                                                // Si le monument existe, on ajoute le spectacle
                                                monumentExiste = true;
                                                C.setMonument(monument[o]); // Associate the existing monument
                                                System.out.println("concert ajouté au monument : " + mon);
                                                break;
                                            }
                                        }
                                        if (!monumentExiste) {
                                            Monument ms = new Monument(mon);
                                            C.setMonument(ms);
                                            ms.AjouterSpectacle(C);
                                            monument[nbmonument] = ms;
                                            nbmonument++;
                                        }
                                        Spec[nbs] = C;
                                        nbs++;
                                        System.out.println("Le concert a été introduit avec succees!");
                                        break;
                                    case 2:
                                        System.out.print("Veuillez saisir le nom de la pièce : ");
                                        String n2 = x.next();
                                        System.out.print("Veuillez saisir la date de la pièce: ");
                                        String d2 = x.next();
                                        System.out.println("Saisie de l'heure de la pièce: ");
                                        // Prompt the user for the hour
                                        int hour2;
                                        do {
                                            System.out.print("=> Veuillez saisir l'heure (0-23): ");
                                            hour2 = x.nextInt();
                                        } while ((hour2 < 0) || (hour2 > 23));
                                        int minute2;
                                        do {
                                            System.out.print("=> Veuillez saisir les minutes (0-59): ");
                                            minute2 = x.nextInt();
                                        } while ((minute2 < 0) || (minute2 > 99));
                                        LocalTime h2 = LocalTime.of(hour2, minute2);
                                        System.out.print("Veuillez saisir l'ID de la pièce: ");
                                        int num2 = x.nextInt();
                                        int dur2;
                                        do {
                                            System.out.print("Veuillez saisir la durée de la pièce: ");
                                            dur2 = x.nextInt();
                                        } while (dur2 < 30);
                                        System.out.print("Veuillez saisir le genre de la pièce : ");
                                        String g2 = x.next();
                                        System.out.print("Veuillez saisir le public cible de la pièce : =>Enfants \n =>Adultes \n =>Tout public");
                                        String pc = x.next();
                                        System.out.print("Veuillez saisir la langue de la pièce ");
                                        String lan = x.next();
                                        int nbactes;
                                        do {
                                            System.out.print("Veuillez saisir le nombre d'actes de la pièce ");
                                            nbactes = x.nextInt();
                                        } while (nbactes < 1);
                                        Spectacle P = new PieceTheatrale(n2, d2, h2, num2, dur2, g2, lan, nbactes, pc);
                                        int na2;
                                        do {
                                            System.out.println("Combien d'artistes participent à cette pièce ?");
                                            na2 = x.nextInt();
                                        } while (na2 <= 0);
                                        x.nextLine(); // Nettoyage du buffer après nextInt()
                                        for (int i = 0; i < na2; i++) {
                                            System.out.println("Veuillez saisir le nom de l'artiste N°" + (i + 1) + ": ");
                                            String noma = x.nextLine(); // Lecture du nom de l'artiste

                                            System.out.println("Veuillez saisir le domaine de l'artiste N°" + (i + 1) + ": ");
                                            String da = x.nextLine(); // Lecture du domaine de l'artiste
                                            // Création et ajout de l'artiste
                                            Artiste a = new Artiste(noma, P, da);
                                            P.AjouterArtiste(a);
                                        }
                                        System.out.print("Veuillez saisir le nom du monument: ");
                                        String mon2 = x.nextLine();
                                        boolean monumentExiste2 = false; // Pour vérifier si le monument existe déjà
                                        // Recherche du monument dans le tableau
                                        for (int o = 0; o < nbmonument; o++) {
                                            if (monument[o].getNom().equalsIgnoreCase(mon2)) {
                                                // Si le monument existe, on ajoute le spectacle
                                                monumentExiste2 = true;
                                                P.setMonument(monument[o]); // Associate the existing monument
                                                System.out.println("concert ajouté au monument : " + mon2);
                                                break;
                                            }
                                        }
                                        if (!monumentExiste2) {
                                            Monument ms = new Monument(mon2);
                                            P.setMonument(ms);
                                            ms.AjouterSpectacle(P);
                                            monument[nbmonument] = ms;
                                            nbmonument++;
                                        }
                                        Spec[nbs] = P;
                                        nbs++;
                                        System.out.println("La pièce a été introduite avec succees!");
                                        break;
                                }
                                break;
                            case 2:
                                System.out.println("Modification d'un Spectacle");
                                x.nextLine(); // Consomme le '\n' restant
                                System.out.print("Veuillez saisir le nom du Spectacle que vous voulez modifier: ");
                                String nom = x.nextLine();
                                boolean trouve = false;
                                for (int i = 0; i < nbs; i++) {
                                    if (Spec[i].getNom().equalsIgnoreCase(nom)) {
                                        trouve = true;
                                        boolean nomodif = false;
                                        while (!nomodif) {
                                            System.out.println("\n==> Menu de Modification <==");
                                            System.out.println("1. Modifier nom spectacle");
                                            System.out.println("2. Modifier date spectacle");
                                            System.out.println("3. Modifier heure spectacle");
                                            System.out.println("4. Modifier numéro");
                                            System.out.println("5. Modifier durée");
                                            System.out.println("6. Modifier monument");
                                            System.out.println("7. Modifications terminées ! Retour au menu précédent !");
                                            System.out.print("Votre choix : ");
                                            int choixModif = x.nextInt();
                                            x.nextLine(); // Consomme le '\n' restant
                                            switch (choixModif) {
                                                case 1:
                                                    System.out.print("Veuillez saisir le nouveau nom du spectacle: ");
                                                    String nouveauNom = x.nextLine();
                                                    Spec[i].setNom(nouveauNom);
                                                    System.out.println("Nom modifié avec succès !");
                                                    break;
                                                case 2:
                                                    System.out.print("Veuillez saisir la nouvelle date du spectacle: ");
                                                    String nouvelleDate = x.nextLine();
                                                    Spec[i].setDate(nouvelleDate);
                                                    System.out.println("Date modifiée avec succès !");
                                                    break;
                                                case 3:
                                                    System.out.println("Saisie de la nouvelle heure: ");
                                                    // Prompt the user for the hour
                                                    int hourm;
                                                    do {
                                                        System.out.print("=> Veuillez saisir l'heure (0-23): ");
                                                        hourm = x.nextInt();
                                                    } while ((hourm < 0) || (hourm > 23));
                                                    int minutem;
                                                    do {
                                                        System.out.print("=> Veuillez saisir les minutes (0-59): ");
                                                        minutem = x.nextInt();
                                                    } while ((minutem < 0) || (minutem > 59));
                                                    LocalTime hm = LocalTime.of(hourm, minutem);
                                                    Spec[i].setHeure(hm);
                                                    System.out.println("Heure modifiée avec succès !");
                                                    break;
                                                case 4:
                                                    System.out.print("Veuillez saisir le nouveau numéro du spectacle: ");
                                                    int nouveauNumero = x.nextInt();
                                                    Spec[i].setID(nouveauNumero);
                                                    System.out.println("Numéro modifié avec succès !");
                                                    break;
                                                case 5:
                                                    int nouvelleDuree;
                                                    do {
                                                        System.out.print("Veuillez saisir la nouvelle durée du spectacle: ");
                                                        nouvelleDuree = x.nextInt();
                                                    } while (nouvelleDuree < 30);
                                                    Spec[i].setDuree(nouvelleDuree);
                                                    System.out.println("Durée modifiée avec succès !");
                                                    break;
                                                case 6:
                                                    System.out.print("Veuillez saisir le nouveau nom du monument: ");
                                                    String nouveauMonument = x.nextLine();
                                                    Spec[i].getMonument().setNom(nouveauMonument);
                                                    System.out.println("Monument modifié avec succès !");
                                                    break;
                                                case 7:
                                                    System.out.println("Modifications terminées. Retour au menu précédent...");
                                                    nomodif = true;
                                                    break;
                                                default:
                                                    System.out.println("Choix invalide. Veuillez réessayer.");
                                            }
                                        }
                                        break; // Sort de la boucle une fois le spectacle trouvé et modifié
                                    }
                                }
                                if (!trouve) {
                                    System.out.println("Spectacle non trouvé. Veuillez vérifier le nom et réessayer.");
                                }
                                break;
                            case 3:
                                System.out.println("Suppression d'un Spectacle");
                                x.nextLine(); // Consomme le '\n' restant
                                System.out.print("Veuillez saisir le nom du Spectacle que vous voulez supprimer: ");
                                String nomASupprimer = x.nextLine();
                                boolean trouvee = false;
                                for (int i = 0; i < nbs; i++) {
                                    if (Spec[i].getNom().equalsIgnoreCase(nomASupprimer)) { //change later
                                        trouvee = true;
                                        for (int j = i; j < nbs - 1; j++) {
                                            Spec[j] = Spec[j + 1];
                                        }
                                        Spec[nbs - 1] = null; // Supprimer la dernière référence
                                        nbs--; // Réduire le compteur de spectacles
                                        System.out.println("Le spectacle \"" + nomASupprimer + "\" a été supprimé avec succès !");
                                        break;
                                    }
                                }
                                if (!trouvee) {
                                    System.out.println("Spectacle non trouvé. Veuillez vérifier le nom et réessayer.");
                                }
                                break;
                            case 4:
                                System.out.println("Affichage des Spectacles");
                                for (int i = 0; i < nbs; i++) {
                                    System.out.println("Spectacle N°" + (i + 1) + ": ");
                                    Spec[i].AfficheInfo();
                                    System.out.println("\n\n");
                                }
                                break;
                            case 5:
                                System.out.println("Retour au menu principal...");
                                retourS = true; // Sortir du sous-menu
                                break;
                            default:
                                System.out.println("Choix invalide. Veuillez réessayer.");
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean retourM = false;
                    while (!retourM) {
                        System.out.println("\n\n\n==>Sous-menu:Gestion Monuments<==");
                        System.out.println("1. Ajouter un Monument");
                        System.out.println("2. Modifier un Monument");
                        System.out.println("3. Supprimer un Monument");
                        System.out.println("4. Afficher les Monuments");
                        System.out.println("5. Afficher l'historique des specatcles d'un monument'");
                        System.out.println("6. Retour au menu principal");
                        System.out.print("Votre choix : ");
                        int choixM = x.nextInt();
                        switch (choixM) {
                            case 1:
                                System.out.print("Veuillez saisir le nom du monument: ");
                                String nomMon = x.next();
                                Monument m = new Monument(nomMon);
                                System.out.print("Veuillez saisir la ville du monument: ");
                                String vm = x.next();
                                x.nextLine();
                                System.out.print("Veuillez l'ID du monument: ");
                                int idm = x.nextInt();
                                int nbm;
                                do {
                                    System.out.print("Veuillez saisir le nombre de places de ce monument: ");
                                    nbm = x.nextInt();
                                } while (nbm < 20);
                                m.setID(idm);
                                m.setNbplaces(nbm);
                                m.setVille(vm);
                                x.nextLine(); // Nettoyage du buffer après nextInt()
                                monument[nbmonument] = m;
                                nbmonument++;
                                System.out.println("Le monument a été introduit avec succees!\n");
                                break;
                            case 2:
                                System.out.println("Modification d'un Monument");
                                x.nextLine(); // Consomme le '\n' restant
                                System.out.print("Veuillez saisir le nom du Monument que vous voulez modifier: ");
                                String nom = x.nextLine();
                                int i = 0;
                                while (!(monument[i].getNom().trim().equalsIgnoreCase(nom)) && (i < nbs)) {
                                    i++;
                                }
                                if (i == nbs) {
                                    System.out.println("Monument non trouvé. Veuillez vérifier le nom et réessayer.");
                                } else {
                                    boolean monumentmodifie = false;
                                    while (!monumentmodifie) {
                                        System.out.println("\n==> Menu de Modification du Monument <==");
                                        System.out.println("1. Modifier nom monument");
                                        System.out.println("2. Modifier ID monument");
                                        System.out.println("3. Modifier nombre de places du monument");
                                        System.out.println("4. Modifier Ville du monument");
                                        System.out.println("5. Ajouter un spectacle au monument");
                                        System.out.println("6. Supprimer un spectacle du monument");
                                        System.out.println("7. Modifications terminées ! Retour au menu précédent !");
                                        System.out.print("Votre choix : ");
                                        int choixModifM = x.nextInt();
                                        x.nextLine(); // Consomme le '\n' restant

                                        switch (choixModifM) {
                                            case 1:
                                                System.out.print("Veuillez saisir le nouveau nom du monument: ");
                                                String nouveauNomM = x.nextLine();
                                                monument[i].setNom(nouveauNomM);
                                                System.out.println("Nom modifié avec succès !");
                                                break;

                                            case 2:
                                                System.out.print("Veuillez saisir le nouvel ID du monument: ");
                                                int nouvelID = x.nextInt();
                                                monument[i].setID(nouvelID);
                                                System.out.println("ID modifié avec succès !");
                                                break;

                                            case 3:
                                                int nouveaunb;
                                                do {
                                                    System.out.print("Veuillez saisir le nouveau nombre de places du monument: ");
                                                    nouveaunb = x.nextInt();
                                                } while (nouveaunb < 20);
                                                monument[i].setNbplaces(nouveaunb);
                                                System.out.println("Nombre de places modifié avec succès !");
                                                break;

                                            case 4:
                                                System.out.print("Veuillez saisir la nouvelle ville du monument: ");
                                                String nouvelleVille = x.nextLine();
                                                monument[i].setVille(nouvelleVille);
                                                System.out.println("Ville modifiée avec succès !");
                                                break;

                                            case 5:
                                                System.out.print("Veuillez saisir le nom du spectacle que vous voulez ajouter: ");
                                                String sna = x.nextLine();
                                                Spectacle sp = new Spectacle(sna, null, null, 0, 0);
                                                sp.setNom(sna);
                                                Spec[nbs] = sp; // Ensure `Spec` array is initialized and has space
                                                nbs++;
                                                System.out.println("Spectacle ajouté avec succès !");
                                                break;

                                            case 6:
                                                System.out.print("Veuillez saisir le nom du spectacle que vous voulez supprimer: ");
                                                String sns = x.nextLine();
                                                boolean trouvee1 = false;

                                                for (int j = 0; j < nbs; j++) {
                                                    if (Spec[j].getNom().equalsIgnoreCase(sns)) {
                                                        trouvee1 = true;
                                                        monument[i].SupprimerSpectacle(j); // Ensure this method exists and works
                                                        System.out.println("Spectacle supprimé avec succès !");
                                                        break;
                                                    }
                                                }

                                                if (!trouvee1) {
                                                    System.out.println("Spectacle inexistant dans le tableau !");
                                                }
                                                break;

                                            case 7:
                                                System.out.println("Modifications terminées. Retour au menu précédent...");
                                                monumentmodifie = true;
                                                break;

                                            default:
                                                System.out.println("Choix invalide. Veuillez réessayer.");
                                                break;
                                        }
                                    }
                                }

                            case 3:
                                System.out.println("Suppression d'un Monument");
                                x.nextLine(); // Consomme le '\n' restant
                                System.out.print("Veuillez saisir le nom du Monument que vous voulez supprimer: ");
                                String nomMonsupp = x.nextLine();
                                boolean trouveeMon = false;
                                for (int k = 0; k < nbmonument; k++) {
                                    if (monument[k].getNom().trim().equalsIgnoreCase(nomMonsupp)) {
                                        trouveeMon = true;
                                        for (int j = k; j < nbmonument - 1; j++) {
                                            monument[j] = monument[j + 1];
                                        }
                                        monument[nbmonument - 1] = null; // Supprimer la dernière référence
                                        nbmonument--; // Réduire le compteur de monuments
                                        System.out.println("Le monument \"" + nomMonsupp + "\" a été supprimé avec succès !");
                                        break;
                                    }
                                }
                                if (!trouveeMon) {
                                    System.out.println("Monument non trouvé. Veuillez vérifier le nom et réessayer.");
                                }
                                break;
                            case 4:
                                System.out.println("Affichage des monuments");
                                for (int l = 0; l < nbmonument; l++) {
                                    System.out.println("Monument N°" + (l + 1) + ": ");
                                    monument[l].AfficheInfo();
                                    System.out.println("\n");
                                }
                                break;
                            case 5:
                                System.out.println("Affichage de l'historique des spectacles d'un monument");
                                x.nextLine(); // Consomme le '\n' restant
                                System.out.print("Veuillez saisir le nom du Monument dont vous voulez consulter  l'historique: ");
                                String nomMonHis = x.nextLine();
                                int p = 0;
                                while ((p < nbmonument) && !(monument[p].getNom().equalsIgnoreCase(nomMonHis))) {
                                    p++;
                                }
                                if (p == nbmonument) {
                                    System.out.println("Monument non trouvé. Veuillez vérifier le nom et réessayer.");
                                } else {
                                    monument[p].AfficherSpectacles();
                                }
                                break;
                            case 6:
                                System.out.println("Retour au menu principal...");
                                retourM = true; // Sortir du sous-menu
                                break;
                            default:
                                System.out.println("Choix invalide. Veuillez réessayer.");
                        }
                    }
                    break;
                case 3:
                    boolean retourC = false;
                    while (!retourC) {
                        System.out.println("\n\n\n==>Sous-menu:Gestion Clients<==");
                        System.out.println("1. Ajouter un Client");
                        System.out.println("2. Modifier les informations d'un Client ");
                        System.out.println("3. Supprimer un client");
                        System.out.println("4. Afficher les clients");
                        System.out.println("5. Retour au menu principal");
                        System.out.print("Votre choix : ");
                        int choixC = x.nextInt();
                        switch (choixC) {
                            case 1:
                                System.out.println("----------Ajout d'un client-----------");
                                System.out.println("Veuillez saisir le nom du client: ");
                                x.nextLine();
                                String ncl = x.nextLine();
                                System.out.println("Veuillez saisir l'ID du client: ");
                                int idcl = x.nextInt();
                                Client cl = new Client(ncl, idcl);
                                int nbbillets;
                                do {
                                    System.out.println("Veuillez saisir le nombre de billets du client: ");
                                    nbbillets = x.nextInt();
                                } while (nbbillets < 0);
                                for (int i = 0; i < nbbillets; i++) {
                                    System.out.println("Veuillez saisir le numéro du billet N°" + (i + 1) + ": ");
                                    int numb = x.nextInt(); // Lecture du numero billet
                                    double prixb;
                                    do {
                                        System.out.println("Veuillez saisir le prix de billet N°" + (i + 1) + ": ");
                                        prixb = x.nextDouble();
                                    } while (prixb <= 0);
                                    Billet billet = new Billet(numb, prixb, null, cl);
                                    System.out.println("Veuillez saisir le nom du Spectacle concerné: ");
                                    x.nextLine();
                                    String nspec = x.nextLine();
                                    // Recherche du spectacle dans le tableau
                                    int q = 0;
                                    while ((q < nbs) && !(Spec[q].getNom().equalsIgnoreCase(nspec))) {
                                        q++;
                                    }
                                    if (q == nbs) {
                                        Monument mn = new Monument("non défini");
                                        Spectacle sp = new Spectacle(nspec, null, null, 0, 0);
                                        sp.setMonument(mn);
                                        Spec[nbs] = sp;
                                        nbs++;
                                    }
                                    billet.setSpectacle(Spec[q]);
                                    Spec[q].AjouterBillet(billet);
                                    cl.AjouterBillet(billet);

                                }
                                clients[nbclients] = cl;
                                nbclients++;
                                System.out.println("Le client a été introduit avec succees!");
                                break;
                            case 2:
                                System.out.println("Modification des Informations d'un client: ");
                                System.out.print("Veuillez saisir le nom du client dont vous voulez modifier les informations : ");
                                x.nextLine();
                                String nomc = x.nextLine();
                                int a = 0;
                                while ((a < nbclients) && (!(clients[a].getNom().trim().equalsIgnoreCase(nomc)))) {
                                    a++;
                                }
                                if (a == nbclients) {
                                    System.out.println("Client non trouvé. Veuillez vérifier le nom et réessayer.");
                                } else {
                                    boolean clientmodifie = false;
                                    while (!clientmodifie) {
                                        System.out.println("\n==> Menu de Modification des Informations d'un Client <==");
                                        System.out.println("1. Modifier nom client");
                                        System.out.println("2. Modifier ID client");
                                        System.out.println("3. Modifications terminées ! Retour au menu précédent !");
                                        System.out.print("Votre choix : ");
                                        int choixModifC = x.nextInt();
                                        switch (choixModifC) {
                                            case 1:
                                                System.out.print("Veuillez saisir le nouveau nom du client: ");
                                                x.nextLine();
                                                String nouveauNomC = x.nextLine();
                                                clients[a].setNom(nouveauNomC);
                                                System.out.println("Nom modifié avec succès !");
                                                break;

                                            case 2:
                                                System.out.print("Veuillez saisir le nouvel ID du client: ");
                                                int nouvelIDC = x.nextInt();
                                                clients[a].setID(nouvelIDC);
                                                System.out.println("ID modifié avec succès !");
                                                break;
                                            case 3:
                                                System.out.println("Modifications terminées. Retour au menu précédent...");
                                                clientmodifie = true;
                                                break;
                                            default:
                                                System.out.println("Choix invalide. Veuillez réessayer.");
                                                break;
                                        }
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Suppression d'un client");
                                x.nextLine(); // Consomme le '\n' restant
                                System.out.print("Veuillez saisir le nom du client que vous voulez supprimer: ");
                                String nomClientSupp = x.nextLine();
                                int w = 0;
                                while ((w < nbclients) && (!(clients[w].getNom().trim().equalsIgnoreCase(nomClientSupp)))) {
                                    w++;
                                }
                                if (w == nbclients) {
                                    System.out.println("Client non trouvé. Veuillez vérifier le nom et réessayer.");
                                } else {
                                    for (int s = w; s < nbclients - 1; s++) {
                                        clients[s] = clients[s + 1];
                                    }
                                    clients[nbclients - 1] = null; // Supprimer la dernière référence
                                    nbclients--; // Réduire le compteur de clients
                                }
                                System.out.println("Le client a été supprimé avec succès !");
                                break;
                            case 4:
                                System.out.println("Affichage des Clients: ");
                                for (int y = 0; y < nbclients; y++) {
                                    System.out.println("Client N°" + (y + 1) + ": ");
                                    clients[y].afficheInfos();
                                    System.out.println("\n\n");
                                }
                                break;
                            case 5:
                                System.out.println("Retour au menu principal...");
                                retourC = true; // Sortir du sous-menu
                                break;
                            default:
                                System.out.println("Choix invalide. Veuillez réessayer.");
                        }
                    }
            }
        } while (choixP != 4);
    }
}
