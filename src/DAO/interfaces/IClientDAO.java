/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

import entities.Client;
import entities.Utilisateur;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jemacom
 */
public interface IClientDAO {
    ArrayList<Client> SelectClient();
    ArrayList<String> SelectLogin(String pattern);
    void ajoutClient(   Client client);
    void deleteClient(String login);
    void updateClient(String login, String password);
    Client findClientByLogin (String login);
    Utilisateur findUserByLogin (String login);
    List<Client> DiplayAllClient();
    
    
}
    