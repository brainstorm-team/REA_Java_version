/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

import entities.Gerant;
import entities.Utilisateur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jemacom
 */
public interface IGerantDAO {
    
    ArrayList<Gerant> SelectGerant();
    ArrayList<String> SelectLogin(String pattern);
    void ajoutGerant(  Gerant  gerant);
    void deleteGerant(String login);
    void updateGerant(String login, String password);
    Gerant findGerantByLogin (String login);
    Utilisateur findUserByLogin (String login);
    int nombreGerant();
    List<Gerant> DisplayStat();
}
