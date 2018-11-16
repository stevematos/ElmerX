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
  
    private Integer idAutomovil;
    
    private Integer idUsuario;

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

    public Integer getIdAutomovil() {
        return idAutomovil;
    }

    public void setIdAutomovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
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
		result = prime * result + ((idConductor == null) ? 0 : idConductor.hashCode());
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
		Conductor other = (Conductor) obj;
		if (idConductor == null) {
			if (other.idConductor != null)
				return false;
		} else if (!idConductor.equals(other.idConductor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Conductor [idConductor=" + idConductor + ", licencia=" + licencia + ", idAutomovil=" + idAutomovil
				+ ", idUsuario=" + idUsuario + "]";
	}

}
