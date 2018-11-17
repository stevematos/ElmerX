package edu.stsm.service;

import java.util.List;

import edu.stsm.entity.Conductor;

public interface IConductorService {
	
	List<Conductor> getAllConductors();
    Conductor getConductorById(Integer idConductor);
    Conductor addConductor(Conductor conductor);
    Conductor updateConductor(Conductor conductor);
    void deleteConductor(Integer idConductor);

}
