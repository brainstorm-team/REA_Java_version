/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

import entities.Offre;
import java.util.List;

/**
 *
 * @author jemacom
 */
public interface IOffreDAO {
    
    
    void insertOffre(Offre offre);
    void updateOffre(Offre offre);
    void deleteOffre(int id);
    List<Offre> getAllUnValidatedOffers();
    List<Offre> getAllValidatedOffers();
    List<Offre> DisplayAllOffre();
    Offre findOffreById(int id);
    List<Offre> recherche (String titre, String type, String categorie,String ville, Double prix ,int surface );
    List<Offre> getMesOffres();

}
