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
public interface IFavorisDAO {
    void insertFavoris(int id);
    void deleteFavoris(int id);
    List<Offre> DisplayAllFavoris();
    boolean rechercherFavoris(int ID);
    String evaluationFavoris(int ID );
}
