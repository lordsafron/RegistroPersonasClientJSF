/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonasclientjsf.bean;

import com.hm.registropersonabusiness.service.PersonaService;
import com.hm.registropersonaentities.entities.Persona;
import com.hm.registropersonasclientjsf.util.Utilidades;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import org.apache.log4j.Logger;

/**
 *
 * @author HugoM
 */
@ManagedBean(name = "personaListView")
public class PersonaListView implements Serializable {

    private static final Logger log = Logger.getLogger(PersonaListView.class);
    
    

    @EJB(mappedName = "PersonaService")
    private PersonaService personaService;
    
    private Persona selectedPersona = new Persona();
    
    @PostConstruct
    public void init() {
    }

            
    public List<Persona> getlPersona() {
        List<Persona> lPersona = new ArrayList<>();
        try {
            personaService = (PersonaService) Utilidades.getEJBRemote("PersonaService", PersonaService.class.getName());
            lPersona = personaService.getAllPersons();
            return lPersona;
        } catch (Exception ex) {
            return lPersona;
        }
        
    }

    public Persona getSelectedPersona() {
        return selectedPersona;
    }

    public void setSelectedPersona(Persona selectedPersona) {
        this.selectedPersona = selectedPersona;
    }
    
    
}
