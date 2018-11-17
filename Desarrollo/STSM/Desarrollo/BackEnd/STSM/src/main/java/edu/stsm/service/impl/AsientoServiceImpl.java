package edu.stsm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.stsm.dao.IAsientoDAO;
import edu.stsm.entity.Asiento;
import edu.stsm.service.IAsientoService;

@Service
public class AsientoServiceImpl implements IAsientoService{

	@Autowired
	private IAsientoDAO asientoDAO;
	
	@Override
	public List<Asiento> getAllAsientos() {
		// TODO Auto-generated method stub
		List<Asiento> asientoList = asientoDAO.getAllAsientos();
		return asientoList;
	}

	@Override
	public Asiento getAsientoById(Integer idViaje, Integer idPasajero) {
		// TODO Auto-generated method stub
		Asiento asiento = asientoDAO.getAsientoById(idViaje, idPasajero);
		return asiento;
	}

	@Override
	public Asiento addAsiento(Asiento asiento) {
		// TODO Auto-generated method stub
		Asiento addedAsiento = asientoDAO.addAsiento(asiento);
		return addedAsiento;
	}

	@Override
	public Asiento updateAsiento(Asiento asiento) {
		// TODO Auto-generated method stub
		Asiento updatedAsiento = asientoDAO.updateAsiento(asiento);
		return updatedAsiento;
	}

	@Override
	public void deleteAsiento(Integer idViaje, Integer idPasajero) {
		// TODO Auto-generated method stub
		asientoDAO.deleteAsiento(idViaje, idPasajero);
	}

}
