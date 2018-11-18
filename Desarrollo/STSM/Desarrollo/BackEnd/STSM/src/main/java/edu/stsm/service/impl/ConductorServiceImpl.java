package edu.stsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.stsm.dao.IConductorDAO;
import edu.stsm.entity.Conductor;
import edu.stsm.service.IConductorService;

@Service
public class ConductorServiceImpl implements IConductorService{

	@Autowired
	private IConductorDAO conductorDAO;
	
	@Override
	public List<Conductor> getAllConductores() {
		// TODO Auto-generated method stub
		List<Conductor> conductorList = conductorDAO.getAllConductores();
		return conductorList;
	}

	@Override
	public Conductor getConductorById(Integer idConductor) {
		// TODO Auto-generated method stub
		Conductor conductor = conductorDAO.getConductorById(idConductor);
		return conductor;
	}

	@Override
	public Conductor addConductor(Conductor conductor) {
		// TODO Auto-generated method stub
		Conductor addedConductor = conductorDAO.addConductor(conductor);
		return addedConductor;
	}

	@Override
	public Conductor updateConductor(Conductor conductor) {
		// TODO Auto-generated method stub
		Conductor updatedConductor = conductorDAO.updateConductor(conductor);
		return updatedConductor;
	}

	@Override
	public void deleteConductor(Integer idConductor) {
		// TODO Auto-generated method stub
		conductorDAO.deleteConductor(idConductor);
	}

}

