package edu.stsm.service;

import java.util.List;

import edu.stsm.entity.Asiento;

public interface IAsientoService {

	List<Asiento> getAllAsientos();
    Asiento getAsientoById(Integer idViaje, Integer idPasajero);
    Asiento addAsiento(Asiento asiento);
    Asiento updateAsiento(Asiento asiento);
    void deleteAsiento(Integer idViaje, Integer idPasajero);
    
}
