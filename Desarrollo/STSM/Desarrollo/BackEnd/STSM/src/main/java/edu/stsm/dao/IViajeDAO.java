package edu.stsm.dao;

import java.util.List;

import edu.stsm.entity.Viaje;

public interface IViajeDAO {
	
	List<Viaje> getAllViajes();
    Viaje getViajeById(Integer idViaje);
    Viaje addViaje(Viaje viaje);
    Viaje updateViaje(Viaje viaje);
    void deleteViaje(Integer idViaje);

}

