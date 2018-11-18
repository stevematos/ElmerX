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
public class Pasajero implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idPasajero;
    
    private Integer idUsuario;

    public Pasajero() {
    }

    public Pasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Integer getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPasajero == null) ? 0 : idPasajero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pasajero other = (Pasajero) obj;
		if (idPasajero == null) {
			if (other.idPasajero != null)
				return false;
		} else if (!idPasajero.equals(other.idPasajero))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pasajero [idPasajero=" + idPasajero + ", idUsuario=" + idUsuario + "]";
	}

}
