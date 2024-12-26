public class Monument {
    private int ID,nbplaces;
    private String nom,ville;
    private Spectacle[]spectacles=new Spectacle[100];
    private int nbS=0;

    public Monument(String nom) {
        this.nom = nom;
    }

    public int getID() {
        return ID;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public String getNom() {
        return nom;
    }

    public String getVille() {
        return ville;
    }

    public void AfficheInfo(){
        System.out.println("Le nom du monument: "+this.nom);
        System.out.println("La ville du monument: "+this.ville);
        System.out.println("L'ID' du monument: "+this.ID);
        System.out.println("Le nombre des places que comporte le monument: "+this.nbplaces);
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    public void AjouterSpectacle(Spectacle S){
        spectacles[nbS]=S;
        nbS++;
    }
    public void SupprimerSpectacle(int pos){
        for(int i=pos;i<nbS-1;i++){
            spectacles[i]=spectacles[i+1];
        }
        nbS--;
    }
    public void AfficherSpectacles(){
        System.out.println("L'historique des spectacles qui ont eu place dans ce monument:");
        for(int i=0 ;i<nbS;i++) {
            spectacles[i].AfficheInfo();
            System.out.println("\n");
        }
    }

    public int getNbS() {
        return nbS;
    }
}
