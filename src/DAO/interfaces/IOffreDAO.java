/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

import entities.Offre;

/**
 *
 * @author jemacom
 */
public interface IOffreDAO {
    
    
    void insertOffre(Offre offre);
    void updateOffre(Offre offre);
    void deleteOffre(int id);
    
}