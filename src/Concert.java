import java.time.LocalTime;

public class Concert extends Spectacle {
    String genre,nomtournee;

    public Concert(String nom, String date, LocalTime heure, int ID, int duree, String genre, String nomtournee) {
        super(nom, date, heure, ID, duree);
        this.genre = genre;
        this.nomtournee = nomtournee;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNomtournee(String nomtournee) {
        this.nomtournee = nomtournee;
    }

    @Override
    public void AfficheInfo() {
        super.AfficheInfo(); // Affiche les informations de base du spectacle
        System.out.println("Genre musical: " + this.genre);
        System.out.println("Le nom de la tournée du concert: " + this.nomtournee);
    }

}
