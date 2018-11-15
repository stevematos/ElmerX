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
public class Facultad implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idFacultad;
    
    private String nombre;
    
    private List<Usuario> usuarioList;

    public Facultad() {
    }

    public Facultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public Facultad(Integer idFacultad, String nombre) {
        this.idFacultad = idFacultad;
        this.nombre = nombre;
    }

    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacultad != null ? idFacultad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facultad)) {
            return false;
        }
        Facultad other = (Facultad) object;
        if ((this.idFacultad == null && other.idFacultad != null) || (this.idFacultad != null && !this.idFacultad.equals(other.idFacultad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.stsm.entity.Facultad[ idFacultad=" + idFacultad + " ]";
    }
    
}
