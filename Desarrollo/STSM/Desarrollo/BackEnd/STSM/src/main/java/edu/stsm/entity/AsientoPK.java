/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stsm.entity;

import java.io.Serializable;

/**
 *
 * @author Jhunior Cuadros
 */
public class AsientoPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idViaje;

    private int idPasajero;

    public AsientoPK() {
    }

    public AsientoPK(int idViaje, int idPasajero) {
        this.idViaje = idViaje;
        this.idPasajero = idPasajero;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idViaje;
        hash += (int) idPasajero;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AsientoPK)) {
            return false;
        }
        AsientoPK other = (AsientoPK) object;
        if (this.idViaje != other.idViaje) {
            return false;
        }
        if (this.idPasajero != other.idPasajero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.stsm.entity.AsientoPK[ idViaje=" + idViaje + ", idPasajero=" + idPasajero + " ]";
    }
    
}
