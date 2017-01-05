/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi;

/**
 *
 * @author DominikP
 */
public class cennikForm {
    
    private int id;
    private int wartosc;
    private String kolumna;
    private int category;
    
    public cennikForm() {
    }
    
    public cennikForm(int id, int wartosc, String kolumna, int category) {
        
        this.id = id;
        this.wartosc = wartosc;
        this.kolumna = kolumna;
        this.category = category;        
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWartosc() {
        return wartosc;
    }

    public void setWartosc(int wartosc) {
        this.wartosc = wartosc;
    }

    public String getKolumna() {
        return kolumna;
    }

    public void setKolumna(String kolumna) {
        this.kolumna = kolumna;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
