/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.interfaces;

import entities.Message;
import java.util.List;

/**
 *
 * @author mahdi
 */
public interface IMessageDAO {

    public void insertMessage(Message message);

    void updateMessage(Message message);

    void deleteMessage(int id);

    Message findMessageById(int id);

    Message findMessageByAdresse(String adr);

    List<Message> DisplayAllMessages();
}
