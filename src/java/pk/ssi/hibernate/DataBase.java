/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi.hibernate;

import com.sun.xml.fastinfoset.util.StringArray;
import java.io.Serializable;
import java.util.ArrayList;
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
import pk.ssi.cennikForm;

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
    
    private String parser(String string){
        
        String value = "";
        for (char c : string.toCharArray()) {
            if (c != ' '){
                value += c;
            }
        }
        
        return value;
    }
    
    public String[] searchId(String id){
        
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
        System.out.println("pk.ssi.hibernate.DataBase.searchId()");
        String query = "SELECT id, usr_id, imie, nazwisko FROM pk.ssi.administratorForm WHERE USR_ID = "
                + id;
        System.out.println(query);
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList array = (ArrayList) session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        if (array != null) {
         
            Object[] admin = (Object[])array.get(0);
            
            String[] arrayString  = new String[]{String.valueOf(admin[0]), String.valueOf(admin[1]), 
            parser(String.valueOf(admin[2])), parser(String.valueOf(admin[3])) };
            return arrayString;
        }
        return null;
    }
    
    public String[][] searchFreeTask(){
        
        System.out.println("pk.ssi.hibernate.DataBase.searchTask()");
        String query = "SELECT id, opis, cena, progres FROM pk.ssi.zadanieForm WHERE pracownik_id is null";
        System.out.println(query);
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList array = (ArrayList) session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        
        if (array != null) {
            
            Object[][] value = new Object[array.size()][4];
            for (int i = 0; i < array.size(); i++){
                value[i] = (Object[])array.get(i);
            }
            
            String[][] arrayString = new String[array.size()][4];
            for (int j = 0; j < value.length; j ++){
                
                arrayString[j] = new String[]{String.valueOf(value[j][0]), 
                    String.valueOf(value[j][1]), String.valueOf(value[j][2]), 
                    String.valueOf(value[j][3]) };
            }
//            for (String[] string : arrayString) {
//                System.out.println("Tablica dane");
//                for (String ele : string)
//                System.out.println(ele + " ");
//            }
            
            return arrayString;
        }
        return null;
    }
    
    public String[][] searchAllEmployers(){
        
        System.out.println("pk.ssi.hibernate.DataBase.searchTask()");
        String query = "SELECT id, imie, nazwisko FROM pk.ssi.pracownikForm";
        System.out.println(query);
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList array = (ArrayList) session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
        
        if (array != null) {
            
            Object[][] value = new Object[array.size()][3];
            for (int i = 0; i < array.size(); i++){
                value[i] = (Object[])array.get(i);
            }
            
            String[][] arrayString = new String[array.size()][3];
            for (int j = 0; j < value.length; j ++){
                
                arrayString[j] = new String[]{String.valueOf(value[j][0]), 
                    parser(String.valueOf(value[j][1])), parser(String.valueOf(value[j][2]))};
            }
            for (String[] string : arrayString) {
                System.out.println("Tablica dane 2");
                for (String ele : string)
                System.out.println(ele + " ");
            }
            
            return arrayString;
        }
        return null;
    }
    
    public void assignTask(int id_pracownik, int id_zadanie){
        
        String query = "UPDATE pk.ssi.zadanieForm" +
                       " SET pracownik_id=" + id_pracownik +
                       " WHERE id=" + id_zadanie;
        System.out.println(query);
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.createQuery(query).executeUpdate();
        session.getTransaction().commit();
        session.close();
    }
    
    public List<String[]> searchActiveTaskt(){
        
        String[][] pracownik = null;
        Object[][] value = null;
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        
        String query = "SELECT id,imie,nazwisko FROM pk.ssi.pracownikForm";
        ArrayList array = (ArrayList) session.createQuery(query).list();
        
        if (array != null) {

            pracownik = new String[array.size()][3];
            value = new Object[array.size()][3];
            
            for (int i = 0; i < array.size(); i++){
                value[i] = (Object[])array.get(i);
                pracownik[i] =  new String[]{String.valueOf(value[i][0]), 
                    String.valueOf(value[i][1]), String.valueOf(value[i][2])} ;
            }

//            for (String object[] : pracownik) {
//                System.out.println("---------------------------");
//                for (String string : object) {
//                    System.out.println(string);
//                }
//            }
        }
        List<String[]> przydzielone_zadania = null;
        if (pracownik != null){
            
            przydzielone_zadania = new ArrayList();
            for (String[] pra: pracownik){

                query = "SELECT opis FROM pk.ssi.zadanieForm where"
                        + " pracownik_id="+pra[0];
                array = (ArrayList) session.createQuery(query).list();
                if (!array.isEmpty()) {

                    String[] val = new String[array.size()];
                    for (int _i = 0; _i < array.size(); _i++){
                        if (array.get(_i) != null){
                            val[_i] = (String)array.get(_i);
                        }
                    }
                     
                    for (String object : val) {
                        if (object != ""){
                            przydzielone_zadania.add(
                                            new String[]{pra[1],pra[2],object});
                        }
                    }
                }
            }
           
            for (String[] object : przydzielone_zadania) {
                System.out.println("-------------------------------------");
                for (String string : object) {
                    System.out.println(string);
                }
            }
            
        }
        session.getTransaction().commit();
        session.close();
        
        return przydzielone_zadania;
    }
    
    public void deleteTask(String opis){
        
        System.out.println("pk.ssi.hibernate.DataBase.deleteTask()");
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        
        String query = "delete from pk.ssi.zadanieForm where opis='" + opis+"'";
        session.createQuery(query).executeUpdate();
        
        session.getTransaction().commit();
        session.close();
    }
    
    public HashMap<Integer, cennikForm> get_data_from_price_list()
    {
        
//        String query = "SELECT * FROM pk.ssi.cennikForm WHERE category=" + category;
//        System.out.println(query);
//        session = helper.getSessionFactory().openSession();
//        session.beginTransaction();
//        ArrayList array = (ArrayList) session.createQuery(query).list();
//        session.getTransaction().commit();
//        session.close();
//      
        HashMap<Integer, cennikForm> ss = new HashMap<Integer,cennikForm>();
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        
        int j = 2;
        for (int i = 1; i < j; i++){
            cennikForm ele = (cennikForm) session.get(cennikForm.class, i); 
            
//            System.out.println("pk.ssi " + ele.getKolumna());
            
            if (ele != null){
                System.out.println("w if");
                ss.put(i, ele);
                j++;
            }
        }
        
        session.getTransaction().commit();
        session.close();
        
        return ss;
    }
    
    public ArrayList<String> get_data_from_price_list1()
    {
        
        String query = "SELECT * FROM pk.ssi.cennikForm WHERE category=" + "1";
        System.out.println(query);
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        ArrayList array = (ArrayList) session.createQuery(query).list();
        session.getTransaction().commit();
        session.close();
   
        return array;
    }
    
}
