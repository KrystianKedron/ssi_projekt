/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author SSI4
 */
public class userForm {
    
    @NotNull
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String imie;
    
    @NotNull
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String nazwisko;
    
    private int id = -1;

    public userForm(int id, String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.id = id;
    }
    
    public userForm(){
        
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
