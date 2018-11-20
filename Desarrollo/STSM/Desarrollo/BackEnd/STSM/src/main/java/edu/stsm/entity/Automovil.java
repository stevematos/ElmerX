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
public class Automovil implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idAutomovil;

    private String modelo;

    private int asientos;

    private String soat;

    public Automovil() {
    }

    public Automovil(Integer idAutomovil) {
        this.idAutomovil = idAutomovil;
    }

    public Automovil(Integer idAutomovil, String modelo, int asientos, String soat) {
        this.idAutomovil = idAutomovil;
        this.modelo = modelo;
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
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAutomovil == null) ? 0 : idAutomovil.hashCode());
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
		Automovil other = (Automovil) obj;
		if (idAutomovil == null) {
			if (other.idAutomovil != null)
				return false;
		} else if (!idAutomovil.equals(other.idAutomovil))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Automovil [idAutomovil=" + idAutomovil + ", modelo=" + modelo + ", asientos=" + asientos + ", soat="
				+ soat + "]";
	}
    
}
