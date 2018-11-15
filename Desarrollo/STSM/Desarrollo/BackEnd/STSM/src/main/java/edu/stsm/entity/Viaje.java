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
public class Viaje implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idViaje;
    
    private String inicio;
    
    private String fin;
    
    private int cupos;
    
    private int cuposDisponibles;
    
    private boolean enCurso;
    
    private Automovil idAutomovil;
    
    private List<Asiento> asientoList;

    public Viaje() {
    }

    public Viaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public Viaje(Integer idViaje, String inicio, String fin, int cupos, int cuposDisponibles, boolean enCurso) {
        this.idViaje = idViaje;
        this.inicio = inicio;
        this.fin = fin;
        this.cupos = cupos;
        this.cuposDisponibles = cuposDisponibles;
        this.enCurso = enCurso;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public int getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(int cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public boolean getEnCurso() {
        return enCurso;
    }

    public void setEnCurso(boolean enCurso) {
        this.enCurso = enCurso;
    }

    public Automovil getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Automovil idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public List<Asiento> getAsientoList() {
        return asientoList;
    }

    public void setAsientoList(List<Asiento> asientoList) {
        this.asientoList = asientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idViaje != null ? idViaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viaje)) {
            return false;
        }
        Viaje other = (Viaje) object;
        if ((this.idViaje == null && other.idViaje != null) || (this.idViaje != null && !this.idViaje.equals(other.idViaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.stsm.entity.Viaje[ idViaje=" + idViaje + " ]";
    }
    
}
