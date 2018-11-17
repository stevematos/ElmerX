package edu.stsm.service;

import java.util.List;

import edu.stsm.entity.Viaje;

public interface IViajeService {
	
	List<Viaje> getAllViajes();
    Viaje getViajeById(Integer idViaje);
    Viaje addViaje(Viaje viaje);
    Viaje updateViaje(Viaje viaje);
    void deleteViaje(Integer idViaje);

}

