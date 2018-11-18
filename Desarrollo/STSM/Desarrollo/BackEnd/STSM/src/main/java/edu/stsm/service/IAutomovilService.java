package edu.stsm.service;

import java.util.List;

import edu.stsm.entity.Automovil;

public interface IAutomovilService {
	
	List<Automovil> getAllAutomoviles();
    Automovil getAutomovilById(Integer idAutomovil);
    Automovil addAutomovil(Automovil automovil);
    Automovil updateAutomovil(Automovil automovil);
    void deleteAutomovil(Integer idAutomovil);

}
