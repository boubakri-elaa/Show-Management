public class Client {
    private String nom;
    private int ID;
    private Billet [] billets=new Billet[100];
    private int nbB=0;

    public Client(String nom, int ID) {
        this.nom = nom;
        this.ID = ID;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
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
    public int NombreBillets(){
        return nbB;
    }

    public String getNom() {
        return nom;
    }

    public int getID() {
        return ID;
    }

    public void afficheInfos(){
        System.out.println("Le nom du client: "+this.nom);
        System.out.println("L'ID du client: "+this.ID);
        System.out.println("Le nombre de billets du client: "+this.NombreBillets());
        System.out.println("Les informations des billets du client: ");
        for (int i=0;i<nbB;i++){
            System.out.println("Numéro du billet: "+billets[i].getNumero());
            System.out.println("Prix du billet: "+billets[i].getPrix());
        }


    }
}
