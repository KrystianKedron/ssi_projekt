/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi;

/**
 *
 * @author User
 */
public class zadanieForm {
    
    private int id = 0;
    
    private int pracownik_id = 0;
    private String opis = "";
    private int cena = 0;
    private int progres = 0;

    public zadanieForm() {
    }
    
    public zadanieForm(int id, int pracownik_id, String opis, int cena, int progres) {
        this.id = id;
        this.pracownik_id = pracownik_id;
        this.opis = opis;
        this.cena = cena;
        this.progres = progres;
    }
    
    public zadanieForm(int id, String opis, int cena, int progres) {
        
        this.id = id;
        this.opis = opis;
        this.cena = cena;
        this.progres = progres;
    }


    public int getProgres() {
        return progres;
    }

    public void setProgres(int progres) {
        this.progres = progres;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPracownik_id() {
        return pracownik_id;
    }

    public void setPracownik_id(int pracownik_id) {
        this.pracownik_id = pracownik_id;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
    
}
