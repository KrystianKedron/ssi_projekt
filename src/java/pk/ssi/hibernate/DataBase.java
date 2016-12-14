/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi.hibernate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import org.hibernate.Session;
import pk.ssi.hibernate.NewHibernateUtil;
import pk.ssi.userForm;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class DataBase implements Serializable {
    
    private NewHibernateUtil helper;
    private Session session;
    
    public void addUser(int id, String imie, String nazwisko){
        
        userForm s = new userForm(id,imie,nazwisko);
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
//        session.delete(s);
        session.save(s);
        session.getTransaction().commit();
        session.close();
    }

    public Map<Integer, userForm> getAllUsers(){
        
        Map<Integer, userForm> ss = new HashMap<Integer, userForm>();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        
        int j = 2;
        for (int i = 1; i < j; i++){
            userForm ele = (userForm) session.get(userForm.class, i); 
            if (ele != null){
                ss.put(i, ele);
                j++;
            }
        }
        
        session.close();
        return ss;
    }
    
    public void delete(int id, String imie, String nazwisko){
        
        userForm s = new userForm(id,imie,nazwisko);
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(s);
        session.getTransaction().commit();
        session.close();
    }
    
}
