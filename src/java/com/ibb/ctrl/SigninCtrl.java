/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.ctrl;

import com.ibb.model.Person;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author schulung
 */
@ManagedBean
@RequestScoped
public class SigninCtrl {
    
    private Person person;

    public SigninCtrl() {
        person=new Person();
    }

    
    
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
    
    public boolean isLogin(){
        return callRequest().isUserInRole("konfigurator") || callRequest().isUserInRole("sachbearbeiter");
    }
     public boolean isKonfigurator(){
        return callRequest().isUserInRole("konfigurator");
    }
    
     public boolean isSachbearbeiter(){
        return callRequest().isUserInRole("sachbearbeiter");
    }
     
     public void logout(){
        try {
            callRequest().logout();
        } catch (ServletException ex) {
            Logger.getLogger(SigninCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public void login(){
        try {
            callRequest().login(person.getEmail(), person.getPassword());
        } catch (ServletException ex) {
            Logger.getLogger(SigninCtrl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private HttpServletRequest callRequest(){
       return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
   }
}
