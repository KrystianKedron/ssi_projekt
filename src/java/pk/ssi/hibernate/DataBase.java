/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi.hibernate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.query.dsl.QueryBuilder;
import pk.ssi.hibernate.NewHibernateUtil;
import pk.ssi.userForm;
import pk.ssi.administratorForm;

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
    
    public void searchId(int id){
        
        //session.saveOrUpdate(book);
//        System.out.println("pk.ssi.hibernate.DataBase.searchId()");
//        session = helper.getSessionFactory().openSession();
//        FullTextSession fullTextSession = org.hibernate.search.Search.getFullTextSession(session);
//        Transaction tx = fullTextSession.beginTransaction();
//        QueryBuilder qb = fullTextSession.getSearchFactory().buildQueryBuilder().forEntity( administratorForm.class ).get();
//        
//        System.out.println(id);
//        org.apache.lucene.search.Query query = qb.keyword().onFields("imie").matching("Krystian").createQuery();
//          // wrap Lucene query in a org.hibernate.Query
//        org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, administratorForm.class);
//          // execute search
//        List result = hibQuery.list();
//        
//        Iterator<administratorForm> it = result.iterator();
//        while (it.hasNext()) {
//         System.out.println("pk.ssi.hibernate.DataBase.searchId().weszlo");
//         administratorForm admin1 = (administratorForm) it.next();
//         System.out.println(admin1.getImie() + " " + admin1.getNazwisko());
//        }
//        tx.commit();
        session = helper.getSessionFactory().openSession();
        Query query = session.createQuery("SELECT imie FROM pk.ssi.administratorForm WHERE USR_ID = 1");
        System.out.println(query.list());
        
        session.close();
    }
}
