/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;
/**
 *
 * @author User
 */

@Table(name="Administrator")  
@Entity 
public class administratorForm {
    
    @NotNull
    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String imie;
   
    private int usr_id = -1;
    
    @NotNull
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String nazwisko;
    
    @Id
    @GeneratedValue
    private int id;

    public administratorForm(int id, String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }
    
    public administratorForm(){
        
    }
    
    public void setUsr_id(int usr_id){
        this.usr_id = usr_id;
    }
    
    public int getUsr_id(){
        return this.usr_id;
    }
    
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
}
