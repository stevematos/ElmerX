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
    
    private Integer idAutomovil;

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

    public Integer getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		Viaje other = (Viaje) obj;
		if (idViaje == null) {
			if (other.idViaje != null)
				return false;
		} else if (!idViaje.equals(other.idViaje))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Viaje [idViaje=" + idViaje + ", inicio=" + inicio + ", fin=" + fin + ", cupos=" + cupos
				+ ", cuposDisponibles=" + cuposDisponibles + ", enCurso=" + enCurso + ", idAutomovil=" + idAutomovil
				+ "]";
	}

}
