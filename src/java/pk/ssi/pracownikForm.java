package pk.ssi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class pracownikForm {
    
    private int id = 0;
    private int usr_id = 0;
    private String imie = "";
    private String nazwisko = "";

    public pracownikForm() {
    }
    
    public pracownikForm(int id, int usr_id, String imie, String nazwisko) {
        this.id = id;
        this.usr_id = usr_id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(int usr_id) {
        this.usr_id = usr_id;
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
    
    
    
}
