package edu.stsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.stsm.dao.IFacultadDAO;
import edu.stsm.entity.Facultad;
import edu.stsm.service.IFacultadService;

@Service
public class FacultadServiceImpl implements IFacultadService{

	@Autowired
	private IFacultadDAO facultadDAO;
	
	@Override
	public List<Facultad> getAllFacultades() {
		// TODO Auto-generated method stub
		List<Facultad> facultadList = facultadDAO.getAllFacultades();
		return facultadList;
	}

	@Override
	public Facultad getFacultadById(Integer idFacultad) {
		// TODO Auto-generated method stub
		Facultad facultad = facultadDAO.getFacultadById(idFacultad);
		return facultad;
	}

	@Override
	public Facultad addFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		Facultad addedFacultad = facultadDAO.addFacultad(facultad);
		return addedFacultad;
	}

	@Override
	public Facultad updateFacultad(Facultad facultad) {
		// TODO Auto-generated method stub
		Facultad updatedFacultad = facultadDAO.updateFacultad(facultad);
		return updatedFacultad;
	}

	@Override
	public void deleteFacultad(Integer idFacultad) {
		// TODO Auto-generated method stub
		facultadDAO.deleteFacultad(idFacultad);
	}

}

