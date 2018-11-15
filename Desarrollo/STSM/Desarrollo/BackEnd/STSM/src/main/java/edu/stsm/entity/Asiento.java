/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.stsm.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jhunior Cuadros
 */
public class Asiento implements Serializable {

    private static final long serialVersionUID = 1L;
    
    protected AsientoPK asientoPK;
    
    private Date horaOcupacion;
    
    private Pasajero pasajero;
    
    private Viaje viaje;

    public Asiento() {
    }

    public Asiento(AsientoPK asientoPK) {
        this.asientoPK = asientoPK;
    }

    public Asiento(AsientoPK asientoPK, Date horaOcupacion) {
        this.asientoPK = asientoPK;
        this.horaOcupacion = horaOcupacion;
    }

    public Asiento(int idViaje, int idPasajero) {
        this.asientoPK = new AsientoPK(idViaje, idPasajero);
    }

    public AsientoPK getAsientoPK() {
        return asientoPK;
    }

    public void setAsientoPK(AsientoPK asientoPK) {
        this.asientoPK = asientoPK;
    }

    public Date getHoraOcupacion() {
        return horaOcupacion;
    }

    public void setHoraOcupacion(Date horaOcupacion) {
        this.horaOcupacion = horaOcupacion;
    }

    public Pasajero getPasajero() {
        return pasajero;
    }

    public void setPasajero(Pasajero pasajero) {
        this.pasajero = pasajero;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asientoPK != null ? asientoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asiento)) {
            return false;
        }
        Asiento other = (Asiento) object;
        if ((this.asientoPK == null && other.asientoPK != null) || (this.asientoPK != null && !this.asientoPK.equals(other.asientoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.stsm.entity.Asiento[ asientoPK=" + asientoPK + " ]";
    }
    
}
