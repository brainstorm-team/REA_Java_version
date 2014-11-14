package entities;

public class Message {

    private int idMessage;
    private String message;
    private String sujet;
    private String reponsemsg;
    private int Id_client;
    private int Id_gerant;
    private Utilisateur Utilisateur;

//private java.sql.Date datede;	
    public int getIdmessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getReponsemsg() {
        return reponsemsg;
    }

    public void setReponsemsg(String reponsemsg) {
        this.reponsemsg = reponsemsg;
        
    }

    public void setId_client(int Id_client) {
        this.Id_client = Id_client;
    }

    public void setId_gerant(int Id_gerant) {
        this.Id_gerant = Id_gerant;
    }
    
    public int getId_client() {
        return Id_client;
    }

    public int getId_gerant() {
        return Id_gerant;
    }

    public int getIdMessage() {
        return idMessage;
    }

    public Utilisateur getUtilisateur() {
        return Utilisateur;
    }

    /**
     * @param depot the depot to set
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.Utilisateur = utilisateur;
    }

}
