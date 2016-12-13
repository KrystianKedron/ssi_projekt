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
public class studentForm {
    
    @NotNull
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String imie;
    
    @NotNull
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String nazwisko;
    
    @NotNull
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String uczelnia;
    private int id = -1;

    public studentForm(int id, String imie, String nazwisko, String uczelnia) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.uczelnia = uczelnia;
        this.id = id;
    }
    
    public studentForm(){
        
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

    public String getUczelnia() {
        return uczelnia;
    }

    public void setUczelnia(String uczelnia) {
        this.uczelnia = uczelnia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
}
