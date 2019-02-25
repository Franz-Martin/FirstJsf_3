/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ibb.ctrl;

import com.ibb.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;



/**
 *
 * @author schulung
 */
@ManagedBean(name = "meinController")
@SessionScoped
public class WebCtrl {
    private Person person;
    private List<Person> listPersonen;

    public WebCtrl() {
        listPersonen=new ArrayList<>();
        person=new Person();
    }

    
    
    
    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getListPersonen() {
        return listPersonen;
    }

    public void setListPersonen(List<Person> listPersonen) {
        this.listPersonen = listPersonen;
    }
    
    //================================= Eigene Methoden
    
    public String addPerson(){
        listPersonen.add(person);
        person=new Person();
        return "zurDritten";
    }
    
    
    public void doSomething(){
        HttpServletRequest request=callRequest();
        System.out.println("Firstname.....:"+person.toString());
    }
   public void doSomething1(){
        System.out.println("Firstname.....:"+person.toString());
    } 
    
   private HttpServletRequest callRequest(){
       return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
   }
   
}
