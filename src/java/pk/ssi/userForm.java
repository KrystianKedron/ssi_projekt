/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pk.ssi;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

/**
 *
 * @author SSI4
 */
public class userForm {
    
    @NotNull
    @Email(message = "Prosze wpisac email")
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String email;
    
    @NotNull
    @Size(min=2, max=30, message ="Prosze podac wartosc pomiedzy 2 a 30")
    private String haslo;
    
    private int id = -1;

    public userForm(int id, String email, String haslo) {
        this.email = email;
        this.haslo = haslo;
        this.id = id;
    }
    
    public userForm(){
        
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }   
}
