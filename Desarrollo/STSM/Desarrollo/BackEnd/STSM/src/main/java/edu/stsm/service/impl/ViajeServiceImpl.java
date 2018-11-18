package edu.stsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.stsm.dao.IViajeDAO;
import edu.stsm.entity.Viaje;
import edu.stsm.service.IViajeService;

@Service
public class ViajeServiceImpl implements IViajeService{

	@Autowired
	private IViajeDAO viajeDAO;
	
	@Override
	public List<Viaje> getAllViajes() {
		// TODO Auto-generated method stub
		List<Viaje> viajeList = viajeDAO.getAllViajes();
		return viajeList;
	}

	@Override
	public Viaje getViajeById(Integer idViaje) {
		// TODO Auto-generated method stub
		Viaje viaje = viajeDAO.getViajeById(idViaje);
		return viaje;
	}

	@Override
	public Viaje addViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		Viaje addedViaje = viajeDAO.addViaje(viaje);
		return addedViaje;
	}

	@Override
	public Viaje updateViaje(Viaje viaje) {
		// TODO Auto-generated method stub
		Viaje updatedViaje = viajeDAO.updateViaje(viaje);
		return updatedViaje;
	}

	@Override
	public void deleteViaje(Integer idViaje) {
		// TODO Auto-generated method stub
		viajeDAO.deleteViaje(idViaje);
	}

}
