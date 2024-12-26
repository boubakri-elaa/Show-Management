public class Artiste {
    private String nom,domaine;
    private Spectacle spectacle;

    public Artiste(String n, Spectacle s, String d) {
        this.nom = n;
        this.spectacle = s;
        this.domaine = d;
    }

    public String getNom() {
        return nom;
    }
    // Méthode pour affecter un spectacle à l'artiste
    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    // Méthode pour obtenir le spectacle de l'artiste
    public Spectacle getSpectacle() {
        return spectacle;
    }
}
