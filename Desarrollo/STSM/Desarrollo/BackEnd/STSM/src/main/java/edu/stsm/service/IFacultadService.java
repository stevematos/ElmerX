package edu.stsm.service;

import java.util.List;

import edu.stsm.entity.Facultad;

public interface IFacultadService {
	
	List<Facultad> getAllFacultads();
    Facultad getFacultadById(Integer idFacultad);
    Facultad addFacultad(Facultad facultad);
    Facultad updateFacultad(Facultad facultad);
    void deleteFacultad(Integer idFacultad);

}
