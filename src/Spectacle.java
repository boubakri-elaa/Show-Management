import java.time.LocalTime;

public class Spectacle {
    //    //
    private String nom,date;
    private LocalTime heure;
    private int ID,duree;
    private Monument monument;
    private Billet [] billets=new Billet[100];
    private Artiste[] artistes=new Artiste[100];
    private int nbB=0;
    private int nbA=0;

    public Spectacle(String nom, String date, LocalTime heure, int ID, int duree) {
        this.nom = nom;
        this.date = date;
        this.heure = heure;
        this.ID = ID;
        this.duree = duree;
    }

    //Ajout des billets disponibles du spectacle ou suppression
    public void AjouterBillet(Billet B){
        billets[nbB]=B;
        nbB++;
    }
    public void SupprimerBillet(int pos){
        for(int i=pos;i<nbB-1;i++){
            billets[i]=billets[i+1];
        }
        nbB--;
    }
    //Ajout des Artistes participant au spectacle ou suppression
    public void AjouterArtiste(Artiste A) {
        artistes[nbA] = A;
        nbA++;
    }
    public void SupprimerArtiste(int pos){
        for(int i=pos;i<nbB-1;i++){
            artistes[i]=artistes[i+1];
        }
        nbA--;
    }
    //Méthode pour afficher les informations d'un spectacle
    public void AfficheInfo(){
        System.out.println("Le nom du spectacle:"+this.nom);
        System.out.println("La date du spectacle:"+this.date);
        System.out.println("L'heure du spectacle:"+this.heure);
        System.out.println("L'ID du spectacle:"+this.ID);
        System.out.println("La durée du spectacle:"+this.duree);
        System.out.println("Le nom du monument ou déroule le spectacle:"+this.monument.getNom());
        System.out.println("Les Artistes participants a ce spectacle:");
        for (int i=0;i<nbA;i++) {
            System.out.print(artistes[i].getNom()+"|");
        }

    }
    //Méthodes pour Modifier les Informations du spectacle (selon le choix de l'utilisateur

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public void setID(int numero) {
        this.ID = numero;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public void setMonument(Monument monument) {
        this.monument = monument;
        monument.AjouterSpectacle(this);
    }

    public void setBillets(Billet[] billets) {
        this.billets = billets;
    }

    public void setArtistes(Artiste[] artistes) {
        this.artistes = artistes;
    }
    //Méthodes pour récupérer les attributs de la classe

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public int getID() {
        return ID;
    }

    public int getDuree() {
        return duree;
    }

    public Monument getMonument() {
        return monument;
    }

    public Billet[] getBillets() {
        return billets;
    }

    public Artiste[] getArtistes() {
        return artistes;
    }
}
