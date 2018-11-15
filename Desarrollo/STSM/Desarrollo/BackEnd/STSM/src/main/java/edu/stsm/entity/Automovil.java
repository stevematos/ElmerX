/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stsm.entity;

import java.io.Serializable;
import java.util.List;
/**
 *
 * @author Jhunior Cuadros
 */
public class Automovil implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idAutomovil;
    
    private String entityo;
    
    private int asientos;
    
    private String soat;
    
    private Conductor idConductor;
    
    private List<Viaje> viajeList;
    
    private List<Conductor> conductorList;

    public Automovil() {
    }

    public Automovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Automovil(Integer idAutomovil, String entityo, int asientos, String soat) {
        this.idAutomovil = idAutomovil;
        this.entityo = entityo;
        this.asientos = asientos;
        this.soat = soat;
    }

    public Integer getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public String getModelo() {
        return entityo;
    }

    public void setModelo(String entityo) {
        this.entityo = entityo;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public Conductor getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Conductor idConductor) {
        this.idConductor = idConductor;
    }

    public List<Viaje> getViajeList() {
        return viajeList;
    }

    public void setViajeList(List<Viaje> viajeList) {
        this.viajeList = viajeList;
    }

    public List<Conductor> getConductorList() {
        return conductorList;
    }

    public void setConductorList(List<Conductor> conductorList) {
        this.conductorList = conductorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutomovil != null ? idAutomovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Automovil)) {
            return false;
        }
        Automovil other = (Automovil) object;
        if ((this.idAutomovil == null && other.idAutomovil != null) || (this.idAutomovil != null && !this.idAutomovil.equals(other.idAutomovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.stsm.entity.Automovil[ idAutomovil=" + idAutomovil + " ]";
    }
    
}
