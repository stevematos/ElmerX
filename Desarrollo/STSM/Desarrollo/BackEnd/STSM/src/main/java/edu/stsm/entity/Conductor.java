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
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idConductor;
    
    private String licencia;
    
    private List<Automovil> automovilList;
    
    private Automovil idAutomovil;
    
    private Usuario idUsuario;

    public Conductor() {
    }

    public Conductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public Conductor(Integer idConductor, String licencia) {
        this.idConductor = idConductor;
        this.licencia = licencia;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public List<Automovil> getAutomovilList() {
        return automovilList;
    }

    public void setAutomovilList(List<Automovil> automovilList) {
        this.automovilList = automovilList;
    }

    public Automovil getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Automovil idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConductor != null ? idConductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.idConductor == null && other.idConductor != null) || (this.idConductor != null && !this.idConductor.equals(other.idConductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.stsm.entity.Conductor[ idConductor=" + idConductor + " ]";
    }
    
}
