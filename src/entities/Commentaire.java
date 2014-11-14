package entities;

public class Commentaire {

    private int idCommentaire;
    private String commentaire;
    private String reponse;
    private int Id_offre;
    private int Id_client;
    private int Id_gerant;

    public int getIdCommentaire() {
        return idCommentaire;
    }

    public void setIdCommentaire(int idCommentaire) {
        this.idCommentaire = idCommentaire;
    }

    public void setId_offre(int Id_offre) {
        this.Id_offre = Id_offre;
    }

    public void setId_client(int Id_client) {
        this.Id_client = Id_client;
    }

    public void setId_gerant(int Id_gerant) {
        this.Id_gerant = Id_gerant;
    }

    public int getId_offre() {
        return Id_offre;
    }

    public int getId_client() {
        return Id_client;
    }

    public int getId_gerant() {
        return Id_gerant;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;

    }

}
