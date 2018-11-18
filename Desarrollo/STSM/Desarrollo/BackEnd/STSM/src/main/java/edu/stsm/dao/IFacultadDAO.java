package edu.stsm.dao;

import java.util.List;

import edu.stsm.entity.Facultad;

public interface IFacultadDAO {
	
	List<Facultad> getAllFacultades();
    Facultad getFacultadById(Integer idFacultad);
    Facultad addFacultad(Facultad facultad);
    Facultad updateFacultad(Facultad facultad);
    void deleteFacultad(Integer idFacultad);

}
