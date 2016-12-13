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
import pk.ssi.studentForm;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class Database implements Serializable {
    
    private NewHibernateUtil helper;
    private Session session;
    
    public void addStudent(int id, String imie, String nazwisko, String uczelnia){
        
        studentForm s = new studentForm(id,imie,nazwisko,uczelnia);
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(s);
        session.save(s);
        session.getTransaction().commit();
        session.close();
    }

    public Map<Integer, studentForm> getAllStudents(){
        
        Map<Integer, studentForm> ss = new HashMap<Integer, studentForm>();
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        
        int j = 2;
        for (int i = 1; i < j; i++){
            studentForm ele = (studentForm) session.get(studentForm.class, i); 
            if (ele != null){
                ss.put(i, ele);
                j++;
            }
        }
        
        session.close();
        return ss;
    }
    
    public void delete(int id, String imie, String nazwisko, String uczelnia){
        
        studentForm s = new studentForm(id,imie,nazwisko,uczelnia);
        
        session = helper.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(s);
        session.getTransaction().commit();
        session.close();
    }
    
}
