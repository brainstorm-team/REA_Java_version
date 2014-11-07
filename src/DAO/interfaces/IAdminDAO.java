/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

import entities.Admin;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jemacom
 */
public interface IAdminDAO {
    List<Admin> SelectAdmin();
    ArrayList<String> SelectLogin(String pattern);
    void insertAdmin(Admin admin);
    void updateAdmin(String login, String password);
    void deleteAdmin(String login);
    Admin findAdministrateurByLogin (String login);
    Admin findById(int id);
    void update(Admin user) ;
}
