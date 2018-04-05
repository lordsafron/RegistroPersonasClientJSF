/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hm.registropersonasclientjsf.bean;

import com.hm.registropersonabusiness.service.PersonaService;
import com.hm.registropersonaentities.entities.Persona;
import com.hm.registropersonasclientjsf.util.Utilidades;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.apache.log4j.Logger;
import org.primefaces.PrimeFaces;

/**
 *
 * @author HugoM
 */
@ManagedBean(name = "personaView")
public class PersonaView implements Serializable {

    private static final Logger log = Logger.getLogger(PersonaView.class);
    
    public PersonaView() {
    }
    
    private Persona persona = new Persona();

    @EJB(mappedName = "PersonaService")
    private PersonaService personaService;
    
    
    public void reset() {
        PrimeFaces.current().resetInputs("form:panel");
    }
    
    public void save() {
        try {
            personaService = (PersonaService) Utilidades.getEJBRemote("PersonaService", PersonaService.class.getName());
            boolean response = personaService.insertPerson(persona);
        } catch (Exception e) {
        }
        
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
