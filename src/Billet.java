public class Billet {
    private int numero;
    private double prix;
    private Spectacle spectacle;
    private Client client;

    public Billet(int numero, double prix, Spectacle spectacle, Client client) {
        this.numero = numero;
        this.prix = prix;
        this.spectacle = spectacle;
        this.client = client;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setSpectacle(Spectacle spectacle) {
        this.spectacle = spectacle;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getNumero() {
        return numero;
    }

    public double getPrix() {
        return prix;
    }
}
