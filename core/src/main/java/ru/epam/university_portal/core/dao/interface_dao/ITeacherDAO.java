package ru.epam.university_portal.core.dao.interface_dao;

import ru.epam.university_portal.model.entity.*;

import java.util.Date;

/**
 * Created by maksim on 12.05.16.
 */
public interface ITeacherDAO {

     void create (String login, String password, String namePost) throws Exception ;
     void createOrUpdate(String login, String password, String namePost, String name, String lastName, Date date)
            throws Exception ;
     Teacher get(String name, String lastName) ;
     Teacher getByLoginAndPassword(String login, String password) ;
     void addNewMessage(String fromName, String fromLastName, String toNameTeacher, String toLastNameTeacher, String message) throws Exception ;
     void clearNewMessages(String name, String lastName) throws Exception;
     void clearNewMessagesByLoginAndPassword(String login, String password) throws Exception;
     void remove(String login, String password) throws Exception ;


}
