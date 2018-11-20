/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stsm.entity;

import java.io.Serializable;
import java.sql.Time;

/**
 *
 * @author Jhunior Cuadros
 */
public class Asiento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Time horaOcupacion;
    
    private Integer idPasajero;
    
    private Integer idViaje;

    public Asiento() {
    }

    public Time getHoraOcupacion() {
        return horaOcupacion;
    }

    public void setHoraOcupacion(Time horaOcupacion) {
        this.horaOcupacion = horaOcupacion;
    }

    public Integer getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Integer idPasajero) {
        this.idPasajero = idPasajero;
    }

    public Integer getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(Integer idViaje) {
        this.idViaje = idViaje;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPasajero == null) ? 0 : idPasajero.hashCode());
		result = prime * result + ((idViaje == null) ? 0 : idViaje.hashCode());
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
		Asiento other = (Asiento) obj;
		if (idPasajero == null) {
			if (other.idPasajero != null)
				return false;
		} else if (!idPasajero.equals(other.idPasajero))
			return false;
		if (idViaje == null) {
			if (other.idViaje != null)
				return false;
		} else if (!idViaje.equals(other.idViaje))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asiento [horaOcupacion=" + horaOcupacion + ", idPasajero=" + idPasajero + ", idViaje=" + idViaje + "]";
	}
	
}
