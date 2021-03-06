package ru.epam.university_portal.core.dao.implementation_dao;

import org.hibernate.HibernateException;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import ru.epam.university_portal.core.dao.interface_dao.IUserDAO;
import ru.epam.university_portal.model.entity.User;

/**
 * Created by maksim on 02.05.16.
 */

@Repository
public class UserDAOImpl implements IUserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Transaction t = null;
        Session session=null;
        try {
            session=sessionFactory.getCurrentSession();
            t = session.beginTransaction();
            session.save(user);
            t.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            t.rollback();
        }
    }

   public User getUser(String login,String password) {
       Transaction transaction = null;
       Session session=null;
       User user = null;
       try {
           session = sessionFactory.getCurrentSession();
           transaction = session.beginTransaction();
           Query query = session.createQuery("from User a where a.login = :login");
           query.setParameter("login", login);
           user = (User) query.uniqueResult();
           transaction.commit();
       } catch (HibernateException e) {
           e.printStackTrace();
           transaction.rollback();
         //  ConnectionFactory.destroy();
       }
       if (user!=null){
        //   if (password.equals(user.password))
               return user;
       //    else return null;
       }else  return null;
   }
}
