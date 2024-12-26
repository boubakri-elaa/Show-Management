import java.time.LocalTime;

public class PieceTheatrale extends Spectacle{
    private String genre,langue,public_cible;
    private int nbActes;

    public PieceTheatrale(String nom, String date, LocalTime heure, int ID, int duree, String genre, String langue, int nbActes, String public_cible) {
        super(nom, date, heure, ID, duree);
        this.genre = genre;
        this.langue = langue;
        this.nbActes = nbActes;
        this.public_cible = public_cible;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setNbActes(int nbActes) {
        this.nbActes = nbActes;
    }

    public void setPublic_cible(String public_cible) {
        this.public_cible = public_cible;
    }
    @Override
    public void AfficheInfo() {
        super.AfficheInfo(); // Afficher les informations de base du spectacle
        System.out.println("\n Genre de la pièce: " + this.genre);
        System.out.println("Nombre d'actes: " + this.nbActes);
        System.out.println("Public cible: " + this.public_cible);
        System.out.println("Langue : " + this.langue);
    }

}
